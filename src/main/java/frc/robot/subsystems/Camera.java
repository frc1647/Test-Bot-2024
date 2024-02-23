package frc.robot.subsystems;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.CameraConstants.*;

public class Camera extends SubsystemBase {
    
    PhotonCamera camera = new PhotonCamera("photonvision");
  
    PhotonTrackedTarget target;
  	double yaw;
  	double pitch;
  	double area;
  	double skew;
    int targetID;

    double range;


    public void aprilTagData(){
        var result = camera.getLatestResult();
        if(result.hasTargets()){
            yaw = target.getYaw();
            pitch = target.getPitch();
            area = target.getArea();
            targetID = target.getFiducialId();
        }
  	}

  	public double getRange(){
  		var result = camera.getLatestResult();
      if (result.hasTargets()) {
        return ;
  	}
  	
  	
  	public double latency() {
    	var result = camera.getLatestResult();
      camera.setDriverMode(true);
  		camera.setPipelineIndex(2);
  		return result.getLatencyMillis() / 1000.0;
  	}
  }
