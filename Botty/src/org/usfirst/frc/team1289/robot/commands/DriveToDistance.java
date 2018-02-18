
package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToDistance extends Command {
	private double _speed;
	private double _distance;
	private static DriveTrain _driveTrain;

    public DriveToDistance(DriveTrain drivetrain, double speed, double distance)
    {
    	this._speed = speed;
    	this._distance = distance;
    	_driveTrain = drivetrain;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_driveTrain.Reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	_driveTrain.Move(_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
		double leftFrontDistance = _driveTrain.GetLeftFrontEncoderDistance();
		double rightFrontDistance = _driveTrain.GetRightFrontEncoderDistance();
		double averageDistance = Math.abs((leftFrontDistance + rightFrontDistance) / 2.0 );
		System.out.printf("%f %f %f\n", leftFrontDistance, rightFrontDistance, averageDistance);
		averageDistance = leftFrontDistance;
		if (averageDistance < _distance)
			return false;
		else
			return true;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	_driveTrain.Reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
}
