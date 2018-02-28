package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ElevateViaStick extends Command {

	private Elevator _elevator;
	private Joystick _stick;
	private Timer _timer;
	
    public ElevateViaStick(Elevator elevator, Joystick stick) 
    {
    	_elevator = elevator;
    	_stick = stick;
    	_timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_elevator.Stop();
    	_timer.reset();
    	_timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double speed = -_stick.getY();
    	boolean atUpperLimit = false;
    	//System.out.println(_timer.getMatchTime());
    	//System.out.println(_timer.get());
    	
    	if (_timer.get() < 20.0)
    	//if (_timer.getMatchTime() < 2.25) // 2:15 - ie :15sec left in the match
    		atUpperLimit = _elevator.IsAtSwitch();
    	else
    		atUpperLimit = _elevator.IsAtMax();
    	
    	//System.out.println(speed);
    	if (atUpperLimit && speed > 0)
    	{
    		_elevator.Stop();
    		return;
    	}
    	if (_elevator.IsAtMin() && speed < 0)
    	{
    		_elevator.Stop();
    		return;
    	}
    	
    	_elevator.Move(speed);  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
