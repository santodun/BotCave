package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
/**
 *
 */

public class Grabber extends Subsystem
{
	private static SpeedController _openCloseMotor;
	private static DigitalInput _leftBreaker;
	private static DigitalInput _rightBreaker;
	private static boolean _grabberIsClosed = true;
		
	public Grabber(SpeedController openCloseMotor, DigitalInput leftBreaker, DigitalInput rightBreaker)
	{
		_openCloseMotor  = openCloseMotor;
		_leftBreaker = leftBreaker;
		_rightBreaker = rightBreaker;_leftBreaker = leftBreaker;

		StopAllMotors();
	}
	
	public boolean IsLeftBreakerClosed()
	{
		return ! _leftBreaker.get();
	}

	public boolean IsRightBreakerClosed()
	{
		return ! _rightBreaker.get();
	}
	
	public void StopAllMotors()
	{
		_openCloseMotor.stopMotor();
	}
	
	public void ActuateGrabber()
	{
		if (_grabberIsClosed)
		{
			// open
			_openCloseMotor.set(0.3);
			_grabberIsClosed = false;
		}
		else
		{
			// closed
			_openCloseMotor.set(-0.3);
			_grabberIsClosed = true;
		}
	}
		
	public void StopOpenCloseActuation()
	{
		_openCloseMotor.stopMotor();
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

