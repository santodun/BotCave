
package org.usfirst.frc.team1289.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1289.robot.RobotMap;
import org.usfirst.frc.team1289.robot.commands.*;
import org.usfirst.frc.team1289.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;


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
	private static SimpleMotor _elevatorMotor;
	private static RangeFinder _driveTrainRangeFinder;
	private static RangeFinder _elevatorRangeFinder;
	private static Gyroscope _gyro;
	private static Accelerometer _accelerometer;
	private static LimitSwitch _elevatorMaxBreaker;
	private static LimitSwitch _elevatorMinBreaker;
	
	private static Command _testCommand;
	private static Command _driveViaStickCommand;

	public static Joystick _joyStick;
	public static Joystick _buttonStation;
	public static Button _rungButton;
	public static Button _scaleButton;
	public static Button _switchButton;
	public static Button _portalButton;
	public static Button _exchangeButton;
	
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
    	_joyStick = new Joystick(_ioMap.IO_Joystick);
	    _buttonStation = new Joystick(_ioMap.IO_ButtonStation);
	    
	    _rungButton = new JoystickButton(_buttonStation, _ioMap.IO_RungButton);
	    _scaleButton = new JoystickButton(_buttonStation, _ioMap.IO_ScaleButton);
	    _switchButton = new JoystickButton(_buttonStation, _ioMap.IO_SwitchButton);
	    _portalButton = new JoystickButton(_buttonStation, _ioMap.IO_PortalButton);
	    _exchangeButton = new JoystickButton(_buttonStation, _ioMap.IO_ExchangeButton);
	   
    	// Subsystems
    	_elevatorMotor = new SimpleMotor(_ioMap.PWM_elevatorMotor);
    	_elevatorMaxBreaker = new LimitSwitch(_ioMap.DIO_ElevatorMaxBreaker);
    	_elevatorMinBreaker = new LimitSwitch(_ioMap.DIO_ElevatorMinBreaker);
      	_driveTrainRangeFinder = new RangeFinder(_ioMap.AIO_DriveTrainRangeFinder);
      	_elevatorRangeFinder = new RangeFinder(_ioMap.AIO_ElevatorRangeFinder);
      	_gyro = new Gyroscope(_ioMap.AIO_Gyroscope);
    	_accelerometer = new Accelerometer();
    	_driveTrain = new DriveTrain(_ioMap.PWM_leftFrontMotor, _ioMap.PWM_rightFrontMotor,
				_ioMap.PWM_leftRearMotor, _ioMap.PWM_rightRearMotor,
				_ioMap.DIO_leftFrontEncoder, _ioMap.DIO_rightFrontEncoder,
				_ioMap.DIO_leftRearEncoder, _ioMap.DIO_rightRearEncoder,
				_joyStick, _operatingParameters);
    	
    	// Commands
    	_testCommand = new TestCommand(_gyro);
    	_driveViaStickCommand = new DriveViaStick(_driveTrain);	
    	
    	_rungButton.whenPressed(new ElevatorCommand(_elevatorMotor, _elevatorRangeFinder, 
    			_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.RUNG, _operatingParameters));
    	_scaleButton.whenPressed(new ElevatorCommand(_elevatorMotor, _elevatorRangeFinder, 
    			_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SCALE, _operatingParameters));
    	_switchButton.whenPressed(new ElevatorCommand(_elevatorMotor, _elevatorRangeFinder, 
    			_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SWITCH, _operatingParameters));
    	_portalButton.whenPressed(new ElevatorCommand(_elevatorMotor, _elevatorRangeFinder, 
    			_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.PORTAL, _operatingParameters));
    	_exchangeButton.whenPressed(new ElevatorCommand(_elevatorMotor, _elevatorRangeFinder, 
    			_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.EXCHANGE, _operatingParameters));
           	
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
        
        _teleopCommand = _testCommand; //_driveViaStickCommand;
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
        String position = _operatingParameters.StartingAlignment(); //SmartDashboard.getString("position", "C");
        Command cmd = null;
        double autoSpeed = _operatingParameters.AutoSpeed();
        double autoSwitchDistance = _operatingParameters.SwitchDistance();
        double autoScaleDistance = _operatingParameters.ScaleDistance();
        
        switch (position)
        {
        case "C": 
        case "c":
        	if (gameData.charAt(0) == 'L')
        		cmd = new AutoCenterLeft(_driveTrain);
        	else
        		cmd = new AutoCenterRight(_driveTrain);
        		
        	break;
        	
//        	 AutoSideTarget(DriveTrain driveTrain, SimpleMotor elevatorMotor, RangeFinder elevatorRangeFinder, 
//        				LimitSwitch minBreaker, LimitSwitch maxBreaker, ElevatorPosition elevatorPosition,  
//        			Gyroscope gyro, RangeFinder driveTrainRangeFinder, RotationDirection rotateDirection, 
//        			double targetSpeed, double targetDistance) 
//        	        	
        case "L":
        case "l":
        	if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
        		cmd = new AutoSideTarget(_driveTrain, _elevatorMotor, _elevatorRangeFinder,
        				_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SWITCH, _gyro, 
        				_driveTrainRangeFinder,	RotationDirection.CLOCKWISE,
        				autoSpeed, autoSwitchDistance, _operatingParameters);
        	else if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'R')
        		cmd = new AutoSideTarget(_driveTrain, _elevatorMotor, _elevatorRangeFinder,
        				_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SWITCH, _gyro, 
        				_driveTrainRangeFinder,	RotationDirection.CLOCKWISE,
        				autoSpeed, autoSwitchDistance, _operatingParameters);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'L')
        		cmd = new AutoSideTarget(_driveTrain, _elevatorMotor, _elevatorRangeFinder,
        				_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SCALE, _gyro, 
        				_driveTrainRangeFinder,	RotationDirection.CLOCKWISE,
        				autoSpeed, autoScaleDistance, _operatingParameters);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
        		cmd = new AutoToLine(_driveTrain);
        	else
        	{	
        		System.out.printf("unknown set of gamedata %s %s \n", position, gameData);
        		cmd = new AutoToLine(_driveTrain);
        	}
        	break;
    	
        case "R": 
        case "r": 
        	if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
        		cmd = new AutoToLine(_driveTrain);
        	else if (gameData.charAt(0) == 'L' && gameData.charAt(1) == 'R')
        		cmd = new AutoSideTarget(_driveTrain, _elevatorMotor, _elevatorRangeFinder,
        				_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SCALE, _gyro, 
        				_driveTrainRangeFinder,	RotationDirection.COUNTERCLOCKWISE,
        				autoSpeed, autoScaleDistance, _operatingParameters);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'L')
        		cmd = new AutoSideTarget(_driveTrain, _elevatorMotor, _elevatorRangeFinder,
        				_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SWITCH, _gyro, 
        				_driveTrainRangeFinder,	RotationDirection.COUNTERCLOCKWISE,
        				autoSpeed, autoSwitchDistance, _operatingParameters);
        	else if (gameData.charAt(0) == 'R' && gameData.charAt(1) == 'R')
        		cmd = new AutoSideTarget(_driveTrain, _elevatorMotor, _elevatorRangeFinder,
        				_elevatorMinBreaker, _elevatorMaxBreaker, ElevatorPosition.SWITCH, _gyro, 
        				_driveTrainRangeFinder,	RotationDirection.COUNTERCLOCKWISE,
        				autoSpeed, autoSwitchDistance, _operatingParameters);
        	else
        	{
        		System.out.printf("unknown set of gamedata %s %s \n", position, gameData);
        		cmd = new AutoToLine(_driveTrain);
    		}	
        	break;
        	
        	default:
        	{
        		System.out.printf("unknown position %s \n", position);
        		cmd = new AutoToLine(_driveTrain);
        	}
        }
        
        return cmd;
    }
}
