package org.usfirst.frc.teamIndiana.robot.subsystems;

import org.usfirst.frc.teamIndiana.robot.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearScore extends Subsystem {

	public DoubleSolenoid gear = new DoubleSolenoid(Constants.pcmID, Constants.pcmGearScore, Constants.pcmGearRetract);
	
	public void gearScore() {
		gear.set(DoubleSolenoid.Value.kForward);
	}
	
	public void gearStore(){
		gear.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void gearDefault(){
		gear.set(DoubleSolenoid.Value.kOff);
	}
	
    public void initDefaultCommand() {
    	//Left Intentionally Blank
    }
}

