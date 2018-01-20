
package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1289.robot.subsystems.RangeFinder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveUntilDistance extends Command {
	private double _speed = -0.2;
	private double _distance;
	private DriveTrain _driveTrain;
	private RangeFinder _ranger;

    public DriveUntilDistance(DriveTrain drivetrain, RangeFinder ranger, double distance)
    {
    	_distance = distance;
    	_driveTrain = drivetrain;
    	_ranger = ranger;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	System.out.println("drive to range");
    	_driveTrain.Stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	_driveTrain.Move(_speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	double range = _ranger.GetRangeInInches();
    	System.out.printf("%f, %f\n", range, _distance);
		if (range > _distance)
			return false;
		else
			return true;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
      	_driveTrain.Stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    }
}
