
package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team1289.robot.OperatorInterface;
import org.usfirst.frc.team1289.robot.Robot;
import org.usfirst.frc.team1289.robot.commands.*;

import edu.wpi.first.wpilibj.Counter;

/**
 *
 */
public class DriveTrain extends Subsystem 
{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static Talon _leftFrontMotor;
	private static Talon _rightFrontMotor;
	private static Talon _leftRearMotor;
	private static Talon _rightRearMotor;
	private static Counter _leftEncoder;
	private static Counter _rightEncoder; 
	private static RobotDrive _robotDrive;
	
	public DriveTrain(int io_leftFront, int io_rightFront,
						int io_leftRear, int io_rightRear,
						int io_leftEncoder, int io_rightEncoder)
	{
		_leftFrontMotor = new Talon(io_leftFront);
		_rightFrontMotor = new Talon(io_rightFront);
		_leftRearMotor = new Talon(io_leftRear);
		_rightRearMotor = new Talon(io_rightRear);
		
		_robotDrive = new RobotDrive(_leftFrontMotor, _leftRearMotor,
									_rightFrontMotor, _rightRearMotor);
		
		_robotDrive.setSafetyEnabled(true);
		_robotDrive.setExpiration(0.1);
		_robotDrive.setSensitivity(0.1);
		_robotDrive.setMaxOutput(1.0);
		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        _robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        _robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        _robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        
    	_leftEncoder = new Counter(io_leftEncoder);
		_rightEncoder = new Counter(io_rightEncoder);
	
		double wheelDiameter = 6.0;
		double pulsesPerRotation = 6.0;
		double pulseDistance = (wheelDiameter * Math.PI) / pulsesPerRotation; 
				
		_leftEncoder.setDistancePerPulse(pulseDistance);
		_rightEncoder.setDistancePerPulse(pulseDistance);
		
	}
	    
	public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new DriveViaJoystick());
    	//setDefaultCommand(new DriveViaEncoder());
    }
    
    // Sets the motor speed of all motors to the desired setting
    // no rotation value, so no turning. This moves fwd/bkwd only
    public void Move(double speed)
    {
    	boolean squareInputs = false; 
    	_robotDrive.arcadeDrive(0.3 /*speed*/, 0.0, squareInputs);
    }

    // Scale the raw value into a piecewise linear equation
    private double ScaleValue(double rawValue)
    {

    	double deadBand = SmartDashboard.getNumber("Drivetrain Deadband", 0.05);
    	if (-deadBand < rawValue && rawValue < deadBand)
    		return 0.0;
    	else
    		return (rawValue < 0.0) ? Math.pow(rawValue + deadBand, 3) : Math.pow(rawValue - deadBand, 3);
    
    }
    
    public void ArcadeDrive()
    {
    	/* Note the negatation */
    	double moveValue = - Robot.driverStation.joyStick.getY();
    	double rotateValue = - Robot.driverStation.joyStick.getX();
    	
    	SmartDashboard.putNumber("stickRawMoveValue", moveValue);
    	SmartDashboard.putNumber("stickRawRotateValue", rotateValue);
    	
    	moveValue = ScaleValue(moveValue);
    	rotateValue = ScaleValue(rotateValue);
    	
    	SmartDashboard.putNumber("stickScaledMoveValue", moveValue);
    	SmartDashboard.putNumber("stickScaledRotateValue", rotateValue);
    	
    	_robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    public void Stop()
    {
    	_robotDrive.stopMotor();
    }
    
    public double GetLeftEncoderDistance()
    {
    	return _leftEncoder.getDistance();
    }
    
    public double GetRightEncoderDistance()
    {
    	return _rightEncoder.getDistance();
    }
    
    public int GetRightEncoderCount()
    {
    	return  _rightEncoder.get();
    }
    
    public int GetLeftEncoderCount()
    {
    	return _leftEncoder.get();
    }
    
   public void ResetEncoders()
   {
	   _leftEncoder.reset();
	   _rightEncoder.reset();
   }
}

