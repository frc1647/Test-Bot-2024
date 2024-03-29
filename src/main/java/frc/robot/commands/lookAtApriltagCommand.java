package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.AutoConstants.lookAtApriltagConstants;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Drivetrain;

public class lookAtApriltagCommand extends Command{
    Camera camera;
    Drivetrain drivetrain;

    public lookAtApriltagCommand(Camera m_camera, Drivetrain m_drivetrain) {
        camera = m_camera;
        drivetrain = m_drivetrain;

        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(camera, drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(camera.getHasTarget()){
            drivetrain.rawTankDrive(camera.getYawAngle() * lookAtApriltagConstants.kP, -camera.getYawAngle() * lookAtApriltagConstants.kP);
        } else {
            drivetrain.rawTankDrive(0, 0);
        }

        /*if(camera.getRange()>12){
            drivetrain.tankDrive(.7, .7);
        }*/
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(camera.getHasTarget()){
            return Math.abs(camera.getYawAngle()) < 3;
        } else {
            return false;
        }
    }
}
