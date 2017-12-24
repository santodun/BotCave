package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.OperatorInterface;
import org.usfirst.frc.team1289.robot.Robot;
import org.usfirst.frc.team1289.robot.commands.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WinchRaise extends Command 
{
	private static boolean _isDone = false; 

    public WinchRaise() 
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.winch.Stop();
    	Robot.winch.Reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if (! _isDone)
    		Robot.winch.Raise();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (Robot.winch.IsAtLimit())
    	{
    		//Timer.delay(1.0);
    		_isDone = true;
    	}
    	return _isDone;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.winch.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
