package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;


/**
 *
 */
public class Retractor extends Subsystem 
{
	private static SpeedController _motor;
	private static DigitalInput _breaker;
	

    public Retractor(SpeedController motor, DigitalInput breaker)
    {
    	_motor = motor;
    	_breaker = breaker;
    }

    public void Move(double speed)
    {
    	_motor.set(speed);
    }
    
    public void Stop()
    {
    	_motor.stopMotor();
    }
    
    public boolean IsAtLimit()
    {
    	return ! _breaker.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

