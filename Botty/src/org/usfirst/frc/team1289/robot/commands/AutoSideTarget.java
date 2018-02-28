package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.*;
import org.usfirst.frc.team1289.robot.OperatingParameters;

/**
 *
 */
public class AutoSideTarget extends CommandGroup
{
	public AutoSideTarget(DriveTrain driveTrain, Elevator elevator,	ElevatorPosition elevatorPosition,  
							RotationDirection rotateDirection,  OperatingParameters operatingParameters,
							Grabber grabber) 
	{
		int degrees = 0;
		double targetDistance;
		double targetSpeed = operatingParameters.AutoSpeed();
		
		if (rotateDirection == RotationDirection.CLOCKWISE)
			degrees = operatingParameters.DriveTrainRotationArc();
		else
			degrees = - operatingParameters.DriveTrainRotationArc();
		
		if (elevatorPosition == ElevatorPosition.SCALE)
			targetDistance = operatingParameters.ScaleDistance();
		else 
			targetDistance = operatingParameters.SwitchDistance();
		
	//	addSequential(new ActuateRetractor(retractor, RetractorDirection.DOWN));
		addSequential(new DriveAndLift(driveTrain, elevator, 
				elevatorPosition, targetSpeed, targetDistance, operatingParameters));
		addSequential(new Rotate(driveTrain, rotateDirection, degrees));
		addSequential(new DriveToDistance(driveTrain, 0.2, 10));
		//addSequential(new AutoGrabberCommand(grabber));

    }
}
