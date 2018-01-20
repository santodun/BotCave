package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;

/**
 *
 */
public class AutoCenterLeft extends CommandGroup {

    public AutoCenterLeft(DriveTrain dt) {
    	addSequential(new DriveToDistance(dt, 1.0, 12.0));

    }
}