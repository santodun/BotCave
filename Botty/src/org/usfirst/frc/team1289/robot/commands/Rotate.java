package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1289.robot.subsystems.Gyroscope;


/**
 *
 */
public class Rotate extends Command {
	private Gyroscope _gyro;
	private DriveTrain _driveTrain;
	private RotationDirection _direction;
	private int _targetDegrees;
	
	    public Rotate(DriveTrain dt, Gyroscope gyro, RotationDirection direction, int degrees) {
    	_gyro = gyro;
    	_driveTrain = dt;
    	_direction = direction;
    	_targetDegrees = degrees;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_driveTrain.Stop();
    	_gyro.Reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	_driveTrain.Rotate(_direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	boolean done = false;
    	
    	double heading = _gyro.GetHeading();
    	System.out.printf("Heading %f\n", heading);
    	
    	if (_direction == RotationDirection.CLOCKWISE)
    		if (heading > _targetDegrees)
    			done = true;
    	else
    		if (heading < _targetDegrees)
    			done = true;
    	
    	return done;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	_driveTrain.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
