// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.AddressableLED;

public class RGBLightSystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public AddressableLEDBuffer LEDStrip;
  public AddressableLED m_led;

  public RGBLightSystem() {
    LEDStrip = new AddressableLEDBuffer(60);
    m_led = new AddressableLED(0);
    m_led.setLength(LEDStrip.getLength());
  }

  public CommandBase display_color() {
    return runOnce(
      () -> {
        for (var i = 0; i < LEDStrip.getLength(); i++) {
          // Sets the specified LED to the RGB values for red
          LEDStrip.setRGB(i, 0, 225, 0);
        }
      });
  }

  public CommandBase stop_color() {
    return runOnce(
      () -> {
        m_led.stop();
      }
    );
  }

  // @Override
  // public void periodic() {
    
  // }

  // @Override
  // public void simulationPeriodic() {
  //   // This method will be called once per scheduler run during simulation
  // }
}
