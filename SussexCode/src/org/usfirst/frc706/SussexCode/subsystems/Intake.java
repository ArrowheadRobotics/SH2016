package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	public int simPos;
    public final CANTalon intakeDrive = RobotMap.intakeintakeDrive;
    public final CANTalon intakeAngleDrive = RobotMap.intakeintakeAngleDrive;
    public final double P = Constants.Intake.P_INTAKE;
    public final double I = Constants.Intake.I_INTAKE;
    public final double D = Constants.Intake.D_INTAKE;
    
    public Intake(){
    	//DO NOT REVERSE OUTPUT
    	System.out.println("Init PID");
    	intakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	intakeAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	intakeAngleDrive.setPID(P, I, D);
    	simPos = 0;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SetIntakePos());
    }
}

