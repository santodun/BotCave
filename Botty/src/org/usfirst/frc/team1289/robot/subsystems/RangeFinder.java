package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

import java.util.*;

public class RangeFinder extends Subsystem 
{
	private static AnalogInput _rangeFinder;
	Queue<Double> _rangeQueue = new LinkedList<Double>();
	private int _queueSize = 50;
	double _averageRange = 5000.0;
	
	
	
	public RangeFinder(int io_ranger)
	{
		_rangeFinder = new AnalogInput(io_ranger);
		_rangeFinder.setAverageBits(2);
		_rangeFinder.setOversampleBits(4);
	}

	public double GetRangeInMM()
	{
		double slope = 1055.223;
		double intercept = - 17.2288 ;
		double volts = _rangeFinder.getAverageVoltage();
		double range = slope * volts + intercept;
		//double range = 5 * (volts/(4.88/1000.0)); // 17.02 mV
		//System.out.printf("%f %f\n", volts, range);
		
		if (_rangeQueue.size() < _queueSize)
    		_rangeQueue.add(range);
    	else
    		if (_rangeQueue.size() == _queueSize)
    		{
    			_rangeQueue.remove();
    			_rangeQueue.add(range);
    			_averageRange = GetAverageRange();
    		}
    	
		return (int) Math.round(_averageRange); 
	}

	  private double GetAverageRange()
	    {
	    	double returnValue = 0.0;
	    	ArrayList arrayList = new ArrayList(_rangeQueue);
	    	
	    	for (int i = 0; i < arrayList.size(); i++)
	    	{
	    		returnValue = returnValue + (double)arrayList.get(i);
	    	}
	    	
	    	return returnValue / _rangeQueue.size();
	    	
	    }
	
	public double GetRangeInInches()
	{
		double mm = GetRangeInMM();
		return mm / 25.4; 
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

