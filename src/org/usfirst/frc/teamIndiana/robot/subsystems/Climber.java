package org.usfirst.frc.teamIndiana.robot.subsystems;

import org.usfirst.frc.teamIndiana.robot.Constants;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    private final Spark climber;
    
    public Climber() {
    	climber = new Spark(Constants.pwmClimber);
    }
    
    public void climb(boolean climb) {
    	if (climb) {
    		climber.set(Constants.climbSpeed);
    	} else {
    		climber.set(0);
    	}
    }

    public void initDefaultCommand() {
        //Left intentionally blank
    }
}

