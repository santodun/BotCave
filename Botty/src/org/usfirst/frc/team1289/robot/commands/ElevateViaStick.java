package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 */
public class ElevateViaStick extends Command {

	private Elevator _elevator;
	private Joystick _stick;
	
    public ElevateViaStick(Elevator elevator, Joystick stick) 
    {
    	_elevator = elevator;
    	_stick = stick;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_elevator.Stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double speed = _stick.getY();
    	
    	if (speed > -0.1 && speed < 0.1)
    	{
    		_elevator.Stop();
    		return;
    	}
    	
    	if (_elevator.IsAtMax() && speed > 0)
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
