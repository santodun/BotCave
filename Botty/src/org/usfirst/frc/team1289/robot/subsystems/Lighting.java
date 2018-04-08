package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWM.PeriodMultiplier;

/**
 * blue commented out as this is a fake PWM on the actual assembly, due to 
 * insufficient open PWM ports.
 */
public class Lighting extends Subsystem 
{
	PWM _red;
	PWM _blue;
	PWM _green;

	public Lighting(PWM redChannel, PWM greenChannel, PWM blueChannel)
	{
		_red = redChannel;
		_green = greenChannel;
		_blue = blueChannel;
	
		_red.setPeriodMultiplier(PeriodMultiplier.k1X);
		_green.setPeriodMultiplier(PeriodMultiplier.k1X);
		//_blue.setPeriodMultiplier(PeriodMultiplier.k1X);
	}
	
	public void SetColor(LightingColor color)
	{
		if (color == LightingColor.RED)
		{
			_red.setRaw(0xFF);
			_green.setRaw(0x00);
			//_blue.setRaw(0x00);
			SmartDashboard.putBoolean("DB/LED 0", true);
			SmartDashboard.putBoolean("DB/LED 1", false);
			SmartDashboard.putBoolean("DB/LED 2", false);
			
		} else if (color == LightingColor.GREEN)
		{
			_red.setRaw(0x00);
			_green.setRaw(0xFF);
			//_blue.setRaw(0x00);
			SmartDashboard.putBoolean("DB/LED 0", false);
			SmartDashboard.putBoolean("DB/LED 1", true);
			SmartDashboard.putBoolean("DB/LED 2", false);
		} else if (color == LightingColor.BLUE)
		{
			_red.setRaw(0x00);
			_green.setRaw(0x00);
			//_blue.setRaw(0xFF);
			SmartDashboard.putBoolean("DB/LED 0", false);
			SmartDashboard.putBoolean("DB/LED 1", false);
			SmartDashboard.putBoolean("DB/LED 2", true);
		} else
		{
			_red.setRaw(0xFF);
			_green.setRaw(0xFF);
			//blue.setRaw(0x00);
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

