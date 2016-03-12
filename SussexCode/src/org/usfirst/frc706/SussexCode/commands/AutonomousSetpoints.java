// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

/**
 *
 */
public class AutonomousSetpoints extends Command {
	
	String intakePos;
	String shooterPos;
	boolean done = false;
	public boolean atPos = false;
	
    public AutonomousSetpoints(String intake, String shooter) {
    	intakePos = intake;
    	shooterPos = shooter;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    	RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    	
    	switch(shooterPos){
    	case "top":
    		RobotMap.shootershooterAngleDrive.set(Constants.Setpoints.SHOOTER_TOP);
    		//RobotMap.intakeintakeDrive.set(RobotMap.shootershooterAngleDrive.getEncVelocity());
    		break;
    	case "hold":
    		RobotMap.shootershooterAngleDrive.set(Constants.Setpoints.SHOOTER_HOLD);
    		//RobotMap.intakeintakeDrive.set(RobotMap.shootershooterAngleDrive.getEncVelocity());
    		break;
    	case "down":
    		RobotMap.shootershooterAngleDrive.set(Constants.Setpoints.SHOOTER_DOWN);
    		//RobotMap.intakeintakeDrive.set(RobotMap.shootershooterAngleDrive.getEncVelocity());
    		break;
    	}
    	
    	switch(intakePos){
    	case "vertical":
    		//Timer.delay(2);
    		RobotMap.intakeintakeAngleDrive.set(Constants.Setpoints.INTAKE_VERTICAL);
    		break;
    	case "horizontal":
    		RobotMap.intakeintakeAngleDrive.enable();
    		RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    		RobotMap.intakeintakeAngleDrive.set(Constants.Setpoints.INTAKE_HORIZONTAL);
    		System.out.println("horizontal");
    		break;
    	case "lower":
    		RobotMap.intakeintakeAngleDrive.set(Constants.Setpoints.INTAKE_LOWER);
    		break;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Timer.delay(1);
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

