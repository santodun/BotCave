package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team1289.robot.OperatingParameters;
import org.usfirst.frc.team1289.robot.commands.GrabberDirection;


/**
 *
 */

public class Grabber extends Subsystem
{
	private static OperatingParameters _parameters;
	private static SpeedController _openCloseMotor;
	private static DigitalInput _leftBreaker;
	private static DigitalInput _rightBreaker;
	private static boolean _leftBreakerState;
	private static boolean _rightBreakerState;
	private static final boolean BREAKERCLOSED = true;
	private static final boolean BREAKEROPEN = false;
		
	public Grabber(SpeedController openCloseMotor, DigitalInput leftBreaker, DigitalInput rightBreaker, OperatingParameters parameters)
	{
		_openCloseMotor  = openCloseMotor;
		_leftBreaker = leftBreaker;
		_rightBreaker = rightBreaker;
		_parameters = parameters;
		
		StopAllMotors();
		_leftBreakerState = IsLeftBreakerClosed();
		_rightBreakerState = IsRightBreakerClosed();
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

	public void ActuateGrabber(GrabberDirection direction)
	{		
		boolean okToMove = false;
		
		double speed = _parameters.GrabberSpeed();
		if (direction == GrabberDirection.CLOSE)
			speed = - speed;
		
//		_leftBreakerState = IsLeftBreakerClosed();
//		_rightBreakerState = IsRightBreakerClosed();
//		
//		if (_leftBreakerState == BREAKEROPEN && _rightBreakerState == BREAKEROPEN)
//			okToMove = true;
//		if (_leftBreakerState == BREAKERCLOSED && _rightBreakerState == BREAKEROPEN)
//				//&& direction == GrabberDirection.CLOSE)
//			okToMove = true;
//		if (_leftBreakerState == BREAKEROPEN && _rightBreakerState == BREAKERCLOSED)
//				//&& direction == GrabberDirection.OPEN)
//			okToMove = true;
//			
//		if (okToMove)
			_openCloseMotor.set(speed);
		
	}

//	public boolean IsDone()
//	{
//		boolean leftBreakerCurrentState = IsLeftBreakerClosed();
//		boolean rightBreakerCurrentState = IsRightBreakerClosed();
//		boolean isDone = false;
//		
//		if (_leftBreakerState == BREAKEROPEN && leftBreakerCurrentState == BREAKERCLOSED)
//		{
//			System.out.println("left tripped");
//			_leftBreakerState = BREAKERCLOSED;
//			isDone = true;
//		}
//			
//		if (_rightBreakerState == BREAKEROPEN && rightBreakerCurrentState == BREAKERCLOSED)
//		{
//			System.out.println("right tripped");
//			_rightBreakerState = BREAKERCLOSED;
//			isDone = true;
//		}
//			
//		return isDone;
//	}
	
		
	public void StopOpenCloseActuation()
	{
		_openCloseMotor.stopMotor();
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

