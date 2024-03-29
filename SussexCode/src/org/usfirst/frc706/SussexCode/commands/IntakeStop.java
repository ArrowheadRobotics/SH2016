package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class IntakeStop extends Command {

    public IntakeStop() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.manualIntake = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.intakeintakeDrive.set(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
