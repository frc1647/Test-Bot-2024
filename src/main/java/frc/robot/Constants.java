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
    public static final int kOperatorControllerPort = 1;
  }

  public static class DrivetrainConstants {
    public static final int kLeftFrontID = 9;
    public static final int kLeftBackID = 5;
    public static final int krightFrontID = 10;
    public static final int krightBackID = 2;

    public static final double kDriveDeadband = .05;

    public static final double kTrainingWheels = 0.55;
  }

  public static class CameraConstants {

    // height of apriltag - height of camera
    public static final double kApriltagHeightDifferenceInches = 57 - 6;
    public static final double kCameraAngle = 34;
  }

  public static class AutoConstants {

    public static class lookAtApriltagConstants {
    // height of apriltag - height of camera
      public static final double kP = .01;
      //public static final double kI = 34;
    }
  }
}
