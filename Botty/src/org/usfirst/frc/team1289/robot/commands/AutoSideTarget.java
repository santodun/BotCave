package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.*;
import org.usfirst.frc.team1289.robot.OperatingParameters;

/**
 *
 */
public class AutoSideTarget extends CommandGroup
{
	  public AutoSideTarget(DriveTrain dt, RotationDirection initialDirection, Elevator elevator,
	    		ElevatorPosition elevatorPosition, OperatingParameters operatingParameters, Grabber grabber,
	    		Retractor retractor) 
	    {
	    	int heading = 10; //operatingParameters.AutoCenterRotate();
	    	RotationDirection secondRotationDirection;
	    	double speed = operatingParameters.AutoSpeed();
	    	double firstLastLegDistance = 12.0; //operatingParameters.AutoCenterFirstLastLegDistance();
	    	double middleLegDistance = 370.0; //operatingParameters.AutoCenterMiddleLegDistance();
	    	
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
	    	addSequential(new DriveToDistance(dt, speed, firstLastLegDistance));
	    	addSequential(new Rotate(dt, initialDirection, heading));
	    	//addSequential(new DriveAndLift(dt, elevator, elevatorPosition, speed, middleLegDistance, operatingParameters));
	    	addSequential(new DriveToDistance(dt, speed, middleLegDistance));
	    	addSequential(new Rotate(dt, secondRotationDirection, - (5 + heading + operatingParameters.DriveTrainRotationArc())));//- heading));
	    	addSequential(new DriveToDistance(dt, speed, 20.0));
	    	addSequential(new ElevatorAutoCommand(elevator, elevatorPosition, operatingParameters));
	    	addSequential(new GrabberCommand(grabber, GrabberDirection.OPEN));
	    	
//	public AutoSideTarget(DriveTrain driveTrain, Elevator elevator,	ElevatorPosition elevatorPosition,  
//							RotationDirection rotateDirection,  OperatingParameters operatingParameters,
//							Grabber grabber) 
//	{
//		int degrees = 0;
//		double targetDistance;
//		double targetSpeed = operatingParameters.AutoSpeed();
//		double finalLegDistance = operatingParameters.AutoSideFinalLegDistance();
//		
//		if (rotateDirection == RotationDirection.CLOCKWISE)
//			degrees = operatingParameters.DriveTrainRotationArc();
//		else
//			degrees = - operatingParameters.DriveTrainRotationArc();
//		
//		if (elevatorPosition == ElevatorPosition.SCALE)
//			targetDistance = operatingParameters.ScaleDistance();
//		else 
//			targetDistance = operatingParameters.SwitchDistance();
//		
//		addSequential(new ActuateRetractor(retractor, RetractorDirection.DOWN));
//		addSequential(new DriveAndLift(driveTrain, elevator, 
//				elevatorPosition, targetSpeed, targetDistance, operatingParameters));
//		addSequential(new Rotate(driveTrain, rotateDirection, degrees));
//		addSequential(new DriveToDistance(driveTrain, targetSpeed, finalLegDistance));
//		addSequential(new GrabberCommand(grabber, GrabberDirection.OPEN));


    }
}
