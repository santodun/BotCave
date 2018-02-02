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
	public static final int PWM_grabberLeftGrabEjectMotor = 6;
	public static final int PWM_grabberRightGrabEjectMotor = 7;
	
	public static final int DIO_leftFrontEncoder = 0;
	public static final int DIO_rightFrontEncoder = 1;
	public static final int DIO_leftRearEncoder = 2;
	public static final int DIO_rightRearEncoder = 3;
	public static final int DIO_ElevatorMaxBreaker = 4;
	public static final int DIO_ElevatorMinBreaker = 5;
	
	public static final int IO_ButtonStation = 0;
	public static final int IO_DriveJoystick = 0;
	public static final int IO_ElevatorJoystick = 1;
	
	public static final int IO_RungButton = 1;
	public static final int IO_ScaleButton = 2;
	public static final int IO_SwitchButton = 3;
	public static final int IO_ExchangeButton = 4;
	public static final int IO_PortalButton = 5;
	public static final int IO_GrabberOpenButton = 6;
	public static final int IO_GrabberCloseButton =7;
	
	
	public static final int AIO_Gyroscope = 0;
	public static final int AIO_DriveTrainRangeFinder = 1;
	public static final int AIO_ElevatorRangeFinder = 2;
}
	
