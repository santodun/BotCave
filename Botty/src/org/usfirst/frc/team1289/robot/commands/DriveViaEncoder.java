
package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveViaEncoder extends Command {
	private double _speed;
	private double _distance;

    public DriveViaEncoder(double speed, double distance)
    {
    	requires(Robot.drivetrain);
    	this._speed = speed;
    	this._distance = distance;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.drivetrain.Stop();
    	Robot.drivetrain.ResetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.drivetrain.Move(_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
		double leftDistance = Robot.drivetrain.GetLeftEncoderDistance();
		double rightDistance = Robot.drivetrain.GetRightEncoderDistance();
		double averageDistance = Math.abs((leftDistance + rightDistance) / 2.0);
		
		if (averageDistance < _distance)
			return false;
		else
			return true;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.drivetrain.Stop();
    	Robot.drivetrain.ResetEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
}
