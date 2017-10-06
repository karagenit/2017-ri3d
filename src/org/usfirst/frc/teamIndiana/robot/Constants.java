package org.usfirst.frc.teamIndiana.robot;

public class Constants {
	
	//Driver Station USB Mapping
	public static int usbDriver = 0;
	
	//RoboRIO PWM Mapping
	public static int pwmDriveLeft		= 1;
	public static int pwmDriveRight		= 2;
	public static int pwmClimber		= 3;
	
	//RoboRIO DIO Mapping
	public static int dioLeftA		= 0;
	public static int dioLeftB		= 1;
	public static int dioRightA		= 2;
	public static int dioRightB		= 3;
	
	//PCM Mapping
	public static int pcmID				= 1;
	public static int pcmShifter		= 0;
	public static int pcmGearRetract	= 1;
	public static int pcmGearScore		= 2;
	
	//Controller Deadband
	public static double initDeadband = 0.01;
	
	//Controller Button Mapping
	public static int controllerA		= 1;
	public static int controllerB		= 2;
	public static int controllerX		= 3;
	public static int controllerY		= 4;
	public static int controllerLB		= 5;
	public static int controllerRB		= 6;
	public static int controllerSel		= 7;
	public static int controllerStart	= 8;
	public static int controllerL3		= 9;
	public static int controllerR3		= 10;
	
	//Controller Axis Mapping
	public static int controllerLX	= 0;
	public static int controllerLY	= 1;
	public static int controllerLT	= 2;
	public static int controllerRT	= 3;
	public static int controllerRX	= 4;
	public static int controllerRY	= 5;
	
	//PID Constants
	public static double pidDistP	= 0.0725;
	public static double pidDistI	= 0.0;
	public static double pidDistD	= 0.0;
	public static double pidAngleP	= 0.0;
	public static double pidAngleI	= 0.0;
	public static double pidAngleD	= 0.0;
	
	//Sensor Constants
	public static double leftSenseDPP	= 0.0406666;
	public static double rightSenseDPP	= 0.0406666;
	
	//Robot Setting Constants
	public static double shiftUpDefault			= 7.5;
	public static double shiftDownDefault		= 3.0;
	public static double climbSpeed				= 1.0;
	
	//Left Airship Autonomous Settings
	public static double leftAutoSpeedDefault		= 0.8;
	public static double leftAutoStraightDefault	= 3.0;
	public static double leftAutoTurnDefault		= 4.0;
	public static double leftAutoToPegDefault		= 6.0;
	public static double leftAutoScoreDefault		= 8.0;
	public static double leftAutoClearDefault		= 10.0;

	//Center Airship Autonomous Settings
	public static double centerAutoSpeedDefault		= 0.8;
	public static double centerAutoToPegDefault		= 4.0;
	public static double centerAutoScoreDefault		= 6.0;
	public static double centerAutoClearDefault		= 8.0;
	
	//Right Airship Autonomous Settings
	public static double rightAutoSpeedDefault		= 0.8;
	public static double rightAutoStraightDefault	= 3.0;
	public static double rightAutoTurnDefault		= 4.0;
	public static double rightAutoToPegDefault		= 6.0;
	public static double rightAutoScoreDefault		= 8.0;
	public static double rightAutoClearDefault		= 10.0;
}