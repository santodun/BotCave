package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.*;
import org.usfirst.frc.team1289.robot.OperatingParameters;

/**
 *
 */
public class AutoSideTarget extends CommandGroup
{

	public AutoSideTarget(DriveTrain driveTrain, SimpleMotor elevatorMotor, RangeFinder elevatorRangeFinder, 
			LimitSwitch minBreaker, LimitSwitch maxBreaker, ElevatorPosition elevatorPosition,  
		Gyroscope gyro, RangeFinder driveTrainRangeFinder, RotationDirection rotateDirection,
		double targetSpeed, double targetDistance, OperatingParameters operatingParameters) 
	{
		int degrees = 0;
		if (rotateDirection == RotationDirection.CLOCKWISE)
			degrees = 90;
		else
			degrees = -90;
		
		addSequential(new DriveAndLift(driveTrain, elevatorMotor, elevatorRangeFinder, 
				minBreaker, maxBreaker, elevatorPosition, targetSpeed, targetDistance, operatingParameters));
		addSequential(new Rotate(driveTrain, gyro, rotateDirection, degrees));
		addSequential(new DriveUntilDistance(driveTrain, driveTrainRangeFinder, 15));

    }
}
