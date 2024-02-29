
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.AutoConstants.lookAtObjectConstants;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.CANDrivetrain;

public class lookAtObject extends Command{
    Camera camera;
    CANDrivetrain drivetrain;

    public lookAtObject(Camera m_camera, CANDrivetrain m_drivetrain) {
        m_camera = camera;
        m_drivetrain = drivetrain;

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
	if(camera.getRange() > 12){
  drivetrain.rawTankDrive(.1,.1);
            }
            }
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
