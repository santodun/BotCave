package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.*;
import org.usfirst.frc.team1289.robot.OperatingParameters;


/**
 *
 */
public class AutoCenterTarget extends CommandGroup {

    public AutoCenterTarget(DriveTrain dt, RotationDirection initialDirection, Elevator elevator,
    		ElevatorPosition elevatorPosition, OperatingParameters operatingParameters, Grabber grabber,
    		Retractor retractor) 
    {
    	int heading = operatingParameters.AutoCenterRotate();
    	RotationDirection secondRotationDirection;
    	double speed = operatingParameters.AutoSpeed();
    	double firstLastLegDistance = operatingParameters.AutoCenterFirstLastLegDistance();
    	double middleLegDistance = operatingParameters.AutoCenterMiddleLegDistance();
    	
    	if (initialDirection == RotationDirection.CLOCKWISE)
    	{
    		secondRotationDirection = RotationDirection.COUNTERCLOCKWISE;
    		System.out.println("initial clockwise");
    	}
    	else
    	{
    		heading = - heading;
    		secondRotationDirection = RotationDirection.CLOCKWISE;
    		System.out.println("initial counter clockwise");
    	}
    	
    		
    	addSequential(new ActuateRetractor(retractor, RetractorDirection.DOWN, operatingParameters));
    	addParallel(new ElevatorAutoCommand(elevator, elevatorPosition, operatingParameters));
    	addSequential(new DriveToDistance(dt, speed, firstLastLegDistance));
    	addSequential(new Rotate(dt, initialDirection, heading));
    	//addSequential(new DriveAndLift(dt, elevator, elevatorPosition, speed, middleLegDistance, operatingParameters));
    	addSequential(new DriveToDistance(dt, speed, middleLegDistance));
    	addSequential(new Rotate(dt, secondRotationDirection, - heading));
    	addSequential(new DriveToDistance(dt, speed, firstLastLegDistance));
    	addSequential(new GrabberCommand(grabber, GrabberDirection.OPEN));
    	

    }
}