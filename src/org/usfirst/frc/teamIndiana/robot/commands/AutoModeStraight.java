package org.usfirst.frc.teamIndiana.robot.commands;

import org.usfirst.frc.teamIndiana.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoModeStraight extends Command {

	private Timer centerAuto = new Timer();
	
    public AutoModeStraight() {
        requires(Robot.drive);
    }

    protected void initialize() {
    	centerAuto.reset();
    	centerAuto.start();
    }

    protected void execute() {

    	//Drive To Peg
    	if			(centerAuto.hasPeriodPassed(0.0)							&& !centerAuto.hasPeriodPassed(Robot.dash.centerAutoToPeg)) {
    		Robot.drive.autoDrive(Robot.dash.centerAutoSpeed, 0.0);
    	
    	//Score
    	} else if	(centerAuto.hasPeriodPassed(Robot.dash.centerAutoToPeg)		&& !centerAuto.hasPeriodPassed(Robot.dash.centerAutoScore)) {
    		Robot.gear.gearScore();

    	//Clear Peg
    	} else if	(centerAuto.hasPeriodPassed(Robot.dash.centerAutoScore)		&& !centerAuto.hasPeriodPassed(Robot.dash.centerAutoClear))	{
    		Robot.gear.gearStore();
    		Robot.drive.autoDrive((-1.0 * Robot.dash.centerAutoSpeed), 0.0);
        	
        //End of Auto    	
    	} else {
    		Robot.drive.stahp();
    	}
    }

    protected boolean isFinished() {
        if (centerAuto.hasPeriodPassed(15.0)){
        	return true;
        } else {
        	return false;
        }
    }

    protected void end() {
		Robot.drive.stahp();
    }

    protected void interrupted() {} //calls end() automatically
}
