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
    	int heading = 30;
    	RotationDirection secondRotationDirection;
    	
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
    	
    		
    	addSequential(new ActuateRetractor(retractor, RetractorDirection.DOWN));
    	addSequential(new DriveToDistance(dt, 0.2, 12.0));
    	addSequential(new Rotate(dt, initialDirection, heading));
    	addSequential(new DriveAndLift(dt, elevator, elevatorPosition, 0.3, 250.0, operatingParameters));
    	//addSequential(new DriveToDistance(dt, 0.3, 250.0));
    	addSequential(new Rotate(dt, secondRotationDirection, - heading));
    	addSequential(new DriveToDistance(dt, 0.2, 20.0));
    	//addSequential(new AutoGrabberCommand(grabber));
    	

    }
}