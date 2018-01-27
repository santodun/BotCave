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
	private String _driveTrainDeadBandKey = "Drivetrain Deadband";
	private String _elevatorPositionRungKey = "Elevator Rung Height";
	private String _elevatorPositionScaleKey = "Elevator Scale Height";
	private String _elevatorPositionSwitchKey = "Elevator Switch Height";
	private String _elevatorPositionPortalKey = "Elevator Portal Height";
	private String _elevatorPositionExchangeKey = "Elevator Exchange Height";
	
	
	// Values
	private double _autoSpeed = 0.6;
	private double _switchDistance = 130.0;
	private double _scaleDistance = 250.0;
	private double _autoLineDistance = 130.0;
	private String _startAlignment = "R";
	private double _driveTrainDeadBand = 0.05;
	private double _elevatorPositionRungHeight = 84.0;
	private double _elevatorPositionScaleHeight = 72.0;
	private double _elevatorPositionSwitchHeight = 20.0;
	private double _elevatorPositionPortalHeight = 20.0;
	private double _elevatorPositionExchangeHeight = 2.0;
	
	public OperatingParameters()
	{
		SmartDashboard.putString(_startAlignmentKey, _startAlignment);
		SmartDashboard.putNumber(_autoSpeedKey, _autoSpeed);
		SmartDashboard.putNumber(_switchDistanceKey, _switchDistance);
		SmartDashboard.putNumber(_scaleDistanceKey, _scaleDistance);
		SmartDashboard.putNumber(_autoLineDistanceKey, _autoLineDistance);
		SmartDashboard.putNumber(_driveTrainDeadBandKey, _driveTrainDeadBand);
		SmartDashboard.putNumber(_elevatorPositionRungKey, _elevatorPositionRungHeight);
		SmartDashboard.putNumber(_elevatorPositionScaleKey, _elevatorPositionScaleHeight);
		SmartDashboard.putNumber(_elevatorPositionSwitchKey, _elevatorPositionSwitchHeight);
		SmartDashboard.putNumber(_elevatorPositionPortalKey, _elevatorPositionPortalHeight);
		SmartDashboard.putNumber(_elevatorPositionExchangeKey, _elevatorPositionExchangeHeight);
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

	public double DriveTrainDeadBand()
	{
		return SmartDashboard.getNumber(_driveTrainDeadBandKey, _driveTrainDeadBand);
	}
	
	public double RungHeight()
	{
		return SmartDashboard.getNumber(_elevatorPositionRungKey, _elevatorPositionRungHeight);
	}
	
	public double ScaleHeight()
	{
		return SmartDashboard.getNumber(_elevatorPositionScaleKey, _elevatorPositionScaleHeight);
	}
	
	public double SwitchHeight()
	{
		return SmartDashboard.getNumber(_elevatorPositionSwitchKey, _elevatorPositionSwitchHeight);
	}
	
	public double PortalHeight()
	{
		return SmartDashboard.getNumber(_elevatorPositionPortalKey, _elevatorPositionPortalHeight);
	}
	
	public double ExchangeHeight()
	{
		return SmartDashboard.getNumber(_elevatorPositionExchangeKey, _elevatorPositionExchangeHeight);
	}
}
