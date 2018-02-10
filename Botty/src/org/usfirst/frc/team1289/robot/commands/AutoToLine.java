package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team1289.robot.OperatingParameters;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;


/**
 *
 */
public class AutoToLine extends CommandGroup {

    public AutoToLine(DriveTrain dt, OperatingParameters operatingParameters) {
    	addSequential(new DriveToDistance(dt, operatingParameters.AutoSpeed(), operatingParameters.AutoLineDistance()));

    }
}
