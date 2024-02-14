// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.IntakeConstants.IntakeState;
import frc.robot.Constants.IntakeConstants.ArmState;
import frc.robot.subsystems.Intake;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  //as said above, this is where the robot is actually made. Everything else before was just the "blueprint" of the robot
  private final Joystick secondary = new Joystick(Constants.JoystickConstants.Secondary.port);
  //make a Joystick for secondary (intake)
  private final JoystickButton intakeButton = new JoystickButton(secondary, Constants.JoystickConstants.Secondary.intake);
  //make a joystick button that switches the intake into intake mode
  private final JoystickButton outtakeButton = new JoystickButton(secondary, Constants.JoystickConstants.Secondary.outtake);
  //make a joystick button that switches the intake into outtake mode
  private final JoystickButton raiseButton = new JoystickButton(secondary, Constants.JoystickConstants.Secondary.raise);
  private final JoystickButton lowerButton = new JoystickButton(secondary, Constants.JoystickConstants.Secondary.lower);
  private final JoystickButton tuckButton = new JoystickButton(secondary, Constants.JoystickConstants.Secondary.neutral);

  private final Intake intake = new Intake();
  //make our intake subsystem


  public RobotContainer() {
    configureBindings();
  }

 
  private void configureBindings() {

    intakeButton.onTrue(new InstantCommand(() -> intake.setState(IntakeState.INTAKE))); 
    outtakeButton.onTrue(new InstantCommand(() -> intake.setState(IntakeState.OUTTAKE))); 
    raiseButton.onTrue(new InstantCommand(() -> intake.seta1State(ArmState.HIGH)));
    lowerButton.onTrue(new InstantCommand(() -> intake.seta1State(ArmState.LOW))); 
    tuckButton.onTrue(new InstantCommand(() -> intake.seta1State(ArmState.NEUTRAL)));

 
   
  }


  public Command getAutonomousCommand() {
  
    return null;
  }
}
