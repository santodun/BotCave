package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.Elevator;
import org.usfirst.frc.team1289.robot.subsystems.ElevatorPosition;
import org.usfirst.frc.team1289.robot.subsystems.Lighting;
import org.usfirst.frc.team1289.robot.subsystems.LightingColor;
import org.usfirst.frc.team1289.robot.OperatingParameters;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class ElevateViaStick extends Command {

	private Elevator _elevator;
	private Joystick _stick;
	private Lighting _lighting;
	private OperatingParameters _parameters;
	private Timer _timer;
	
    public ElevateViaStick(Elevator elevator, Joystick stick, Lighting lighting, OperatingParameters parameters) 
    {
    	_elevator = elevator;
    	_stick = stick;
    	_parameters = parameters;
    	_lighting = lighting;
    	_timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_elevator.Stop();
    	_timer.reset();
    	_timer.start();
    	
    	_lighting.SetColor(LightingColor.RED);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double speed = -_stick.getY();
    //	boolean atUpperLimit = false;
    	double elevatorSpeedThreshold = _parameters.ElevatorThresholdSpeed();
    
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
    	
    	if (speed < - elevatorSpeedThreshold)
    		speed = -1.0;
    	else if (speed > elevatorSpeedThreshold)
    		speed = 1.0;
    	else speed = speed;
    	
		if (_elevator.LastKnownPosition() == ElevatorPosition.ABOVESWITCH)
    		_lighting.SetColor(LightingColor.GREEN);
    	else if (_elevator.LastKnownPosition() == ElevatorPosition.BELOWSWITCH)
    		_lighting.SetColor(LightingColor.RED);
    	else
    		_lighting.SetColor(LightingColor.BLUE);
    	
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
