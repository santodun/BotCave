package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.OperatorInterface;
import org.usfirst.frc.team1289.robot.subsystems.SimpleMotor;
import org.usfirst.frc.team1289.robot.subsystems.LimitSwitch;

import edu.wpi.first.wpilibj.command.Command;




/**
 *
 */
public class ElevatorCommand extends Command 
{
	private static LimitSwitch _limitSwitch;
	private static SimpleMotor _motor;
	private ElevatorDirection _direction;

    public ElevatorCommand(SimpleMotor motor, LimitSwitch sw, ElevatorDirection direction) 
    {
    	_motor = motor;
    	_direction = direction;
    	_limitSwitch = sw;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_motor.Stop();
    	_motor.Reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if (_direction == ElevatorDirection.UP)
    		_motor.Raise();
    	else 
    		_motor.Lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	boolean rtn;
    	if (_limitSwitch.Closed())
    	{
    		rtn = true;
    	//	System.out.printf("Switch is closed\n");
    	}
    	else 
    	{
    		//System.out.printf("open, direction: %s\n", _direction);
    		rtn = false;
    	}
    	
    	return rtn;
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
