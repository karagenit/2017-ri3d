package org.usfirst.frc.teamIndiana.robot.commands;

import org.usfirst.frc.teamIndiana.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BaselineAuton extends Command {
	private int step_counter;

    public BaselineAuton() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	step_counter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.teleTank(0.5, 0.5);
    	step_counter++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return step_counter > 400;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stahp();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
