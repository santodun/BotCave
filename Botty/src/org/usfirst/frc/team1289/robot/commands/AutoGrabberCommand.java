package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.Grabber;

/**
 *
 */
public class AutoGrabberCommand extends Command 
{

	Grabber _grabber;
	
    public AutoGrabberCommand(Grabber grabber) 
    {
    	_grabber = grabber;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	//System.out.println("grabbercommand");
    //	_grabber.SetGrabberInitialState(GrabberState.CLOSED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//_grabber.ActuateGrabber(_direction????);    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false; //_grabber.IsDone();
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	_grabber.StopAllMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
