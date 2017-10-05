package org.usfirst.frc.teamIndiana.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	public boolean sensorReset;
	public double deadband;
	public double leftAutoSpeed, leftAutoStraight, leftAutoTurn, leftAutoToPeg, leftAutoScore, leftAutoClear;
	public double centerAutoSpeed, centerAutoToPeg, centerAutoScore, centerAutoClear;
	public double rightAutoSpeed, rightAutoStraight, rightAutoTurn, rightAutoToPeg, rightAutoScore, rightAutoClear;
	public int autoMode;
	
	public void initDash() {
		SmartDashboard.putBoolean("Reset", false);

		SmartDashboard.putNumber("Autonomous Mode", 0);

		SmartDashboard.putNumber("Left Auto Speed", Constants.leftAutoSpeedDefault);
		SmartDashboard.putNumber("Left Auto Time - Straight", Constants.leftAutoStraightDefault);
		SmartDashboard.putNumber("Left Auto Time - Turn", Constants.leftAutoTurnDefault);
		SmartDashboard.putNumber("Left Auto Time - To Peg", Constants.leftAutoToPegDefault);
		SmartDashboard.putNumber("Left Auto Time - Score", Constants.leftAutoScoreDefault);
		SmartDashboard.putNumber("Left Auto Time - Score", Constants.leftAutoClearDefault);

		SmartDashboard.putNumber("Center Auto Speed", Constants.centerAutoSpeedDefault);
		SmartDashboard.putNumber("Center Auto Time - To Peg", Constants.centerAutoToPegDefault);
		SmartDashboard.putNumber("Center Auto Time - Score", Constants.centerAutoScoreDefault);
		SmartDashboard.putNumber("Center Auto Time - Score", Constants.centerAutoClearDefault);
		
		SmartDashboard.putNumber("Right Auto Speed", Constants.rightAutoSpeedDefault);
		SmartDashboard.putNumber("Right Auto Time - Straight", Constants.rightAutoStraightDefault);
		SmartDashboard.putNumber("Right Auto Time - Turn", Constants.rightAutoTurnDefault);
		SmartDashboard.putNumber("Right Auto Time - To Peg", Constants.rightAutoToPegDefault);
		SmartDashboard.putNumber("Right Auto Time - Score", Constants.rightAutoScoreDefault);
		SmartDashboard.putNumber("Right Auto Time - Score", Constants.rightAutoClearDefault);

		SmartDashboard.putNumber("Controller Deadband", Constants.initDeadband);
	}
	
	public void updateDash() {
		//Driver Input Values
		SmartDashboard.putNumber("Controller LY", Robot.oi.leftY);
		SmartDashboard.putNumber("Controller RY", Robot.oi.rightY);
		
		//Encoder Values
		SmartDashboard.putNumber("Left Y Distance", Robot.navigation.getLeftDistance());
		SmartDashboard.putNumber("Right Y Distance", Robot.navigation.getRightDistance());
		SmartDashboard.putNumber("Left Y Rate", Robot.navigation.getLeftRate());
		SmartDashboard.putNumber("Right Y Rate", Robot.navigation.getRightRate());
		
		//NavX Values
		SmartDashboard.putNumber("Heading", Robot.navigation.navX.getAngle());
		//SmartDashboard.putNumber("Distance X", Robot.navigation.navX.getDisplacementX());
		//SmartDashboard.putNumber("Distance Y", Robot.navigation.navX.getDisplacementY());
		//SmartDashboard.putNumber("Distance Z", Robot.navigation.navX.getDisplacementZ());
		//SmartDashboard.putNumber("Velocity X", Robot.navigation.navX.getVelocityX());
		//SmartDashboard.putNumber("Velocity Y", Robot.navigation.navX.getVelocityY());
		//SmartDashboard.putNumber("Velocity Z", Robot.navigation.navX.getVelocityZ());
	}
	
	public void getDash(){
		autoMode = (int) SmartDashboard.getNumber("Autonomous Mode", 0);
		
		leftAutoSpeed = SmartDashboard.getNumber("Left Auto Speed", Constants.leftAutoSpeedDefault);
		leftAutoStraight = SmartDashboard.getNumber("Left Auto Time - Straight", Constants.leftAutoStraightDefault);
		leftAutoTurn = SmartDashboard.getNumber("Left Auto Time - Turn", Constants.leftAutoTurnDefault);
		leftAutoToPeg = SmartDashboard.getNumber("Left Auto Time - To Peg", Constants.leftAutoToPegDefault);
		leftAutoScore = SmartDashboard.getNumber("Left Auto Time - Score", Constants.leftAutoScoreDefault);
		leftAutoClear = SmartDashboard.getNumber("Left Auto Time - Score", Constants.leftAutoClearDefault);

		centerAutoSpeed = SmartDashboard.getNumber("Center Auto Speed", Constants.centerAutoSpeedDefault);
		centerAutoToPeg = SmartDashboard.getNumber("Center Auto Time - To Peg", Constants.centerAutoToPegDefault);
		centerAutoScore = SmartDashboard.getNumber("Center Auto Time - Score", Constants.centerAutoScoreDefault);
		centerAutoClear = SmartDashboard.getNumber("Center Auto Time - Score", Constants.centerAutoClearDefault);
		
		rightAutoSpeed = SmartDashboard.getNumber("right Auto Speed", Constants.rightAutoSpeedDefault);
		rightAutoStraight = SmartDashboard.getNumber("right Auto Time - Straight", Constants.rightAutoStraightDefault);
		rightAutoTurn = SmartDashboard.getNumber("right Auto Time - Turn", Constants.rightAutoTurnDefault);
		rightAutoToPeg = SmartDashboard.getNumber("right Auto Time - To Peg", Constants.rightAutoToPegDefault);
		rightAutoScore = SmartDashboard.getNumber("right Auto Time - Score", Constants.rightAutoScoreDefault);
		rightAutoClear = SmartDashboard.getNumber("right Auto Time - Score", Constants.rightAutoClearDefault);
		
		deadband = SmartDashboard.getNumber("Controller Deadband", Constants.initDeadband);
		
		if (SmartDashboard.getBoolean("Reset", false)) {
			Robot.navigation.resetSensors();
		}
	}
}
