package org.usfirst.frc.teamIndiana.robot.subsystems;

import org.usfirst.frc.teamIndiana.robot.Constants;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public RobotDrive driveOut;
	public Solenoid shifting = new Solenoid(Constants.pcmID, Constants.pcmShifter);

	public Drivetrain() {
		driveOut = new RobotDrive(Constants.pwmDriveLeft, Constants.pwmDriveRight);
		driveOut.setExpiration(0.5);
	}
	
	public void teleTank(double leftOutput, double rightOutput) {
		driveOut.tankDrive(leftOutput, rightOutput);
	}
	
	public void teleArcade(double power, double turning) {
		driveOut.arcadeDrive(power, turning, false);
	}
	
	public void shiftHappens(boolean gear){
		shifting.set(gear);
	}
	
	public void autoDrive(double distance, double angle) {
		driveOut.drive(distance, angle);
	}
	
	public void stahp() {
		driveOut.drive(0.0, 0.0);
	}

	@Override
	protected void initDefaultCommand() {
		//Left Intentionally Blank		
	}
}

