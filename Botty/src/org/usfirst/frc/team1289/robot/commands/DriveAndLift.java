package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1289.robot.subsystems.Gyroscope;
import org.usfirst.frc.team1289.robot.subsystems.LimitSwitch;
import org.usfirst.frc.team1289.robot.subsystems.RangeFinder;
import org.usfirst.frc.team1289.robot.subsystems.SimpleMotor;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndLift extends CommandGroup 
{

    public DriveAndLift(DriveTrain driveTrain, SimpleMotor elevatorMotor, LimitSwitch limitSwitch, 
			ElevatorDirection elevatorDirection, double targetSpeed, double targetDistance) 
    {
    	addParallel(new DriveToDistance(driveTrain, targetSpeed, targetDistance));
		addParallel(new ElevatorCommand(elevatorMotor, limitSwitch, elevatorDirection));

    }
}
