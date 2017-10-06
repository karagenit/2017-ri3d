package org.usfirst.frc.teamIndiana.robot.commands;

import org.usfirst.frc.teamIndiana.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OpControl extends Command {

	public boolean gearPosition = false;
	public double leftSpeed, rightSpeed;
	
    public OpControl() {
        requires(Robot.drive);
    }

    protected void initialize() {
    	//Left Intentionally Blank
    }

    protected void execute() {
    	Robot.drive.teleTank(Robot.oi.leftY, Robot.oi.rightY);
    	
    	Robot.climb.climb(Robot.oi.climb);
    	
    	if (Robot.oi.score && !gearPosition){
    		Robot.gear.gearScore();
    		gearPosition = true;
    	} else if (!Robot.oi.score && gearPosition){
    		Robot.gear.gearStore();
    		gearPosition = false;
    	} else {
    		Robot.gear.gearDefault();
    	}
    }
    
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drive.stahp();
    }
    
    protected void interrupted() {} //calls end() automatically
}
