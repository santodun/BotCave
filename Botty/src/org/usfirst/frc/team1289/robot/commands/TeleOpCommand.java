package org.usfirst.frc.team1289.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TeleOpCommand extends CommandGroup {

    public TeleOpCommand(Command elevator, Command driveTrain) 
    {
        addParallel(elevator);
        addParallel(driveTrain);
    }
}
