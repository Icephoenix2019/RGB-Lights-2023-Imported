// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
  //   // Configure the button bindings
  //   configureButtonBindings();
    Shuffleboard.startRecording();
    startCapture();

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
  //  */
  // private void configureButtonBindings() {
    
  // }

  private void startCapture() {
    // creates a thread which runs concurrently with the program
		new Thread(() -> {
      // Instantiate the USB cameras and begin capturing their video streams
      UsbCamera camera = CameraServer.startAutomaticCapture(0);

      // set the cameras' resolutions and FPS
			camera.setResolution(160, 120);
      camera.setFPS(30);
		}).start();
	}


}
