
package org.usfirst.frc.team1289.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team1289.robot.RobotMap;
import org.usfirst.frc.team1289.robot.commands.*;
import org.usfirst.frc.team1289.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Winch winch;
	public static DriveTrain drivetrain;
	public static OperatorInterface driverStation;
	public static Camera _camera;
	private static RobotMap _ioMap = new RobotMap();
	
	private static Command _winchCommand;
	private static Command _driveViaEncoder;
	private static Command _driveViaStick;

    Command autonomousCommand;
    Command teleopCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	// Must happen in this order
    	SubsystemInit();
    	CommandInit();
    	driverStation = new OperatorInterface(_winchCommand, _ioMap.IO_JoystickPort, 
    											_ioMap.IO_ButtonStationPort);
    	chooser = new SendableChooser();
    //    chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
      //  SmartDashboard.putData("Auto mode", chooser);
    	_camera = new Camera();
    	_camera.Start();
    }
	
    private void SubsystemInit()
    {
    	winch = new Winch(_ioMap.PWM_WinchMotor, _ioMap.DIO_WinchLimitSwitch);
    	drivetrain = new DriveTrain(_ioMap.PWM_DriveTrainLeftFrontMotor,
    								_ioMap.PWM_DriveTrainLeftRearMotor,
    								_ioMap.PWM_DriveTrainRightFrontMotor,
    								_ioMap.PWM_DriveTrainRightRearMotor,
    								_ioMap.DIO_DriveTrainLeftEncoder,
    								_ioMap.DIO_DriveTrainRightEncoder);
    }
    
    private void CommandInit()
    {
    	_winchCommand = new WinchRaise();
    	_driveViaEncoder = new DriveViaEncoder(0.1, 130.0);
    	_driveViaStick = new DriveViaStick();
    	
    }
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
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
        autonomousCommand = _driveViaEncoder;
        
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
        if (autonomousCommand != null) 
        	autonomousCommand.start();
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
        if (autonomousCommand != null) 
        	autonomousCommand.cancel();
        
        teleopCommand = _driveViaStick;
        teleopCommand.start();
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
}
