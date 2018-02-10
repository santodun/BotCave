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
	private static ElevatorPosition _lastKnownPosition;
	
	public Elevator(SpeedController motor, DigitalInput maxLimitSwitch, DigitalInput minLimitSwitch,
						DigitalInput scaleLimitSwitch, DigitalInput switchLimitSwitch)
	{
		_motor = motor;
		_maxLimit = maxLimitSwitch;
		_minLimit = minLimitSwitch;
		_switchLimit = switchLimitSwitch;
		_scaleLimit = scaleLimitSwitch;
		_lastKnownPosition = ElevatorPosition.MIN;
		//_motor.setInverted(true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean IsAtMax()
    {
    	_lastKnownPosition = ElevatorPosition.MAX;
    	return ! _maxLimit.get();
    }
    
    public boolean IsAtMin()
    {
    	_lastKnownPosition = ElevatorPosition.MIN;
    	return ! _minLimit.get();
    }
    
    public boolean IsAtSwitch()
    {
    	_lastKnownPosition = ElevatorPosition.SWITCH;
    	return ! _switchLimit.get();
    }
    
    public boolean IsAtScale()
    {
    	_lastKnownPosition = ElevatorPosition.SCALE;
    	return ! _scaleLimit.get();
    }
    
    public ElevatorPosition LastKnownPosition()
    {
    	return _lastKnownPosition;
    }
    
    public void Move(double speed)
    {
    	double scaledSpeed = 0.0;
    	
    	if (speed > -0.1 && speed < 0.1)
    		scaledSpeed = 0.0;
    	else if (speed > .4)
    		scaledSpeed = .4;
    	else if (speed < -.4)
    		scaledSpeed = -.4;
    	else
    		scaledSpeed = speed;
    	
    	_motor.set(scaledSpeed);
    }
    
    public void Stop()
    {
    	_motor.stopMotor();
    }
    
    public double GetCurrentSpeed()
    {
    	return _motor.get();
    }
}

