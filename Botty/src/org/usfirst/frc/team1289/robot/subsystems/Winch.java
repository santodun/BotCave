package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Winch extends Subsystem 
{
	private static Talon _winchMotor;
	private static DigitalInput _limitSwitch;
	
	public Winch(int io_motor, int io_limitswitch)
	{
		_winchMotor = new Talon(io_motor);
		_winchMotor.setInverted(true);
		_limitSwitch = new DigitalInput(io_limitswitch);
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
    
    public void Raise() 
    {
    	_winchMotor.set(1.0);
    }
    
    public void Lower() 
    {
    	_winchMotor.set(-1.0);
    }
    
    public void Stop()
    {
    	_winchMotor.stopMotor();
    }
    
    public boolean IsAtLimit()
    {
    	SmartDashboard.putBoolean("SwitchState", _limitSwitch.get());
    	return ! _limitSwitch.get();
    }
}

