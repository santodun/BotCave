	package org.usfirst.frc.team1289.robot;
	
	import org.usfirst.frc.team1289.robot.commands.*;
	
	import edu.wpi.first.wpilibj.Joystick;
	import edu.wpi.first.wpilibj.command.Command;
	import edu.wpi.first.wpilibj.buttons.*;
	
	/**
	 * This class is the glue that binds the controls on the physical operator
	 * interface to the commands and command groups that allow control of the robot.
	 */
	public class OperatorInterface {
	    //// CREATING BUTTONS
	    // One type of button is a joystick button which is any button on a joystick.
	    // You create one by telling it which joystick it's on and which button
	    // number it is.
		private static final int _winchRaiseButton = 1;
		private static final int _winchLowerButton = 2;
		private static final int _lightBankAButton = 3;
		private static final int _lightBankBButton = 4;
		private static final int _shooterButton = 5;
		
	    public static Joystick joyStick;
	    public static Joystick buttonStation;
	    public static Button winchRaiseButton;
	    public static Button winchLowerButton;
	    
	    public OperatorInterface(Command winchCommand,
	    						int io_joystick, int io_button)
	    {
	        joyStick = new Joystick(io_joystick);
	        buttonStation = new Joystick(io_button);
	        winchRaiseButton = new JoystickButton(buttonStation, _winchRaiseButton);
	     
	        winchRaiseButton.whileHeld(winchCommand);
	    }
	    
	    //
	    // There are a few additional built in buttons you can use. Additionally,
	    // by subclassing Button you can create custom triggers and bind those to
	    // commands the same as any other Button.
	    
	    //// TRIGGERING COMMANDS WITH BUTTONS
	    // Once you have a button, it's trivial to bind it to a button in one of
	    // three ways:
	    
	    // Start the command when the button is pressed and let it run the command
	    // until it is finished as determined by it's isFinished method.
	    // button.whenPressed(new ExampleCommand());
	    
	    // Run the command while the button is being held down and interrupt it once
	    // the button is released.
	    // button.whileHeld(new ExampleCommand());
	    
	    // Start the command when the button is released  and let it run the command
	    // until it is finished as determined by it's isFinished method.
	    // button.whenReleased(new ExampleCommand());
	}
	
