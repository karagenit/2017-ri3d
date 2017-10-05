package org.usfirst.frc.teamIndiana.robot.commands;

import org.usfirst.frc.teamIndiana.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoModeLeft extends Command {

	private Timer leftAuto = new Timer();
	
    public AutoModeLeft() {
        requires(Robot.drive);
    }

    protected void initialize() {
    	leftAuto.reset();
    	leftAuto.start();
    }

    protected void execute() {
    	
    	//Drive Straight
    	if			(leftAuto.hasPeriodPassed(0.0)							&& !leftAuto.hasPeriodPassed(Robot.dash.leftAutoStraight)) {
    		Robot.drive.autoDrive(Robot.dash.leftAutoSpeed, 0.0);
    		
    	//Turn Toward Peg
    	} else if	(leftAuto.hasPeriodPassed(Robot.dash.leftAutoStraight)	&& !leftAuto.hasPeriodPassed(Robot.dash.leftAutoTurn)) {
    		Robot.drive.autoDrive(0.0, Robot.dash.leftAutoSpeed);
    	
    	//Drive to Peg
    	} else if	(leftAuto.hasPeriodPassed(Robot.dash.leftAutoTurn)		&& !leftAuto.hasPeriodPassed(Robot.dash.leftAutoToPeg)) {
    		Robot.drive.autoDrive(Robot.dash.leftAutoSpeed, 0.0);
    	
    	//Score
    	} else if	(leftAuto.hasPeriodPassed(Robot.dash.leftAutoToPeg)		&& !leftAuto.hasPeriodPassed(Robot.dash.leftAutoScore)) {
    		Robot.gear.gearScore();

    	//Clear Peg
    	} else if	(leftAuto.hasPeriodPassed(Robot.dash.leftAutoScore)		&& !leftAuto.hasPeriodPassed(Robot.dash.leftAutoClear))	{
    		Robot.gear.gearStore();
    		Robot.drive.autoDrive((-1.0 * Robot.dash.leftAutoSpeed), 0.0);
        	
        //End of Auto    	
    	} else {
    		Robot.drive.stahp();
    	}
    	
    }

    protected boolean isFinished() {
        if (leftAuto.hasPeriodPassed(15.0)){
        	return true;
        } else {
        	return false;
        }
    }

    protected void end() {
    	Robot.drive.stahp();
    }

    protected void interrupted() {
    	Robot.drive.stahp();
    }
}
