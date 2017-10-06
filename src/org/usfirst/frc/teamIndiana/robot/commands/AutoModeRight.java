package org.usfirst.frc.teamIndiana.robot.commands;

import org.usfirst.frc.teamIndiana.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoModeRight extends Command {

	private Timer rightAuto = new Timer();
	
    public AutoModeRight() {
        requires(Robot.drive);
    }

    protected void initialize() {
    	rightAuto.reset();
    	rightAuto.start();
    }

    protected void execute() {
    	
    	//Drive Straight
    	if			(rightAuto.hasPeriodPassed(0.0)							&& !rightAuto.hasPeriodPassed(Robot.dash.rightAutoStraight)) {
    		Robot.drive.autoDrive(Robot.dash.rightAutoSpeed, 0.0);
    		
    	//Turn Toward Peg
    	} else if	(rightAuto.hasPeriodPassed(Robot.dash.rightAutoStraight)	&& !rightAuto.hasPeriodPassed(Robot.dash.rightAutoTurn)) {
    		Robot.drive.autoDrive(0.0, (-1.0 * Robot.dash.rightAutoSpeed));
    	
    	//Drive to Peg
    	} else if	(rightAuto.hasPeriodPassed(Robot.dash.rightAutoTurn)		&& !rightAuto.hasPeriodPassed(Robot.dash.rightAutoToPeg)) {
    		Robot.drive.autoDrive(Robot.dash.rightAutoSpeed, 0.0);
    	
    	//Score
    	} else if	(rightAuto.hasPeriodPassed(Robot.dash.rightAutoToPeg)		&& !rightAuto.hasPeriodPassed(Robot.dash.rightAutoScore)) {
    		Robot.gear.gearScore();

    	//Clear Peg
    	} else if	(rightAuto.hasPeriodPassed(Robot.dash.rightAutoScore)		&& !rightAuto.hasPeriodPassed(Robot.dash.rightAutoClear))	{
    		Robot.gear.gearStore();
    		Robot.drive.autoDrive((-1.0 * Robot.dash.rightAutoSpeed), 0.0);
        	
        //End of Auto    	
    	} else {
    		Robot.drive.stahp();
    	}
    }

    protected boolean isFinished() {
        if (rightAuto.hasPeriodPassed(15.0)){
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
