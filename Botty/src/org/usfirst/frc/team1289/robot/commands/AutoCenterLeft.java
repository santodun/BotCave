package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team1289.robot.subsystems.DriveTrain;

/**
 *
 */
public class AutoCenterLeft extends CommandGroup {

    public AutoCenterLeft(DriveTrain dt) {
    	addSequential(new DriveToDistance(dt, 1.0, 12.0));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}