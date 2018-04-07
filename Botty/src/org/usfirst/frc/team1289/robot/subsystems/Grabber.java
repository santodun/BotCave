package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team1289.robot.OperatingParameters;
import org.usfirst.frc.team1289.robot.commands.GrabberDirection;


/**
 *
 */

public class Grabber extends Subsystem
{
	private static OperatingParameters _parameters;
	private static SpeedController _leftMotor;
	private static SpeedController _rightMotor;
//	private static DigitalInput _leftBreaker;
//	private static DigitalInput _rightBreaker;
	private static Timer _timer;
//	private static boolean _leftBreakerState;
//	private static boolean _rightBreakerState;
//	private static final boolean BREAKERCLOSED = true;
//	private static final boolean BREAKEROPEN = false;
//		
	public Grabber(SpeedController leftMotor, SpeedController rightMotor, /*DigitalInput leftBreaker, DigitalInput rightBreaker,*/ OperatingParameters parameters)
	{
		_leftMotor  = leftMotor;
		_rightMotor  = rightMotor;
//		_leftBreaker = leftBreaker;
//		_rightBreaker = rightBreaker;
		_parameters = parameters;
		_timer = new Timer();
		System.out.println("new grabber subsystem");
		StopAllMotors();
//		_leftBreakerState = IsLeftBreakerClosed();
//		_rightBreakerState = IsRightBreakerClosed();
	}
	
//	public boolean IsLeftBreakerClosed()
//	{
//		boolean breakerState = ! _leftBreaker.get();
//	
//		if (breakerState == BREAKERCLOSED)
//		{
//			_timer.reset();
//			_timer.start();
//			_timer.delay(0.001); // 1ms
//			breakerState = ! _leftBreaker.get();
//		}
//		return breakerState;
		
//		return ! _leftBreaker.get();
//	}

//	public boolean IsRightBreakerClosed()
//	{
//		boolean breakerState = ! _rightBreaker.get();
//		
//		if (breakerState == BREAKERCLOSED)
//		{
//			_timer.reset();
//			_timer.start();
//			_timer.delay(0.001); // 1ms
//			breakerState = ! _rightBreaker.get();
//		}
//		return breakerState;
	
//		return ! _rightBreaker.get();
//	}
	
	public void StopAllMotors()
	{
		System.out.println("stopping motors");
		_leftMotor.stopMotor();
		_rightMotor.stopMotor();
	}

	public void ActuateGrabber(GrabberDirection direction)
	{		
		//boolean okToMove = false;
		
		double speed = _parameters.GrabberSpeed();
		double leftSpeed, rightSpeed;
		
		if (direction == GrabberDirection.INGEST)
		{
			leftSpeed = speed;
			rightSpeed = - speed;
		} 
		else
		{
			leftSpeed = - speed;
			rightSpeed = speed;
		}
		
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
			_leftMotor.set(leftSpeed);
			_rightMotor.set(rightSpeed);
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
		_leftMotor.stopMotor();
		_rightMotor.stopMotor();
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

