package org.usfirst.frc.team1289.robot.commands;

//import org.usfirst.frc.team1289.robot.subsystems.RangeFinder;

//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestCommand extends Command 
{
	//private static SpeedController _motor;
	//private static Timer _timer;
	private boolean _isDone = false;
	private String _textToPrint;
	
	public TestCommand(String text) 
    {
		//_motor = motor;
		//_timer = new Timer();
		_textToPrint = text;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
//    	_timer.reset();
//    	_timer.start();
    	System.out.println(_textToPrint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
//    	_motor.set(0.3);
//    	if (_timer.get() > 5.0)
//    	{
//    		_motor.stopMotor();
//    		_motor.set(-0.3);
//    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	return _isDone;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	//_elevator.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
