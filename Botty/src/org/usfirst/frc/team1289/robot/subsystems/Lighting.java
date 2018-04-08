package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SpeedController;

/**
 */
public class Lighting extends Subsystem 
{
	SpeedController _leds;
	
	public Lighting(SpeedController leds)
	{
		_leds = leds;
	}
	
	public void SetColor(LightingColor color)
	{
		if (color == LightingColor.RED)
		{
			_leds.set(0.61);
			
			SmartDashboard.putBoolean("DB/LED 0", true);
			SmartDashboard.putBoolean("DB/LED 1", false);
			SmartDashboard.putBoolean("DB/LED 2", false);
			
		} else if (color == LightingColor.GREEN)
		{
			_leds.set(0.77);
			
			SmartDashboard.putBoolean("DB/LED 0", false);
			SmartDashboard.putBoolean("DB/LED 1", true);
			SmartDashboard.putBoolean("DB/LED 2", false);
			
		} else if (color == LightingColor.BLUE)
		{
			_leds.set(0.87);
			
			SmartDashboard.putBoolean("DB/LED 0", false);
			SmartDashboard.putBoolean("DB/LED 1", false);
			SmartDashboard.putBoolean("DB/LED 2", true);
		} else
		{
			_leds.set(0.25);
			
			SmartDashboard.putBoolean("DB/LED 0", true);
			SmartDashboard.putBoolean("DB/LED 1", true);
			SmartDashboard.putBoolean("DB/LED 2", true);
		}
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

