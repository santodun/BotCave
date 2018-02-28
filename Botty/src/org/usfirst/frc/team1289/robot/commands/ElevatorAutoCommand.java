package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.subsystems.Elevator;
import org.usfirst.frc.team1289.robot.subsystems.ElevatorPosition;
import org.usfirst.frc.team1289.robot.OperatingParameters;

import edu.wpi.first.wpilibj.command.Command;




/**
 *
 */
public class ElevatorAutoCommand extends Command 
{
	private static Elevator _elevator;
	private static ElevatorPosition _targetPosition;
	private static OperatingParameters _operatingParameters;
	private ElevatorDirection _direction;

    public ElevatorAutoCommand(Elevator elevator, ElevatorPosition elevatorTargetPosition, OperatingParameters operatingParameters) 
    {
    	_elevator = elevator;
    	_targetPosition = elevatorTargetPosition;
    	_operatingParameters = operatingParameters;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
	    _elevator.Stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	ElevatorPosition lastPosition = _elevator.LastKnownPosition();
    	double speed = _operatingParameters.ElevatorSpeed();
    	
    	System.out.printf("%d %d %f\n", _targetPosition.ordinal(), lastPosition.ordinal(), speed);
    	if (_targetPosition.ordinal() > lastPosition.ordinal())
    	{
    		_direction = ElevatorDirection.UP;
    		speed =  speed;
    	}	
    	else
    	{
    		speed = - speed;
    		_direction = ElevatorDirection.DOWN;
    	}

    	_elevator.Move(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (_targetPosition == ElevatorPosition.SCALE)
    	{
    		if (_elevator.IsAtScale())
    			return true;
    	}
    	
    	if (_targetPosition == ElevatorPosition.SWITCH)
    	{
    		if (_elevator.IsAtSwitch())
    			return true;
    	}
    	
    	if (_elevator.IsAtMax() && _elevator.GetCurrentSpeed() > 0)
    		return true;
    	else if (_elevator.IsAtMin() && _elevator.GetCurrentSpeed() < 0)
    		return true;			
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	_elevator.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
