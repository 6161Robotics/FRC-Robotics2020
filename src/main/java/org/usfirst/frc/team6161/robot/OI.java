/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6161.robot;


import org.usfirst.frc.team6161.robot.Gamepad;
import org.usfirst.frc.team6161.robot.commands.*;
import org.usfirst.frc.team6161.robot.commands.auto.AutoStraight;
import org.usfirst.frc.team6161.robot.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

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

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public JoystickButton joyClimbUp;
	public JoystickButton joyClimbDown;
	public JoystickButton joyClimbUpTwo;
	public JoystickButton joyClimbDownTwo;
	public JoystickButton joySlideForwards;
	public JoystickButton joySlideBackwards;
	public JoystickButton joySlideDownwards;
	public JoystickButton joySlideUpwards;
	public AxisButton joyIntake;
	public AxisButton joyOuttake;

	public Joystick theXbox;
	public Joystick theJoystick;

	public OI() {
		theXbox = new Joystick(0);
		theJoystick = new Joystick(1);
		

		joySlideBackwards = new JoystickButton(theXbox, 7);
        joySlideBackwards.whenPressed(new SliderSolenoid());
		
        joySlideForwards = new JoystickButton(theXbox, 8);
        joySlideForwards.whenPressed(new Defense());  
        
        joySlideUpwards = new JoystickButton(theXbox, 5);
        joySlideUpwards.whenPressed(new PvcSolenoid());
        
        joySlideDownwards = new JoystickButton(theXbox, 6);
        joySlideDownwards.whenPressed(new PvcOut());
		
        //joyIntake = new AxisButton(theXbox, Gamepad.Axes.RIGHT_TRIGGER.getNumber(), Constants.AXIS_BUTTON_THRESHHOLD);
        //joyIntake.whileHeld(new InSole());
        
       joyOuttake = new AxisButton(theXbox, Gamepad.Axes.LEFT_TRIGGER.getNumber(), Constants.AXIS_BUTTON_THRESHHOLD);
		joyOuttake.whenPressed(new AutoStraight());
		

        joyClimbUp = new JoystickButton(theXbox, 3);
        joyClimbUp.whenPressed(new BackIn());
		
        joyClimbDown = new JoystickButton(theXbox, 4);
		joyClimbDown.whenPressed(new BackOut());
		

		
        joyClimbUpTwo = new JoystickButton(theXbox, 1);
		joyClimbUpTwo.whenPressed(new FrontIn());
		
		joyClimbDownTwo = new JoystickButton(theXbox, 2);
		joyClimbDownTwo.whenPressed(new FrontOut());
		
		
//        joyRoombaOut = new JoystickButton(theJoystick, 2);
//        joyRoombaOut.whileHeld(new roombaOut());
		
//        joyRoombaIn = new JoystickButton(theJoystick, 1);
//        joyRoombaIn.whileHeld(new roombaIn());
        
	}




	//a method for the joystick
	public Joystick getTheJoystick() {
        return theXbox;
    }
}
