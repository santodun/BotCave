package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class LimitSwitch extends Subsystem 
{
	private DigitalInput _switch;
	
	public LimitSwitch(int io_switch)
	{
		_switch = new DigitalInput(io_switch);
	}

	public boolean Closed()
	{
		return ! _switch.get();
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
