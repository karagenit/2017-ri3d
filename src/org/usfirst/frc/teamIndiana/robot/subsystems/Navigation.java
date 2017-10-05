package org.usfirst.frc.teamIndiana.robot.subsystems;

import org.usfirst.frc.teamIndiana.robot.Constants;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Navigation extends Subsystem {

	public AHRS navX = new AHRS(SPI.Port.kMXP);
	public Encoder leftSense = new Encoder(Constants.dioLeftA, Constants.dioLeftB, false, EncodingType.k4X);
	public Encoder rightSense = new Encoder(Constants.dioRightA, Constants.dioRightB, true, EncodingType.k4X);
	
	public Navigation() {
		navX.reset();
		leftSense.reset();
		rightSense.reset();
		
		leftSense.setDistancePerPulse(Constants.leftSenseDPP);
		rightSense.setDistancePerPulse(Constants.rightSenseDPP);
	}
	
	public void resetSensors() {
		navX.reset();
		leftSense.reset();
		rightSense.reset();
	}
	
	public double getLeftDistance() {
		return leftSense.getDistance();
	}
	
	public double getRightDistance() {
		return rightSense.getDistance();
	}
	
	public double getAvgDistance() {
		return ((leftSense.getDistance() + rightSense.getDistance()) / 2);
	}
	
	public double getLeftRate() {
		return leftSense.getRate();
	}
	
	public double getRightRate() {
		return rightSense.getRate();
	}
	
	public double getAvgRate() {
		return ((leftSense.getRate() + rightSense.getRate()) / 2);
	}
	
    public void initDefaultCommand() {
    	//Left Intentionally Blank
    }
}

