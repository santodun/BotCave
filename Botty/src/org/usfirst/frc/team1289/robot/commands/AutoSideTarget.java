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
	    	int heading = operatingParameters.AutoSideInitialHeading();
	    	int arc = operatingParameters.AutoSideFinalHeading();
	    	RotationDirection secondRotationDirection;
	    	double speed = operatingParameters.AutoSpeed();
	    	double firstLastLegDistance = operatingParameters.AutoSideFirstDistance();
	    	double middleLegDistance = operatingParameters.AutoSideMiddleDistance();
	    	double lastLegDistance = operatingParameters.AutoSideFinalLegDistance();
	    	
	    	if (initialDirection == RotationDirection.CLOCKWISE)
	    	{
	    		secondRotationDirection = RotationDirection.COUNTERCLOCKWISE;
	    		System.out.println("initial clockwise");
	    		arc = - arc;
	    	}
	    	else
	    	{
	    		heading = - heading;
	    		secondRotationDirection = RotationDirection.CLOCKWISE;
	    		System.out.println("initial counter clockwise");
	    	}
	    	
	    		
	    	//addSequential(new ActuateRetractor(retractor, RetractorDirection.DOWN, operatingParameters));
	    	//addSequential(new DriveToDistance(dt, speed, firstLastLegDistance));
	    	//addSequential(new Rotate(dt, initialDirection, heading));
	    	addSequential(new DriveAndLift(dt, elevator, elevatorPosition, speed, middleLegDistance, operatingParameters));
	    	//addSequential(new Rotate(dt, secondRotationDirection, arc));//- heading));
	    	//addSequential(new DriveToDistance(dt, speed, lastLegDistance));
	    	//addSequential(new GrabberCommand(grabber, GrabberDirection.SPEW, operatingParameters));
	    	
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
