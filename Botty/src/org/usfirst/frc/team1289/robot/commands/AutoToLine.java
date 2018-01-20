package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;


/**
 *
 */
public class AutoToLine extends CommandGroup {

    public AutoToLine(DriveTrain dt) {
    	addSequential(new DriveToDistance(dt, 0.1, 12.0));

    }
}
