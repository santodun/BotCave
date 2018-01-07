package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;

public class Gyroscope extends Subsystem 
{
	private static AnalogGyro _gyro;
	
	public Gyroscope(int io_gyro)
	{
		_gyro = new AnalogGyro(io_gyro);
		_gyro.calibrate();
		_gyro.reset();
	}

	//
	// Returns heading in degrees
	// Positive heading is degrees clockwise
	// Negative heading is degrees counterclockwise
	//
	public double GetHeading()
	{
		return _gyro.getAngle();
	}
	
	// rate of rotation in degrees/sec
	public double GetRotationRate()
	{
		return _gyro.getRate();
	}
	
	public void Reset()
	{
		_gyro.reset();
	}
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
