package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogInput;

public class RangeFinder extends Subsystem 
{
	private static AnalogInput _rangeFinder;
	
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
		return (int) Math.round(range); 
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

