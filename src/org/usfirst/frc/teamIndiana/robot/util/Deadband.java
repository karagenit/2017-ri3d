package org.usfirst.frc.teamIndiana.robot.util;

import org.usfirst.frc.teamIndiana.robot.Robot;

public class Deadband {

	public static double calcDeadbandOut(double input){
		double deadband_pos = Math.abs(Robot.dash.deadband);
		double deadband_neg = -1.0 * deadband_pos;
		
		if (input < deadband_neg || input > deadband_pos) {
			return input;
		} else {
			return 0.0;
		}
	}
}
