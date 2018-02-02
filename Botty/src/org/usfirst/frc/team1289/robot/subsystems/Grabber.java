package org.usfirst.frc.team1289.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Talon;

/**
 *
 */

public class Grabber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	static SimpleMotor _openCloseMotor;
	static SimpleMotor _leftGrabberMotor;
	static SimpleMotor _rightGrabberMotor;
		
	public Grabber(int io_openClose, int io_leftGrabber, int io_rightGrabber)
	{
		_openCloseMotor  = new SimpleMotor(io_openClose);
		_leftGrabberMotor = new SimpleMotor(io_leftGrabber);
		_rightGrabberMotor = new SimpleMotor(io_rightGrabber);
		
		StopAllMotors();
	}

	public void StopAllMotors()
	{
		_openCloseMotor.Stop();
		_leftGrabberMotor.Stop();
		_rightGrabberMotor.Stop();
	}
	
	public void ActuateGrabber()
	{
		_openCloseMotor.Stop();
		_openCloseMotor.Raise();
	}
		
	public void StopOpenCloseActuation()
	{
		_openCloseMotor.Stop();
	}
	
	public void Eject()
	{
		_leftGrabberMotor.Stop();
		_rightGrabberMotor.Stop();
		_leftGrabberMotor.Raise();
		_rightGrabberMotor.Lower();
	}
	
	public void Grab()
	{
		_leftGrabberMotor.Stop();
		_rightGrabberMotor.Stop();
		_leftGrabberMotor.Lower();
		_rightGrabberMotor.Raise();
	}
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

