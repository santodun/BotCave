
package org.usfirst.frc.team1289.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1289.robot.RobotMap;
import org.usfirst.frc.team1289.robot.commands.*;
import org.usfirst.frc.team1289.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogGyro;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	private static RobotMap _ioMap = new RobotMap();
	private static OperatingParameters _operatingParameters = new OperatingParameters();
		
	private static DriveTrain _driveTrain;
	private static Grabber _grabber;
	private static Elevator _elevator;
	private static Retractor _retractor;
	private static Lighting _lighting;
	public static Camera _camera;
	
	private static Talon _retractorMotor;
	private static Talon _elevatorMotor;	
	private static Talon _grabberLeftMotor;
	private static Talon _grabberRightMotor;
	private static Talon _leftFrontMotor;
	private static Talon _rightFrontMotor;
	private static Talon _leftRearMotor;
	private static Talon _rightRearMotor;
	private static RangeFinder _driveTrainRangeFinder;		
	private static AnalogGyro _gyro;
	private static DigitalInput _elevatorMaxBreaker;				
	private static DigitalInput _elevatorMinBreaker;		
	private static DigitalInput _elevatorScaleBreaker;				
	private static DigitalInput _elevatorSwitchBreaker;
//	private static DigitalInput _grabberBreakerLeft;
//	private static DigitalInput _grabberBreakerRight;
	private static DigitalInput _retractorBreaker;
	private static Counter _leftEncoder;
	private static Counter _rightEncoder;
	private static Spark _leds;
		
	private static Command _testCommand;
	private static Command _driveViaStickCommand;
	private static Command _elevateViaStickCommand;
	private static Command _grabberCommand;
	
	public static Joystick _driveJoyStick;
	public static Joystick _elevatorJoyStick;
	public static Joystick _buttonStation;
	public static JoystickButton _grabberIngestButton;
	public static JoystickButton _grabberSpewButton;
	public static JoystickButton _retractGrabberButton;
	public static JoystickButton _deployGrabberButton;
	public static JoystickButton _halfSpeedButton;
	
    private static Command _autoCommand;
    Command _teleopCommand;
    
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Must happen in this order
    	// Joysticks/Buttons, etc
    	_driveJoyStick = new Joystick(_ioMap.IO_DriveJoystick);
    	_elevatorJoyStick = new Joystick(_ioMap.IO_ElevatorJoystick);
	    _buttonStation = new Joystick(_ioMap.IO_ButtonStation);
	   
	    _grabberIngestButton = new JoystickButton(_elevatorJoyStick, _ioMap.IO_GrabberIngestButton);
	    _grabberSpewButton = new JoystickButton(_elevatorJoyStick, _ioMap.IO_GrabberSpewButton);
	    _retractGrabberButton = new JoystickButton(_elevatorJoyStick, _ioMap.IO_RetractorRetractButton);
	    _deployGrabberButton = new JoystickButton(_elevatorJoyStick, _ioMap.IO_RetractorDeployButton);
	    _halfSpeedButton = new JoystickButton(_driveJoyStick, _ioMap.IO_HalfSpeedButton);
	    
    	// Devices
    	_elevatorMotor = new Talon(_ioMap.PWM_elevatorMotor);				
    	_retractorMotor = new Talon(_ioMap.PWM_retractorMotor);
    	_elevatorMaxBreaker = new DigitalInput(_ioMap.DIO_ElevatorMaxBreaker);		
    	_elevatorMinBreaker = new DigitalInput(_ioMap.DIO_ElevatorMinBreaker);			
    	_elevatorSwitchBreaker = new DigitalInput(_ioMap.DIO_ElevatorSwitchBreaker);		
    	_elevatorScaleBreaker = new DigitalInput(_ioMap.DIO_ElevatorScaleBreaker);
    	_retractorBreaker = new DigitalInput(_ioMap.DIO_RetractorBreaker);
      	_driveTrainRangeFinder = new RangeFinder(_ioMap.AIO_DriveTrainRangeFinder);
       	_gyro = new AnalogGyro(_ioMap.AIO_Gyroscope);
       	_grabberLeftMotor = new Talon(_ioMap.PWM_grabberLeftMotor);
       	_grabberRightMotor = new Talon(_ioMap.PWM_grabberRightMotor);
//       	_grabberBreakerLeft = new DigitalInput(_ioMap.DIO_grabberBreakerLeft);
//       	_grabberBreakerRight = new DigitalInput(_ioMap.DIO_grabberBreakerRight);
       	_leftFrontMotor = new Talon(_ioMap.PWM_leftFrontMotor);
       	_rightFrontMotor = new Talon(_ioMap.PWM_rightFrontMotor);
       	_leftRearMotor = new Talon(_ioMap.PWM_leftRearMotor);
       	_rightRearMotor = new Talon(_ioMap.PWM_rightRearMotor);
       	_leftEncoder = new Counter(_ioMap.DIO_leftEncoder);
       	_rightEncoder = new Counter(_ioMap.DIO_rightEncoder);
       	_leds = new Spark(_ioMap.PWM_LEDs);
       	
       	// Subsystems
    	_driveTrain = new DriveTrain(_leftFrontMotor, _rightFrontMotor, _leftRearMotor, _rightRearMotor,
				_leftEncoder, _rightEncoder, _gyro, _driveTrainRangeFinder, _driveJoyStick, _operatingParameters);
    	_elevator = new Elevator(_elevatorMotor, _elevatorMaxBreaker, _elevatorMinBreaker, 
    			_elevatorScaleBreaker, _elevatorSwitchBreaker, _operatingParameters);
    	
    	_grabber = new Grabber(_grabberLeftMotor, _grabberRightMotor, /*_grabberBreakerLeft, _grabberBreakerRight,*/ _operatingParameters);
    	_retractor = new Retractor(_retractorMotor, _retractorBreaker);
    	_lighting = new Lighting(_leds);
    	_camera = new Camera();
    	_camera.Start();
    	
    	// Commands
    	//_testCommand = new TestCommand(_grabberMotor);
    	_driveViaStickCommand = new DriveViaStick(_driveTrain, _halfSpeedButton);	
    	_elevateViaStickCommand = new ElevateViaStick(_elevator, _elevatorJoyStick, _lighting, _operatingParameters);
    	//_grabberCommand = new GrabberCommand(_grabber);
    	
    	_grabberIngestButton.whileHeld(new GrabberCommand(_grabber, GrabberDirection.INGEST, _operatingParameters));
    	_grabberSpewButton.whenPressed(new GrabberCommand(_grabber, GrabberDirection.SPEW, _operatingParameters));
    	_retractGrabberButton.whenPressed(new ActuateRetractor(_retractor, RetractorDirection.UP, _operatingParameters));
    	_deployGrabberButton.whenPressed(new ActuateRetractor(_retractor, RetractorDirection.DOWN, _operatingParameters));
    	
