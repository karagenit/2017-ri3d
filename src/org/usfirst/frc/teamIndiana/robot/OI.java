
package org.usfirst.frc.teamIndiana.robot;

import org.usfirst.frc.teamIndiana.robot.util.Deadband;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	private Joystick driver				= new Joystick(Constants.usbDriver);
	
	public boolean shift, score, climb;
	public double leftY, rightY, rightX; //TODO why not have getters that force update via getRaw*()?
	
	public void getOI(){
		//Drive Controls
		leftY = -1.0 * Deadband.calcDeadbandOut(driver.getRawAxis(Constants.controllerLY));
		rightY = -1.0 * Deadband.calcDeadbandOut(driver.getRawAxis(Constants.controllerRY));
		
		shift = driver.getRawAxis(Constants.controllerRT)  > 0.8;
		rightX = -1.0 * Deadband.calcDeadbandOut(driver.getRawAxis(Constants.controllerRX));
		score = driver.getRawButton(Constants.controllerLB);
		climb = driver.getRawButton(Constants.controllerB);
	}
}
