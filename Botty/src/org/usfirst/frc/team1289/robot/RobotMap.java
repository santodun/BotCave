package org.usfirst.frc.team1289.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int PWM_leftFrontMotor = 0;
	public static final int PWM_rightFrontMotor = 1;
	public static final int PWM_leftRearMotor = 2;
	public static final int PWM_rightRearMotor = 3;
	public static final int PWM_elevatorMotor = 4;
	public static final int PWM_grabberOpenCloseMotor = 5;
	public static final int PWM_retractorMotor = 6;
	
	public static final int DIO_leftEncoder = 0;
	public static final int DIO_rightEncoder = 1;
	public static final int DIO_grabberBreakerLeft = 2;
	public static final int DIO_grabberBreakerRight = 3;
	public static final int DIO_ElevatorMaxBreaker = 4;
	public static final int DIO_ElevatorMinBreaker = 5;
	public static final int DIO_ElevatorSwitchBreaker = 6;
	public static final int DIO_ElevatorScaleBreaker = 7;
	public static final int DIO_RetractorBreaker = 8;
	
	public static final int IO_ButtonStation = 0;
	public static final int IO_DriveJoystick = 0;
	public static final int IO_ElevatorJoystick = 1;
	
	public static final int IO_GrabberCloseButton = 1;
	public static final int IO_GrabberOpenButton = 2;
	public static final int IO_RetractorRetractButton = 3;
	public static final int IO_RetractorDeployButton = 4;
	
	public static final int AIO_Gyroscope = 0;
	public static final int AIO_DriveTrainRangeFinder = 1;
}
	
