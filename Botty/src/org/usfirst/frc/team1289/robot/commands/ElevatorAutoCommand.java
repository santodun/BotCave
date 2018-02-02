package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.subsystems.SimpleMotor;
import org.usfirst.frc.team1289.robot.subsystems.LimitSwitch;
import org.usfirst.frc.team1289.robot.subsystems.RangeFinder;
import org.usfirst.frc.team1289.robot.OperatingParameters;

import edu.wpi.first.wpilibj.command.Command;




/**
 *
 */
public class ElevatorAutoCommand extends Command 
{
	private static LimitSwitch _maxBreaker;
	private static LimitSwitch _minBreaker;
	private static SimpleMotor _motor;
	private static ElevatorPosition _elevatorPosition;
	private static RangeFinder _rangeFinder;
	private static OperatingParameters _operatingParameters;
	private double _currentHeight= 0;
	private double _targetHeight = 0;
	private ElevatorDirection _direction;

    public ElevatorAutoCommand(SimpleMotor motor, RangeFinder rangeFinder, 
    		LimitSwitch minBreaker, LimitSwitch maxBreaker, 
    		ElevatorPosition elevatorPosition, OperatingParameters operatingParameters) 
      
    {
    	_motor = motor;
    	_elevatorPosition = elevatorPosition;
    	_minBreaker = minBreaker;
    	_maxBreaker = maxBreaker;
    	_rangeFinder = rangeFinder;
    	_operatingParameters = operatingParameters;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_motor.Stop();
    	_motor.Reset();
    	_currentHeight = _rangeFinder.GetRangeInInches();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double targetHeight = 0;
    	
    	switch (_elevatorPosition)
    	{
    	case RUNG:
    	{
    		_targetHeight = _operatingParameters.RungHeight();
    		break;
    	}
    	case SCALE:
    	{
    		_targetHeight = _operatingParameters.ScaleHeight();
    		break;
    	}
    	case SWITCH:
    	{
    		_targetHeight = _operatingParameters.SwitchHeight();
    		break;
    	}
    	case PORTAL:
    	{
    		_targetHeight = _operatingParameters.PortalHeight();
    		break;
    	}
    	case EXCHANGE:
    	{
    		_targetHeight = _operatingParameters.ExchangeHeight();
    		break;
    	}
    	}
    	
    	if (_currentHeight < targetHeight)
    	{
    		_motor.Raise();
    		_direction = ElevatorDirection.UP;
    	}
    	else
    	{
    		_motor.Lower();
    		_direction = ElevatorDirection.DOWN;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (_maxBreaker.Closed() || _minBreaker.Closed())
    		return true;
    	else
    	{
    		double height = _rangeFinder.GetRangeInInches();
    		if (_direction == ElevatorDirection.UP)
    			if (height > _targetHeight)
    				return true;
    		else // direction is down
    			if (height < _targetHeight)
    				return true;
    				
    		return false;
    	}
    
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	_motor.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
