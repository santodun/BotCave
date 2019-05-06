package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc.team1289.robot.subsystems.Grabber;
import org.usfirst.frc.team1289.robot.OperatingParameters;

/**
 *
 */
public class GrabberCommand extends Command 
{

	Grabber _grabber;
	GrabberDirection _direction;
	boolean _isDone;
	Timer _timer;
	OperatingParameters _parameters;
	
    public GrabberCommand(Grabber grabber, GrabberDirection direction, OperatingParameters parameters) 
    {
    	_grabber = grabber;
    	_direction = direction;
    	_parameters = parameters;
    	_timer = new Timer();
    	_isDone = false;
    	
    	//System.out.printf("command %d\n", _direction.ordinal());
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	System.out.println("grabbercommand");
    	//_grabber.SetGrabberInitialState(GrabberState.OPEN);
    	_timer.reset();
    	_timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	_grabber.ActuateGrabber(_direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	//boolean done = false;
//    	if (_grabber.IsLeftBreakerClosed() && _direction == GrabberDirection.CLOSE)
//    	{
//    		System.out.println("left and CLOSE");
//    		return true;
//    	}
//    	
//    	if (_grabber.IsRightBreakerClosed() && _direction == GrabberDirection.OPEN)
//    	{
//    		System.out.println("right and OPEN");
//    		return true;
//    	}
    	
    	boolean done = false;
    	double t = _timer.get();
    	double limit = _parameters.GrabberTimer();
    	
    	//System.out.printf("%f\t%f\n", t, limit);
    	if (t > limit & _direction == GrabberDirection.SPEW)
    	{
    		System.out.println("done");
    		done = true;
    	}
    		
    	return done;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    //	System.out.println("command end");
    	_grabber.StopAllMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	//System.out.println("Interupted");
    	_grabber.StopAllMotors();
    }
}
