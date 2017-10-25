
package org.usfirst.frc.teamIndiana.robot;

import org.usfirst.frc.teamIndiana.robot.util.Deadband;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	public static final double TRIGGER_THRESH = 0.8;
	public static final double UPSHIFT_THRESH = 0.9;
	public static final double DOWNSHIFT_THRESH = 0.5;

	private Joystick driver				= new Joystick(Constants.usbDriver);

	public boolean score, climb;
	public double leftY, rightY, rightX; //TODO why not have getters that force update via getRaw*()?
	public boolean doUpshift, doDownshift;

	public void getOI(){
		//Drive Controls
		leftY = -1.0 * Deadband.calcDeadbandOut(driver.getRawAxis(Constants.controllerLY));
		rightY = -1.0 * Deadband.calcDeadbandOut(driver.getRawAxis(Constants.controllerRY));

		rightX = -1.0 * Deadband.calcDeadbandOut(driver.getRawAxis(Constants.controllerRX));
		score = driver.getRawButton(Constants.controllerLB);
		climb = driver.getRawButton(Constants.controllerB);

		if(Robot.dash.useAutoShift) {
			if(Robot.dash.useArcade) {
				doUpshift = Math.abs(leftY) > UPSHIFT_THRESH;
			} else {
				doUpshift = Math.abs(leftY) > UPSHIFT_THRESH && Math.abs(rightY) > UPSHIFT_THRESH;
			}

			if(Robot.dash.useArcade) {
				doDownshift = Math.abs(leftY) < DOWNSHIFT_THRESH;
			} else {
				doDownshift = Math.abs(leftY) < DOWNSHIFT_THRESH && Math.abs(rightY) < DOWNSHIFT_THRESH;
			}
		} else { //Don't use AutoShift
			doUpshift = driver.getRawAxis(Constants.controllerRT)  > TRIGGER_THRESH;
			doDownshift = !doUpshift;
		}

	}
}
