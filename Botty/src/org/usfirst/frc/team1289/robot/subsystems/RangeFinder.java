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

	public int GetRangeInMM()
	{
		return (int) Math.round(5 * _rangeFinder.getAverageVoltage()/(4.88/1000.0));
	}

	
	public double GetRangeInInches()
	{
		int mm = GetRangeInMM();
		return mm / 25.4; 
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

