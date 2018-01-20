package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.*;

/**
 *
 */
public class AutoSideTarget extends CommandGroup
{

	public AutoSideTarget(DriveTrain driveTrain, SimpleMotor elevatorMotor, LimitSwitch limitSwitch, 
		Gyroscope gyro, RangeFinder ranger, RotationDirection rotateDirection, ElevatorDirection elevatorDirection,
		double targetSpeed, double targetDistance) 
	{
		addSequential(new DriveAndLift(driveTrain, elevatorMotor, limitSwitch, elevatorDirection, targetSpeed, targetDistance));
		addSequential(new Rotate(driveTrain, gyro, rotateDirection, 90));
		addSequential(new DriveUntilDistance(driveTrain, ranger, 15));

    }
}
