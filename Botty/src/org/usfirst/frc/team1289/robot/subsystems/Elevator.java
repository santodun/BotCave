package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem 
{
	private static SimpleMotor _motor;
	private static LimitSwitch _maxLimit;
	private static LimitSwitch _minLimit;
	
	public Elevator(SimpleMotor motor, LimitSwitch maxLimitSwitch, LimitSwitch minLimitSwitch)
	{
		_motor = motor;
		_maxLimit = maxLimitSwitch;
		_minLimit = minLimitSwitch;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean IsAtMax()
    {
    	return _maxLimit.Closed();
    }
    
    public boolean IsAtMin()
    {
    	return _minLimit.Closed();
    }
    
    public void Move(double speed)
    {
    	_motor.Move(speed);
    }
    
    public void Stop()
    {
    	_motor.Stop();
    }
    
}

