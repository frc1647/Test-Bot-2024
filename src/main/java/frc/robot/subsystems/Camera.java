package frc.robot.subsystems;

import static frc.robot.Constants.CameraConstants.kApriltagHeightDifferenceInches;
import static frc.robot.Constants.CameraConstants.kCameraAngle;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera extends SubsystemBase {
    
  PhotonCamera camera;
  PhotonTrackedTarget target;
  PhotonPipelineResult result;

  double yaw = 0;
  double pitch = 0;
  double range = 0;
  int tagID;


  public Camera() {
    camera = new PhotonCamera("FrontCam");

    camera.setPipelineIndex(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    result = camera.getLatestResult();

    SmartDashboard.putBoolean("Target?", result.hasTargets());

    if(result.hasTargets()){
      for (int i = 0; i < result.getTargets().size(); i++) {
        
        tagID = result.getTargets().get(i).getFiducialId();
        if (tagID == 4 || tagID == 7) {
          
          target = result.getTargets().get(i);
          
          yaw = target.getYaw();
          pitch = target.getPitch();
          range = kApriltagHeightDifferenceInches / Math.tan(Math.toRadians(kCameraAngle + pitch));
        }
      }

    
      SmartDashboard.putNumber("yaw", yaw);
      SmartDashboard.putNumber("pitch", pitch);
      SmartDashboard.putNumber("range", range);
    }
  }


  public boolean getHasTarget(){
    return result.hasTargets();
  }

  public double getRange(){
    return range;
  }

  public double getYawAngle(){ //range: (_,_)
    return yaw;
  }

  public double latency() {
    camera.setDriverMode(true);
    camera.setPipelineIndex(2);
    return result.getLatencyMillis() / 1000.0;
  }
}