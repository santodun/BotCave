package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;

public class Accelerometer extends Subsystem 
{
	private static BuiltInAccelerometer _accelerometer;
	
	public Accelerometer()
	{
		_accelerometer = new BuiltInAccelerometer();
	}

	public double Get_X()
	{
		return _accelerometer.getX();
	}
	
	public double Get_Y()
	{
		return _accelerometer.getY();
	}
	
	public double Get_Z()
	{
		return _accelerometer.getZ();
	}
		
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
