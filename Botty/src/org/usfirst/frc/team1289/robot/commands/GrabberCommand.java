package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1289.robot.subsystems.Grabber;

/**
 *
 */
public class GrabberCommand extends Command 
{

	Grabber _grabber;
	JoystickButton _button;
	boolean _isDone = false;
	
    public GrabberCommand(Grabber grabber, JoystickButton grabberButton) 
    {
    	_grabber = grabber;
    	_button = grabberButton;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	//System.out.println("grabbercommand");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//System.out.println(_button.get());
    	if (_button.get())
    		_grabber.ActuateGrabber();
    	
    	if (_grabber.IsDone())
    	{
    		_grabber.StopOpenCloseActuation();
    	//	_isDone = true;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return _isDone;
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
