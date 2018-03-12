package org.usfirst.frc.team1289.robot;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Preferences;

public class OperatingParameters 
{
	private static Preferences _preferences;
	// Keys
	private String _autoSpeedKey = "AutoSpeed";
	private String _switchDistanceKey = "SwitchDistance";
	private String _scaleDistanceKey = "ScaleDistance";
	private String _autoLineDistanceKey = "AutoLineDistance";
	private String _autoCenterFirstLastLegKey = "AutoCenterFirstLastLeg";
	private String _autoCenterMiddleLegKey = "AutoCenterMiddleLeg";
	private String _autoSideFinalLegDistanceKey = "AutoSideFinalLegDistance";
	private String _elevatorMotorSpeedThresholdKey = "ElevatorMotorSpeed";
	private String _startAlignmentKey = "StartAlignment";
	private String _driveTrainDeadBandKey = "Drivetrain Deadband";
	private String _driveTrainRotateSpeedKey  = "DriveTrainSpeed";
	private String _driveTrainRotateRotationKey = "DriveTrainRotateRotation";
	private String _driveTrainProportionKey = "DriveTrainProportionKey";
	private String _driveTrainIntegralKey = "DriveTrainIntegralKey";
	private String _driveTrainDerivativeKey = "DriveTrainDerivativeKey";
	private String _driveTrainRotationArcKey = "DriveTrainRotationArc";
	private String _grabberSpeedKey = "GrabberSpeed";
	private String _retractorSpeedKey = "RetractorSpeed";
	private String _autoCenterRotateKey = "AutoCenterRotate";
	
	// Values
	private double _autoSpeed = 0.4;
	private double _switchDistance = 250.0;
	private double _scaleDistance = 400.0;
	private double _autoLineDistance = 160.0;
	private double _autoCenterFirstLastLegDistance = 12.0;
	private double _autoCenterMiddleLegDistance = 250.0;
	private double _autoSideFinalLegDistance = 10.0;
	private double _elevatorMotorThresholdSpeed = 0.3;
	private String _startAlignment = "R";
	private double _driveTrainDeadBand = 0.05;
	private double _driveTrainRotateSpeed = 0.2;
	private double _driveTrainRotateRotation  = 0.3;
	private double _driveTrainProportion = 0.01;
	private double _driveTrainIntegral = 0.0;
	private double _driveTrainDerivative = 0.0;
	private int _driveTrainRotationArc = 75;
	private double _grabberSpeed = 1.0;
	private double _retractorSpeed = 0.7;
	private int _autoCenterRotate = 30;
	
	public OperatingParameters()
	{
		_preferences = Preferences.getInstance();
		_preferences.putString(_startAlignmentKey, _startAlignment);
		_preferences.putDouble(_autoSpeedKey, _autoSpeed);
		_preferences.putDouble(_switchDistanceKey, _switchDistance);
		_preferences.putDouble(_scaleDistanceKey, _scaleDistance);
		_preferences.putDouble(_autoLineDistanceKey, _autoLineDistance);
		_preferences.putDouble(_autoCenterFirstLastLegKey, _autoCenterFirstLastLegDistance);
		_preferences.putDouble(_autoCenterMiddleLegKey, _autoCenterMiddleLegDistance);
		_preferences.putDouble(_autoSideFinalLegDistanceKey, _autoSideFinalLegDistance);
		_preferences.putDouble(_elevatorMotorSpeedThresholdKey, _elevatorMotorThresholdSpeed);
		_preferences.putDouble(_driveTrainDeadBandKey, _driveTrainDeadBand);
		_preferences.putDouble(_driveTrainRotateSpeedKey, _driveTrainRotateSpeed);
		_preferences.putDouble(_driveTrainRotateRotationKey, _driveTrainRotateRotation);
		_preferences.putDouble(_driveTrainProportionKey, _driveTrainProportion);
		_preferences.putDouble(_driveTrainIntegralKey, _driveTrainIntegral);
		_preferences.putDouble(_driveTrainDerivativeKey, _driveTrainDerivative);
		_preferences.putInt(_driveTrainRotationArcKey, _driveTrainRotationArc);
		_preferences.putDouble(_grabberSpeedKey, _grabberSpeed);
		_preferences.putDouble(_retractorSpeedKey, _retractorSpeed);
		_preferences.putInt(_autoCenterRotateKey, _autoCenterRotate);
	}
	
	public double AutoSideFinalLegDistance()
	{
		return _preferences.getDouble(_autoSideFinalLegDistanceKey, _autoSideFinalLegDistance);
	}
	
	public double AutoCenterFirstLastLegDistance()
	{
		return _preferences.getDouble(_autoCenterFirstLastLegKey, _autoCenterFirstLastLegDistance);
	}
	
	public double AutoCenterMiddleLegDistance()
	{
		return _preferences.getDouble(_autoCenterMiddleLegKey, _autoCenterMiddleLegDistance);
	}
	
	
	public int AutoCenterRotate()
	{
		return _preferences.getInt(_autoCenterRotateKey, _autoCenterRotate);
	}
	
	public double RetractorSpeed()
	{
		return _preferences.getDouble(_retractorSpeedKey, _retractorSpeed);
	}
	
	public String StartingAlignment()
	{
		return _preferences.getString(_startAlignmentKey, _startAlignment);
	}
	
	public double RotationSpeed()
	{
		return _preferences.getDouble(_driveTrainRotateSpeedKey, _driveTrainRotateSpeed);
	}
	
	public double RotateRotation()
	{
		return _preferences.getDouble(_driveTrainRotateRotationKey, _driveTrainRotateRotation);
	}
	
	public double AutoSpeed()
	{
		return _preferences.getDouble(_autoSpeedKey, _autoSpeed);
	}
	
	public double SwitchDistance()
	{
		return _preferences.getDouble(_switchDistanceKey, _switchDistance);
	}
	
	public double ScaleDistance()
	{
		return _preferences.getDouble(_scaleDistanceKey, _scaleDistance);
	}
	
	public double ElevatorThresholdSpeed()
	{
		return _preferences.getDouble(_elevatorMotorSpeedThresholdKey, _elevatorMotorThresholdSpeed);
	}
	
	public double AutoLineDistance()
	{
		return _preferences.getDouble(_autoLineDistanceKey, _autoLineDistance);
	}

	public double DriveTrainDeadBand()
	{
		return _preferences.getDouble(_driveTrainDeadBandKey, _driveTrainDeadBand);
	}
	
	public double DriveTrainPIDProportion()
	{
		return _preferences.getDouble(_driveTrainProportionKey, _driveTrainProportion);
	}
	
	public double DriveTrainPIDIntegral()
	{
		return _preferences.getDouble(_driveTrainIntegralKey, _driveTrainIntegral);
	}
	
	public double DriveTrainPIDDerivative()
	{
		return _preferences.getDouble(_driveTrainDerivativeKey, _driveTrainDerivative);
	}
	
	public int DriveTrainRotationArc()
	{ 
		return _preferences.getInt(_driveTrainRotationArcKey, _driveTrainRotationArc);
	}
	
	public double GrabberSpeed()
	{ 
		return _preferences.getDouble(_grabberSpeedKey, _grabberSpeed);
	}
}