//    	_grabberOpenButton.whenPressed(new TestCommand("Grabber Open"));
//    	_grabberCloseButton.whenPressed(new TestCommand("Grabber Close"));
//    	_retractGrabberButton.whenPressed(new TestCommand("Retract"));
//    	_deployGrabberButton.whenPressed(new TestCommand("Deploy"));
//    	
		chooser = new SendableChooser();
    //    chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
      //  SmartDashboard.putData("Auto mode", chooser);
    	
    }
	
  
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		//Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        _autoCommand =  GetAutoModeCommand();
        System.out.printf("%s\n", _autoCommand.getName());
        System.out.println(_operatingParameters.TestString());
                
//        System.out.printf("%s %s\n", position, gameData);
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (_autoCommand != null) 
        	_autoCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (_autoCommand != null) 
        	_autoCommand.cancel();
        
       // _teleopCommand = _testCommand;
        _teleopCommand = new TeleOpCommand(_elevateViaStickCommand, _driveViaStickCommand, _grabberCommand);
        System.out.println(_teleopCommand.getName());
        _teleopCommand.start();

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    private Command GetAutoModeCommand()
    {
    	String gameData;
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        String position = _operatingParameters.StartingAlignment(); 
        Command cmd = null;
   //     cmd = new AutoToLine(_driveTrain, _operatingParameters, _grabber, _retractor);
        
        switch (position)
        {
        case "C": 
        case "c":
        	if (gameData.charAt(0) == 'L')
        		cmd = new AutoCenterTarget(_driveTrain, RotationDirection.COUNTERCLOCKWISE, 
        				_elevator, ElevatorPosition.SWITCH, _operatingParameters, _grabber, _retractor);
        	else
        		cmd = new AutoCenterTarget(_driveTrain, RotationDirection.CLOCKWISE, 
        				_elevator, ElevatorPosition.SWITCH, _operatingParameters, _grabber, _retractor);
        		
        	break;
        	
        case "L":
        case "l":
        	if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
        		cmd = new AutoSideTarget(_driveTrain, RotationDirection.COUNTERCLOCKWISE, 
        				_elevator, ElevatorPosition.SWITCH, _operatingParameters, _grabber, _retractor);
        	else if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'R')
        		cmd = new AutoSideTarget(_driveTrain, RotationDirection.COUNTERCLOCKWISE, 
        				_elevator, ElevatorPosition.SWITCH, _operatingParameters, _grabber, _retractor);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'L')
        		cmd = new AutoSideTarget(_driveTrain, RotationDirection.COUNTERCLOCKWISE, 
        				_elevator, ElevatorPosition.SCALE, _operatingParameters, _grabber, _retractor);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
        		cmd = new AutoToLine(_driveTrain, _operatingParameters, _grabber, _retractor);
        	else
        	{	
        		System.out.printf("unknown set of gamedata %s %s \n", position, gameData);
        		cmd = new AutoToLine(_driveTrain, _operatingParameters, _grabber, _retractor);
        	}
        	break;
    	
        case "R": 
        case "r": 
        	if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
        		cmd = new AutoToLine(_driveTrain, _operatingParameters, _grabber, _retractor);
        	else if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'R')
        		cmd = new AutoSideTarget(_driveTrain, RotationDirection.CLOCKWISE, 
        				_elevator, ElevatorPosition.SCALE, _operatingParameters, _grabber, _retractor);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'L')
        		cmd = new AutoSideTarget(_driveTrain, RotationDirection.CLOCKWISE, 
        				_elevator, ElevatorPosition.SWITCH, _operatingParameters, _grabber, _retractor);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
        		cmd = new AutoSideTarget(_driveTrain, RotationDirection.CLOCKWISE, 
        				_elevator, ElevatorPosition.SWITCH, _operatingParameters, _grabber, _retractor);
        	else
        	{
        		System.out.printf("unknown set of gamedata %s %s \n", position, gameData);
        		cmd = new AutoToLine(_driveTrain, _operatingParameters, _grabber, _retractor);
    		}	
        	break;
        	
        	default:
        	{
        		System.out.printf("unknown position %s \n", position);
        		cmd = new AutoToLine(_driveTrain, _operatingParameters, _grabber, _retractor);
        	}
        }
        
        return cmd;
        
    }
}
