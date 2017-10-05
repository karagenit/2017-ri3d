package org.usfirst.frc.teamIndiana.robot;

import org.usfirst.frc.teamIndiana.robot.commands.AutoModeLeft;
import org.usfirst.frc.teamIndiana.robot.commands.AutoModeRight;
import org.usfirst.frc.teamIndiana.robot.commands.AutoModeStraight;
import org.usfirst.frc.teamIndiana.robot.commands.OpControl;

import org.usfirst.frc.teamIndiana.robot.subsystems.Drivetrain;
import org.usfirst.frc.teamIndiana.robot.subsystems.Navigation;
import org.usfirst.frc.teamIndiana.robot.subsystems.GearScore;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	//Utilities
	public static OI oi;
	public static Dashboard dash;
	
	//Commands
	private OpControl tele					= new OpControl();
	private AutoModeLeft leftPegAuto		= new AutoModeLeft();
	private AutoModeStraight centerPegAuto	= new AutoModeStraight();
	private AutoModeRight rightPegAuto		= new AutoModeRight();
	
	//Subsystems
	public static Drivetrain drive			= new Drivetrain();
	public static Navigation navigation		= new Navigation();
	public static GearScore gear			= new GearScore();

	//Variables
	public static int autoState = 0;
	
	@Override
	public void robotInit() {
		dash = new Dashboard();
		oi = new OI();
		dash.initDash();
	}

	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		dash.updateDash();
		dash.getDash();
	}

	@Override
	public void autonomousInit() {
		Scheduler.getInstance().removeAll();

		//Autonomous Mode Selection
		switch (dash.autoMode) {
			case 1:
				leftPegAuto.start();
				break;
			case 2:
				centerPegAuto.start();
				break;
			case 3:
				rightPegAuto.start();
				break;
			default:
				break;
		}
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		dash.getDash();
		dash.updateDash();
	}

	@Override
	public void teleopInit() {
		Scheduler.getInstance().removeAll();
		tele.start();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		oi.getOI();
		dash.getDash();
		dash.updateDash();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
