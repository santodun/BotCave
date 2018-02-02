package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.Grabber;
import org.usfirst.frc.team1289.robot.commands.GrabberDirection;

/**
 *
 */
public class GrabberCommand extends Command 
{

	Grabber _grabber;
	GrabberDirection _direction;
	boolean _done = false;
	
    public GrabberCommand(Grabber grabber, GrabberDirection direction) 
    {
    	_grabber = grabber;
    	_direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_grabber.StopAllMotors();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	_grabber.ActuateGrabber();
    	if (_direction == GrabberDirection.OPEN)
    		_grabber.Eject();
    	else
    		_grabber.Grab();
    	
    	// how do we stop the grabber openclose motor?
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return _done;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	_grabber.StopAllMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
