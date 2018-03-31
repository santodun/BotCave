package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1289.robot.subsystems.Elevator;
import org.usfirst.frc.team1289.robot.subsystems.ElevatorPosition;
import org.usfirst.frc.team1289.robot.OperatingParameters;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndLift extends CommandGroup 
{
    public DriveAndLift(DriveTrain driveTrain, Elevator elevator, ElevatorPosition targetPosition,
			double targetSpeed, double targetDistance, OperatingParameters operatingParameters) 
    {
    	addParallel(new DriveToDistance(driveTrain, targetSpeed, targetDistance));
		//addParallel(new ElevatorAutoCommand(elevator, targetPosition, operatingParameters));
    }
}
