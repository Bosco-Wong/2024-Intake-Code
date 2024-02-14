// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

    //code begins here

    public class IntakeConstants{
      public static final int r1Id = 0;
      public static final int r2Id = 1;
      public static final int a1Id = 2;
      //not sure what this does

      public static enum IntakeState{
        INTAKE(0.5),
        OUTTAKE(-0.5),
        OFF(0);
        //create states that the intake will change into through the function in Intake class 
        
         public final double speed;
         IntakeState(double speed){
          this.speed = speed;
          //variable speed made so that speed can be changed through the intake states above
         }
      }

        public static enum ArmState{
        HIGH(0),
        LOW(0),
        NEUTRAL(0);
        
        
         public final double pos;
          ArmState(double pos){
          this.pos = pos;
          //variable speed made so that speed can be changed through the intake states above
         }
      }

      public static final double armkP = 0;
      public static final double armkI = 0;
      public static final double armkD = 0;

    }

    public static class JoystickConstants{
    public static final class Secondary {
      public static final int port = 1;
      //port of which the joystick is plugged into the driver station laptop
      public static final int intake = 1;
      public static final int outtake = 2;
      //which buttons that the action corresponds to on the joystick
      public static final int raise = 3;
      public static final int lower = 4;
      public static final int neutral = 5;
    
    }
 }
    
}
