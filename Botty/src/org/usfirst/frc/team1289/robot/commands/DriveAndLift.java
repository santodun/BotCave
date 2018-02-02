package org.usfirst.frc.team1289.robot.commands;

import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1289.robot.subsystems.Gyroscope;
import org.usfirst.frc.team1289.robot.subsystems.LimitSwitch;
import org.usfirst.frc.team1289.robot.subsystems.RangeFinder;
import org.usfirst.frc.team1289.robot.subsystems.SimpleMotor;
import org.usfirst.frc.team1289.robot.OperatingParameters;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndLift extends CommandGroup 
{

    public DriveAndLift(DriveTrain driveTrain, SimpleMotor elevatorMotor, RangeFinder rangeFinder,
    		LimitSwitch minBreaker, LimitSwitch  maxBreaker, ElevatorPosition targetPosition,
			double targetSpeed, double targetDistance, OperatingParameters operatingParameters) 
    {
    	addParallel(new DriveToDistance(driveTrain, targetSpeed, targetDistance));
		addParallel(new ElevatorAutoCommand(elevatorMotor, rangeFinder, 
    			minBreaker, maxBreaker, targetPosition, operatingParameters));
    }
}
