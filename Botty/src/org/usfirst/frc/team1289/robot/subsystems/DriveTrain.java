
package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;

import org.usfirst.frc.team1289.robot.Robot;
import org.usfirst.frc.team1289.robot.OperatingParameters;
import org.usfirst.frc.team1289.robot.commands.*;


import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Counter;
import org.usfirst.frc.team1289.robot.subsystems.RangeFinder;
/**
 *
 */
public class DriveTrain extends PIDSubsystem 
{
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static SpeedController _leftFrontMotor;
	private static SpeedController _rightFrontMotor;
	private static SpeedController _leftRearMotor;
	private static SpeedController _rightRearMotor;
	private static SpeedControllerGroup _leftMotors, _rightMotors;
	private static Counter _leftFrontEncoder;
	private static Counter _rightFrontEncoder; 
	private static Counter _leftRearEncoder;
	private static Counter _rightRearEncoder; 
	private static DifferentialDrive _robotDrive;
	private static Joystick _joystick;
	private static OperatingParameters _parameters;
	private static RangeFinder _rangeFinder;
	private static AnalogGyro _gyro;
	private static double _pidOutput;
		
	public DriveTrain(SpeedController leftFront, SpeedController rightFront, SpeedController leftRear, SpeedController rightRear,
						Counter leftEncoder, Counter rightEncoder, AnalogGyro gyro, RangeFinder rangeFinder,
						Joystick joystick, OperatingParameters parameters)
	{		
		super("DriveTrain", parameters.DriveTrainPIDProportion(), parameters.DriveTrainPIDIntegral(), parameters.DriveTrainPIDDerivative());
	// System.out.println(parameters.DriveTrainPIDProportion());
		_leftFrontMotor = leftFront;
		_leftRearMotor = leftRear;
		_leftFrontMotor.setInverted(true);
		_leftRearMotor.setInverted(true);
		_leftMotors = new SpeedControllerGroup(_leftFrontMotor, _leftRearMotor);
		
		_rightFrontMotor = rightFront;
		_rightRearMotor = rightRear;
		_rightFrontMotor.setInverted(true);
		_rightRearMotor.setInverted(true);
		_rightMotors = new SpeedControllerGroup(_rightFrontMotor, _rightRearMotor);
		
		_robotDrive = new DifferentialDrive(_leftMotors, _rightMotors);
		
		_robotDrive.setSafetyEnabled(false);
		_robotDrive.setExpiration(0.1);
		_robotDrive.setMaxOutput(1.0);
		
    	_leftFrontEncoder = leftEncoder;
		_rightFrontEncoder = rightEncoder;
	
		double wheelDiameter = 6.0;
		double pulsesPerRotation = 6.0;
		double pulseDistance = (wheelDiameter * Math.PI) / pulsesPerRotation; 
				
		_leftFrontEncoder.setDistancePerPulse(pulseDistance);
		_rightFrontEncoder.setDistancePerPulse(pulseDistance);
		
		_joystick = joystick;
		_parameters = parameters;
		_rangeFinder = rangeFinder;
		
		_gyro = gyro;
		_gyro.calibrate();
		_gyro.reset();
		
		setSetpoint(0.0);
		setAbsoluteTolerance(1.0);
		setInputRange(-90.0, 90.0); 
		setOutputRange(-0.1, 0.1);
		getPIDController().setContinuous(true);
		enable();
	}
	   
	@Override
	 protected double returnPIDInput()
	 {
		double angle = _gyro.getAngle();
		//System.out.printf("%.2f\t", angle);
		 return angle; //_gyro.getAngle();
	 }
	 
	@Override
	 protected void usePIDOutput(double output)
	 {
		// System.out.printf("%f %f\n", getPIDController().getError(), output);
		//System.out.printf("%.2f\n", output);
		 _pidOutput = output;
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
    	_robotDrive.arcadeDrive(speed, _pidOutput, squareInputs);
    }
    
    public void Rotate(RotationDirection direction)
    {
    	double speed = _parameters.RotationSpeed();
    	double rotate = _parameters.RotateRotation();
    	
    	//System.out.printf("%f, %f\n",  speed, rotate);
    	if (direction == RotationDirection.CLOCKWISE)
    		_robotDrive.arcadeDrive(speed, rotate, false);
    	else
    		_robotDrive.arcadeDrive(-speed, -rotate, false);
    }
    
    public double GetHeading()
    {
    	return _gyro.getAngle();
    }

    // Scale the raw value into a piecewise linear equation
    private double ScaleValue(double rawValue)
    {

    	double deadBand = _parameters.DriveTrainDeadBand();
    	if (-deadBand < rawValue && rawValue < deadBand)
    		return 0.0;
    	else
    		return (rawValue < 0.0) ? Math.pow(rawValue + deadBand, 3) : Math.pow(rawValue - deadBand, 3); 
    }
    
    public void StickDrive(boolean halfSpeedMode)
    {
    	double moveValue =  - _joystick.getY();
    	double rotateValue =  _joystick.getX();
    	  	
    	moveValue = ScaleValue(moveValue);
    	rotateValue = ScaleValue(rotateValue);
    	
    	if (halfSpeedMode)
    		moveValue = moveValue * 0.5;
    	
    	_robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    public double RangeToTargetInMM()
    {
    	return _rangeFinder.GetRangeInMM();
    }

    public double RangeToTargetInInches()
    {
    	return _rangeFinder.GetRangeInInches();
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
    
    public int GetLeftFrontEncoderCount()
    {
    	return _leftFrontEncoder.get();
    }
    
    public int GetRightFrontEncoderCount()
    {
    	return  _rightFrontEncoder.get();
    }
      
   public void Reset()
   {
	   Stop();
	   _leftFrontEncoder.reset();
	   _rightFrontEncoder.reset();
	   _gyro.reset();
   }
}

