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
	private String _autoSideMiddleLegDistanceKey = "AutoSideMiddleLegDistance";
	private String _autoSideFirstLegDistanceKey = "AutoSideFirstLegDistance";
	private String _autoSideInitialHeadingKey = "AutoSideInitialHeading";
	private String _autoSideFinalHeadingKey = "AutoSideFinalHeading";
	private String _elevatorMotorSpeedThresholdKey = "ElevatorMotorSpeed";
	private String _startAlignmentKey = "StartAlignment";
	private String _driveTrainDeadBandKey = "Drivetrain Deadband";
	private String _driveTrainRotateSpeedKey  = "DriveTrainSpeed";
	private String _driveTrainRotateRotationKey = "DriveTrainRotateRotation";
	private String _dtDriveStraightPGainKey = "DTStraightPGainKey";
	private String _dtDriveStraightIGainKey = "DTStraightIKey";
	private String _dtDriveStraightDGainKey = "DTStraightDKey";
	
	private String _dtDriveDistancePGainKey = "DTDistancePGainKey";
	private String _dtDriveDistanceIGainKey = "DTDistanceIKey";
	private String _dtDriveDistanceDGainKey = "DTDistanceDKey";
	
	private String _dtRotatePGainKey = "DTRotatePGainKey";
	private String _dtRotateIGainKey = "DTRotateIKey";
	private String _dtRotateDGainKey = "DTRotateDKey";
	
	private String _driveTrainRotationArcKey = "DriveTrainRotationArc";
	private String _grabberSpeedKey = "GrabberSpeed";
	private String _retractorSpeedKey = "RetractorSpeed";
	private String _autoCenterRotateKey = "AutoCenterRotate";
	private String _grabberTimerKey = "GrabberTimer";
	
	private String _lightingDeadbandKey = "LightingDeadband";
	
	private String _testStringKey = "TestStringKey";
	
	// Values
	private double _autoSpeed = 0.4;
	private double _switchDistance = 250.0;
	private double _scaleDistance = 400.0;
	private double _autoLineDistance = 160.0;
	private double _autoCenterFirstLastLegDistance = 12.0;
	private double _autoCenterMiddleLegDistance = 250.0;
	private double _autoSideFinalLegDistance = 20.0;
	private double _autoSideMiddleLegDistance = 225.0;
	private double _autoSideFirstLegDistance = 12.0;
	private int _autoSideInitialHeading = 10;
	private int _autoSideFinalHeading = 80;
	private double _elevatorMotorThresholdSpeed = 0.3;
	private String _startAlignment = "R";
	private double _driveTrainDeadBand = 0.05;
	private double _driveTrainRotateSpeed = 0.2;
	private double _driveTrainRotateRotation  = 0.3;
	private double _dtDriveStraightPGain = 0.01;
	private double _dtDriveStraightIGain = 0.0;
	private double _dtDriveStraightDGain = 0.0;
	private double _dtDriveDistancePGain = 0.0;
	private double _dtDriveDistanceIGain = 0.0;
	private double _dtDriveDistanceDGain = 0.0;
	private double _dtRotatePGain = 0.0;
	private double _dtRotateIGain = 0.0;
	private double _dtRotateDGain = 0.0;
	private int _driveTrainRotationArc = 75;
	private double _grabberSpeed = 1.0;
	private double _retractorSpeed = 0.7;
	private int _autoCenterRotate = 30;
	private double _grabberTimer = 1.0;
	private double _lightingDeadband = 0.1;
	private String _testString = "foo";
	
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
		_preferences.putDouble(_autoSideMiddleLegDistanceKey, _autoSideMiddleLegDistance);
		_preferences.putDouble(_autoSideFirstLegDistanceKey, _autoSideFirstLegDistance);
		_preferences.putInt(_autoSideInitialHeadingKey, _autoSideInitialHeading);
		_preferences.putInt(_autoSideFinalHeadingKey, _autoSideFinalHeading);
		_preferences.putDouble(_elevatorMotorSpeedThresholdKey, _elevatorMotorThresholdSpeed);
		_preferences.putDouble(_driveTrainDeadBandKey, _driveTrainDeadBand);
		_preferences.putDouble(_driveTrainRotateSpeedKey, _driveTrainRotateSpeed);
		_preferences.putDouble(_driveTrainRotateRotationKey, _driveTrainRotateRotation);
		_preferences.putDouble(_dtDriveStraightPGainKey, _dtDriveStraightPGain);
		_preferences.putDouble(_dtDriveStraightIGainKey, _dtDriveStraightIGain);
		_preferences.putDouble(_dtDriveStraightDGainKey, _dtDriveStraightDGain);
		_preferences.putDouble(_dtDriveDistancePGainKey, _dtDriveDistancePGain);
		_preferences.putDouble(_dtDriveDistanceIGainKey, _dtDriveDistanceIGain);
		_preferences.putDouble(_dtDriveDistanceDGainKey, _dtDriveDistanceDGain);
		_preferences.putDouble(_dtRotatePGainKey, _dtRotatePGain);
		_preferences.putDouble(_dtRotateIGainKey, _dtRotateIGain);
		_preferences.putDouble(_dtRotateDGainKey, _dtRotateDGain);
		_preferences.putInt(_driveTrainRotationArcKey, _driveTrainRotationArc);
		_preferences.putDouble(_grabberSpeedKey, _grabberSpeed);
		_preferences.putDouble(_retractorSpeedKey, _retractorSpeed);
		_preferences.putInt(_autoCenterRotateKey, _autoCenterRotate);
		_preferences.putDouble(_grabberTimerKey, _grabberTimer);
		_preferences.putDouble(_lightingDeadbandKey, _lightingDeadband);
		_preferences.putString(_testStringKey, _testString);
	}
	
	public String TestString()
	{
		return _preferences.getString(_testStringKey, _testString);
	}
	
	public double GetLightingDeadband()
	{
		return _preferences.getDouble(_lightingDeadbandKey, _lightingDeadband);
	}
	
	public int AutoSideInitialHeading()
	{
		return _preferences.getInt(_autoSideInitialHeadingKey, _autoSideInitialHeading);
	}
	
	public int AutoSideFinalHeading()
	{
		return _preferences.getInt(_autoSideFinalHeadingKey, _autoSideFinalHeading);
	}
	public double AutoSideMiddleDistance()
	{
		return _preferences.getDouble(_autoSideMiddleLegDistanceKey, _autoSideMiddleLegDistance);
	}
	
	public double AutoSideFirstDistance()
	{
		return _preferences.getDouble(_autoSideFirstLegDistanceKey, _autoSideFirstLegDistance);
	}
	public double GrabberTimer()
	{
		return _preferences.getDouble(_grabberTimerKey, _grabberTimer);
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
	
	public double DT_DriveStraightPGain()
	{
		return _preferences.getDouble(_dtDriveStraightPGainKey, _dtDriveStraightPGain);
	}
	
	public double DT_DriveStraightIGain()
	{
		return _preferences.getDouble(_dtDriveStraightIGainKey, _dtDriveStraightIGain);
	}
	
	public double DT_DriveStraightDGain()
	{
		return _preferences.getDouble(_dtDriveStraightDGainKey, _dtDriveStraightDGain);
	}
	
	public double DT_DriveDistancePGain()
	{
		return _preferences.getDouble(_dtDriveDistancePGainKey, _dtDriveDistancePGain);
	}
	
	public double DT_DriveDistanceIGain()
	{
		return _preferences.getDouble(_dtDriveDistanceIGainKey, _dtDriveDistanceIGain);
	}
	
	public double DT_DriveDistanceDGain()
	{
		return _preferences.getDouble(_dtDriveDistanceDGainKey, _dtDriveDistanceDGain);
	}
	
	public double DT_RotatePGain()
	{
		return _preferences.getDouble(_dtRotatePGainKey, _dtRotatePGain);
	}
	
	public double DT_RotateIGain()
	{
		return _preferences.getDouble(_dtRotateIGainKey, _dtRotateIGain);
	}
	
	public double DT_RotateDGain()
	{
		return _preferences.getDouble(_dtRotateDGainKey, _dtRotateDGain);
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
