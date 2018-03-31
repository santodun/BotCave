package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team1289.robot.OperatingParameters;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1289.robot.subsystems.Grabber;
import org.usfirst.frc.team1289.robot.subsystems.Retractor;


/**
 *
 */
public class AutoToLine extends CommandGroup {

    public AutoToLine(DriveTrain dt, OperatingParameters operatingParameters, Grabber grabber, Retractor retractor) 
    {
    	//addSequential(new ActuateRetractor(retractor, RetractorDirection.DOWN, operatingParameters));
    	addSequential(new DriveToDistance(dt, operatingParameters.AutoSpeed(), operatingParameters.AutoLineDistance()));

    }
}
