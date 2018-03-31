
package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveViaStick extends Command 
{
	private static DriveTrain _driveTrain;
	private static JoystickButton _halfSpeedButton;
	
    public DriveViaStick(DriveTrain drivetrain, JoystickButton halfSpeedButton)
    {
    	_driveTrain = drivetrain;
    	_halfSpeedButton = halfSpeedButton;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	_driveTrain.Reset();
	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	boolean halfSpeedMode = _halfSpeedButton.get();
    	_driveTrain.StickDrive(halfSpeedMode);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
	      return false;
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
