package org.usfirst.frc.teamIndiana.robot.subsystems;

import org.usfirst.frc.teamIndiana.robot.Constants;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    private final Talon climberLeft;
    private final Talon climberRight;
    
    public Climber() {
    	climberLeft = new Talon(Constants.pwmClimberLeft);
    	climberRight = new Talon(Constants.pwmClimberRight);
    }
    
    public void climb(boolean climb) {
    	if (climb) {
    		climberLeft.set(-Constants.climbSpeed);
    		climberRight.set(Constants.climbSpeed);
    	} else {
    		climberLeft.set(0);
    		climberRight.set(0);
    	}
    }

    public void initDefaultCommand() {
        //Left intentionally blank
    }
}

