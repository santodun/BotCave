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
	public static final int PWM_elevatorMotor = 4;
	public static final int PWM_leftFrontMotor = 0;
	public static final int PWM_rightFrontMotor = 1;
	public static final int PWM_leftRearMotor = 2;
	public static final int PWM_rightRearMotor = 3;
		
	public static final int DIO_leftFrontEncoder = 0;
	public static final int DIO_rightFrontEncoder = 1;
	public static final int DIO_leftRearEncoder = 2;
	public static final int DIO_rightRearEncoder = 3;
	public static final int DIO_Switch = 4;
	
	public static final int IO_ButtonStation = 0;
	public static final int IO_Joystick = 0;
	
	public static final int AIO_Gyroscope = 0;
	public static final int AIO_RangeFinder = 1;
}
	
