package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 */

public class Grabber extends Subsystem
{
	private static SpeedController _openCloseMotor;
	private static DigitalInput _leftBreaker;
	private static DigitalInput _rightBreaker;
	private static GrabberState _state;
	private static boolean _leftBreakerState;
	private static boolean _rightBreakerState;
	private static boolean _tripped = false;
	private static boolean BREAKERCLOSED = true;
	private static boolean BREAKEROPEN = false;
		
	public Grabber(SpeedController openCloseMotor, DigitalInput leftBreaker, DigitalInput rightBreaker)
	{
		_openCloseMotor  = openCloseMotor;
		_leftBreaker = leftBreaker;
		_rightBreaker = rightBreaker;
		_state = GrabberState.CLOSED;
		
		StopAllMotors();
		_leftBreakerState = IsLeftBreakerClosed();
		_rightBreakerState = IsRightBreakerClosed();
	}
	
	private boolean IsLeftBreakerClosed()
	{
		return ! _leftBreaker.get();
	}

	private boolean IsRightBreakerClosed()
	{
		return ! _rightBreaker.get();
	}
	
	public void StopAllMotors()
	{
		_openCloseMotor.stopMotor();
	}
	
	public boolean IsDone()
	{
		boolean leftBreakerCurrentState = IsLeftBreakerClosed();
		boolean rightBreakerCurrentState = IsRightBreakerClosed();
		boolean isDone = false;
		
		//System.out.printf("ISDONE persistent breaker state %s %s\n",  ((Boolean)_leftBreakerState).toString(), 
			//	((Boolean)_rightBreakerState).toString() );
		
		if (_leftBreakerState == BREAKEROPEN && leftBreakerCurrentState == BREAKERCLOSED)
		{
			System.out.println("left tripped");
			_leftBreakerState = BREAKERCLOSED;
			_tripped = true;
			isDone = true;
		}
			
		if (_rightBreakerState == BREAKEROPEN && rightBreakerCurrentState == BREAKERCLOSED)
		{
			System.out.println("right tripped");
			_rightBreakerState = BREAKERCLOSED;
			_tripped = true;
			isDone = true;
		}
			
		return isDone;
	}
	
	public void ActuateGrabber()
	{		
		_leftBreakerState = IsLeftBreakerClosed();
		_rightBreakerState = IsRightBreakerClosed();
		
		if (_leftBreakerState == BREAKEROPEN && _rightBreakerState == BREAKEROPEN)
		{
			System.out.println("both open");
			System.out.printf("Starting Rotation state %d\n", _state.ordinal());
			
			if (_state == GrabberState.CLOSED)
			{
				//System.out.println("rotate closed");
				_openCloseMotor.set(0.3);
			}
				
			else
			{
				//System.out.println("rotate open");
				_openCloseMotor.set(-0.3);
			}
		}
	}
		
	public void StopOpenCloseActuation()
	{
		_openCloseMotor.stopMotor();
		
//		System.out.printf("STOP Final breaker state %s %s\n",  ((Boolean)_leftBreakerState).toString(), 
	//			((Boolean)_rightBreakerState).toString() );
		// if either is closed, don't do anything.
					
		if (! _tripped)
		{
			System.out.println("nothing tripped");
			return;
		}
				
		System.out.println("flip direction");
		if (_state == GrabberState.CLOSED)
			_state = GrabberState.OPEN;
		else
			_state = GrabberState.CLOSED;
		
		System.out.printf("Final Rotation state %d\n", _state.ordinal());
		_tripped = false;
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

