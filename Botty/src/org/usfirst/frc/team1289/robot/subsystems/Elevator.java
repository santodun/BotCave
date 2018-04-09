package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Elevator extends Subsystem 
{
	private static SpeedController _motor;
	private static DigitalInput _maxLimit;
	private static DigitalInput _minLimit;
	private static DigitalInput _scaleLimit;
	private static DigitalInput _switchLimit;
	private static ElevatorPosition _currentPosition;
	private static ElevatorPosition _aboveBelow;
	private static double _speed;
	
	public Elevator(SpeedController motor, DigitalInput maxLimitSwitch, DigitalInput minLimitSwitch,
						DigitalInput scaleLimitSwitch, DigitalInput switchLimitSwitch)
	{
		_motor = motor;
		_maxLimit = maxLimitSwitch;
		_minLimit = minLimitSwitch;
		_switchLimit = switchLimitSwitch;
		_scaleLimit = scaleLimitSwitch;
		_currentPosition = ElevatorPosition.MIN;
		_aboveBelow = ElevatorPosition.BELOWSWITCH;
		_speed = 0.0;
		_motor.setInverted(true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean IsAtMax()
    {
    	return ! _maxLimit.get();
    }
    
    public boolean IsAtMin()
    {
    	return ! _minLimit.get();
    }
    
    public boolean IsAtSwitch()
    {
    	return ! _switchLimit.get();
    }
    
    public boolean IsAtScale()
    {
    	return ! _scaleLimit.get();
    }
    
    public ElevatorPosition LastKnownPosition()
    {
    	return _aboveBelow;
    }
    
    public void Move(double speed)
    {
    	double scaledSpeed = 0.0;
    	boolean foo = true;
    	
    	if (speed > -0.1 && speed < 0.1)
    		scaledSpeed = 0.0;
    	else
    		scaledSpeed = speed;
    	
    	_speed = scaledSpeed;
    //	System.out.println(scaledSpeed);
    	_motor.set(scaledSpeed);
    	
    	if (IsAtScale())
    	{	
    		_currentPosition = ElevatorPosition.SCALE;
    	}
    	else if (IsAtSwitch())
    	{
    		if (_currentPosition == ElevatorPosition.MIN && _aboveBelow == ElevatorPosition.BELOWSWITCH)
    			_aboveBelow = ElevatorPosition.ABOVESWITCH;
    		
    		else if (_currentPosition == ElevatorPosition.SWITCH && _aboveBelow == ElevatorPosition.ABOVESWITCH)
    			_aboveBelow = ElevatorPosition.BELOWSWITCH;
    		else
    			_aboveBelow = ElevatorPosition.ABOVESWITCH;
    		
    		_currentPosition = ElevatorPosition.SWITCH;
    	}
    		
    	else if (IsAtMax())
    	{
    		_currentPosition = ElevatorPosition.MAX;
    	}
    		
    	else if (IsAtMin())
    	{
    		_currentPosition = ElevatorPosition.MIN;
    	}
    		
    	else
    		foo = false; 
    }
    
    public void Stop()
    {
    	_motor.stopMotor();
    }
    
    public double GetCurrentSpeed()
    {
    	return _speed; 
    }
}

