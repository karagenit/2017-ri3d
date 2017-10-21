package org.usfirst.frc.teamIndiana.robot.commands;

import org.usfirst.frc.teamIndiana.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OpControl extends Command {

	public boolean gearPosition = false, highGear = false; //TODO instead of storing it here, we should have a getter in Drivetrain
	public double leftSpeed, rightSpeed;
	
    public OpControl() {
        requires(Robot.drive);
    }

    protected void initialize() {
    	//Left Intentionally Blank
    }

    protected void execute() {
    	if(Robot.dash.useArcade) {
    		Robot.drive.teleArcade(Robot.oi.leftY, Robot.oi.rightX);
    	} else {
    		Robot.drive.teleTank(Robot.oi.leftY, Robot.oi.rightY);
    	}
    	
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
    	
    	if (isUpshift() && !highGear) {
    		Robot.drive.shiftHappens(true);
    		highGear = true;
    	} else if (isDownshift() && highGear) {
    		Robot.drive.shiftHappens(false);
    		highGear = false;
    	}
    	
    }
    
    private boolean isUpshift() {
    	if(Robot.dash.useArcade) {
    		return Math.abs(Robot.oi.leftY) > 0.9;
    	} else {
    		return Math.abs(Robot.oi.leftY) > 0.9 && Math.abs(Robot.oi.rightY) > 0.9;
    	}
    }
    
    private boolean isDownshift() {
    	if(Robot.dash.useArcade) {
    		return Math.abs(Robot.oi.leftY) < 0.5;
    	} else {
    		return Math.abs(Robot.oi.leftY) < 0.5 && Math.abs(Robot.oi.rightY) > 0.9;
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
