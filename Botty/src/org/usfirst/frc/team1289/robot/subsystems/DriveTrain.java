
package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team1289.robot.OperatorInterface;
import org.usfirst.frc.team1289.robot.Robot;
import org.usfirst.frc.team1289.robot.commands.*;

import edu.wpi.first.wpilibj.Counter;


enum RotationalDirection 
{
	CLOCKWISE, COUNTERCLOCKWISE
}

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
	private static SpeedControllerGroup _leftMotors, _rightMotors;
	private static Counter _leftFrontEncoder;
	private static Counter _rightFrontEncoder; 
	private static Counter _leftRearEncoder;
	private static Counter _rightRearEncoder; 
	private static DifferentialDrive _robotDrive;
	
	public DriveTrain(int io_leftFront, int io_rightFront,
						int io_leftRear, int io_rightRear,
						int io_leftFrontEncoder, int io_rightFrontEncoder,
						int io_leftRearEncoder, int io_rightRearEncoder)
	{
		_leftFrontMotor = new Talon(io_leftFront);
		_leftRearMotor = new Talon(io_leftRear);
		_leftMotors = new SpeedControllerGroup(_leftFrontMotor, _leftRearMotor);
		
		_rightFrontMotor = new Talon(io_rightFront);
		_rightRearMotor = new Talon(io_rightRear);
		_rightMotors = new SpeedControllerGroup(_rightFrontMotor, _rightRearMotor);
		
		_robotDrive = new DifferentialDrive(_leftMotors, _rightMotors);
		
		_robotDrive.setSafetyEnabled(false);
		_robotDrive.setExpiration(0.1);
		_robotDrive.setMaxOutput(1.0);
		
//		_robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
//        _robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
//        _robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
//        _robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        
    	_leftFrontEncoder = new Counter(io_leftFrontEncoder);
		_rightFrontEncoder = new Counter(io_rightFrontEncoder);
		_leftRearEncoder = new Counter(io_leftRearEncoder);
		_rightRearEncoder = new Counter(io_rightRearEncoder);
	
		double wheelDiameter = 6.0;
		double pulsesPerRotation = 6.0;
		double pulseDistance = (wheelDiameter * Math.PI) / pulsesPerRotation; 
				
		_leftFrontEncoder.setDistancePerPulse(pulseDistance);
		_rightFrontEncoder.setDistancePerPulse(pulseDistance);
		_leftRearEncoder.setDistancePerPulse(pulseDistance);
		_rightRearEncoder.setDistancePerPulse(pulseDistance);
		
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
    	_robotDrive.arcadeDrive(speed, 0.0, squareInputs);
    }
    
    public void Rotate(RotationalDirection direction)
    {
    	if (direction == RotationalDirection.CLOCKWISE)
    		_robotDrive.arcadeDrive(0.2, 0.3);
    	else
    		_robotDrive.arcadeDrive(-0.2, -0.3);
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
    	double moveValue = 0; // - Robot.DriverStation.joyStick.getY();
    	double rotateValue = 0; //- Robot.DriverStation.joyStick.getX();
    	
    	moveValue = ScaleValue(moveValue);
    	rotateValue = ScaleValue(rotateValue);
    	
    	_robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    public void Stop()
    {
    	_robotDrive.stopMotor();
    }
    
    public double GetLeftFrontEncoderDistance()
    {
    	return _leftFrontEncoder.getDistance();
    }
    
    public double GetRightFrontEncoderDistance()
    {
    	return _rightFrontEncoder.getDistance();
    }
    
    public double GetLeftRearEncoderDistance()
    {
    	return _leftRearEncoder.getDistance();
    }
    
    public double GetRightRearEncoderDistance()
    {
    	return _rightRearEncoder.getDistance();
    }
    
    
    public int GetLeftFrontEncoderCount()
    {
    	return _leftFrontEncoder.get();
    }
    
    public int GetRightFrontEncoderCount()
    {
    	return  _rightFrontEncoder.get();
    }
    
    public int GetLeftRearEncoderCount()
    {
    	return _leftRearEncoder.get();
    }
    
    public int GetRightRearEncoderCount()
    {
    	return  _rightRearEncoder.get();
    }
   
    
   public void ResetEncoders()
   {
	   _leftFrontEncoder.reset();
	   _rightFrontEncoder.reset();
	   _leftRearEncoder.reset();
	   _rightRearEncoder.reset();
   }
}

