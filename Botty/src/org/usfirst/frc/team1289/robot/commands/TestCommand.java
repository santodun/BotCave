package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.subsystems.Switch;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestCommand extends Command 
{
	private static Switch _switch;
	private static Timer _timer;
	private boolean _isDone = false;
	
	public TestCommand(Switch sw) 
    {
		_switch = sw;
		_timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_timer.reset();
    	_timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//System.out.print("RawBits\tVoltage\tAverageBits\tAverageVoltage\n");
    	if (_timer.get() < 60.0)
    	{
    		if (_switch.Closed())
    			System.out.printf("Closed\n");
    		else
    			System.out.printf("Open\n");
    		
    		_timer.delay(1.0);
    	}	else
    		_isDone = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	return _isDone;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	//_motor.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
