package org.usfirst.frc.team1289.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OperatingParameters 
{
	// Keys
	private String _autoSpeedKey = "AutoSpeed";
	private String _switchDistanceKey = "SwitchDistance";
	private String _scaleDistanceKey = "ScaleDistance";
	private String _autoLineDistanceKey = "AutoLineDistance";
	private String _startAlignmentKey = "StartAlignment";
	
	
	// Values
	private double _autoSpeed = 0.6;
	private double _switchDistance = 130.0;
	private double _scaleDistance = 250.0;
	private double _autoLineDistance = 130.0;
	private String _startAlignment = "R";
	
	public OperatingParameters()
	{
		SmartDashboard.putString(_startAlignmentKey, _startAlignment);
		SmartDashboard.putNumber(_autoSpeedKey, _autoSpeed);
		SmartDashboard.putNumber(_switchDistanceKey, _switchDistance);
		SmartDashboard.putNumber(_scaleDistanceKey, _scaleDistance);
		SmartDashboard.putNumber(_autoLineDistanceKey, _autoLineDistance);
	}
	
	public String StartingAlignment()
	{
		return SmartDashboard.getString(_startAlignmentKey, _startAlignment);
	}
	
	public double AutoSpeed()
	{
		return SmartDashboard.getNumber(_autoSpeedKey, _autoSpeed);
	}
	
	public double SwitchDistance()
	{
		return SmartDashboard.getNumber(_switchDistanceKey, _switchDistance);
	}
	
	public double ScaleDistance()
	{
		return SmartDashboard.getNumber(_scaleDistanceKey, _scaleDistance);
	}
	
	public double AutoLineDistance()
	{
		return SmartDashboard.getNumber(_autoLineDistanceKey, _autoLineDistance);
	}

}
