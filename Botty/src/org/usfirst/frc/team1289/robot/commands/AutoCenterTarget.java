package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1289.robot.commands.RotationDirection;

/**
 *
 */
public class AutoCenterTarget extends CommandGroup {

    public AutoCenterTarget(DriveTrain dt, RotationDirection direction) {
    	int heading = 0;
    	RotationDirection initialRotationDirection;
    	RotationDirection secondRotationDirection;
    	
    	if (direction == RotationDirection.CLOCKWISE)
    	{
    		heading = 30;
    		initialRotationDirection = direction;
    		secondRotationDirection = RotationDirection.COUNTERCLOCKWISE;
    	}
    	else
    	{
    		heading = -30;
    		initialRotationDirection = direction;
    		secondRotationDirection = RotationDirection.CLOCKWISE;
    	}
    		
    	addSequential(new DriveToDistance(dt, 0.2, 12.0));
    	addSequential(new Rotate(dt, initialRotationDirection, heading));
    	addSequential(new DriveToDistance(dt, 0.3, 100.0));
    	addSequential(new Rotate(dt, secondRotationDirection, - heading));
    	addSequential(new DriveToDistance(dt, 0.2, 12.0));
    	

    }
}