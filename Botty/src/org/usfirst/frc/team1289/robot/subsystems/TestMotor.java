package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TestMotor extends Subsystem 
{
	private static Talon _motor;
		
	public TestMotor(int io_motor)
	{
		_motor = new Talon(io_motor);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Reset()
    {
    }
    
    public void Start() 
    {
    	_motor.set(1.0);
    }
    
    public void Stop()
    {
    	_motor.stopMotor();
    }
    
}

