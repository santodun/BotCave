package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.Grabber;

/**
 *
 */
public class GrabberCommand extends Command 
{

	Grabber _grabber;
	GrabberDirection _direction;
	boolean _isDone = false;
	
    public GrabberCommand(Grabber grabber, GrabberDirection direction) 
    {
    	_grabber = grabber;
    	_direction = direction;
    	
    	//System.out.printf("command %d\n", _direction.ordinal());
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	//System.out.println("grabbercommand");
    	//_grabber.SetGrabberInitialState(GrabberState.OPEN);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	_grabber.ActuateGrabber(_direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (_grabber.IsLeftBreakerClosed() && _direction == GrabberDirection.CLOSE)
    		return true;
    	
    	if (_grabber.IsRightBreakerClosed() && _direction == GrabberDirection.OPEN)
    		return true;
    	
    	return false;
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
    	System.out.println("Interupted");
    	_isDone = true;
    }
}
