package org.usfirst.frc.team1289.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static final int PWM_DriveTrainLeftFrontMotor = 0;
	public static final int PWM_DriveTrainRightFrontMotor = 1;
	public static final int PWM_DriveTrainLeftRearMotor = 2;
	public static final int PWM_DriveTrainRightRearMotor = 3;
	public static final int PWM_WinchMotor = 4;
		
	public static final int DIO_DriveTrainLeftEncoder = 0;
	public static final int DIO_DriveTrainRightEncoder = 1;
	public static final int DIO_WinchLimitSwitch = 2;
	
	public static final int IO_JoystickPort = 0;
	public static final int IO_ButtonStationPort = 0;
}
