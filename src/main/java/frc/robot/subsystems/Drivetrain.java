// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static frc.robot.Constants.DrivetrainConstants.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  DifferentialDrive m_drivetrain;

  public Drivetrain() {
    WPI_VictorSPX leftFront = new WPI_VictorSPX(kLeftFrontID);
    WPI_VictorSPX leftBack = new WPI_VictorSPX(kLeftBackID);
    WPI_VictorSPX rightFront = new WPI_VictorSPX(krightFrontID);
    WPI_VictorSPX rightBack = new WPI_VictorSPX(krightBackID);
    
    // coast mode
    leftFront.setNeutralMode(NeutralMode.Coast);
    leftBack.setNeutralMode(NeutralMode.Coast);
    rightFront.setNeutralMode(NeutralMode.Coast);
    rightBack.setNeutralMode(NeutralMode.Coast);

    // Set the rear motors to follow the front motors.
    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    // Invert the left side so both side drive forward with positive motor outputs
    leftFront.setInverted(false);
    rightFront.setInverted(true);
    rightBack.setInverted(true);


    // Put the front motors into the differential drive object. This will control all 4 motors with
    // the rears set to follow the fronts
    m_drivetrain = new DifferentialDrive(leftFront, rightFront);
    m_drivetrain.setDeadband(kDriveDeadband);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    m_drivetrain.tankDrive(kTrainingWheels * leftSpeed, kTrainingWheels * rightSpeed);
  }
}
