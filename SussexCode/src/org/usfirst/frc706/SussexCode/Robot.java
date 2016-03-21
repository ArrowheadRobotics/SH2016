// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc706.SussexCode;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.NamedSendable;

import org.usfirst.frc706.SussexCode.commands.*;
import org.usfirst.frc706.SussexCode.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static SendableChooser def;
	public static SendableChooser rpos;
	public static SendableChooser dpos;

    Command autonomousCommand;
    Command AutonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Chassis chassis;
    public static Intake intake;
    public static Shooter shooter;
    public static AHRS nav;
    public static CameraServer server;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public Robot() {
    	server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
        
    }
    
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        chassis = new Chassis();
        intake = new Intake();
        shooter = new Shooter();
        nav = new AHRS(SerialPort.Port.kMXP);
        
        
        rpos = new SendableChooser();
        dpos = new SendableChooser();
        def = new SendableChooser();
        
        dpos.addObject("Defense one", 0);
        dpos.addObject("Defense two", 1);
        dpos.addObject("Defense three", 2);
        dpos.addObject("Defense four", 3);
        dpos.addObject("Defense five", 4);
        
        rpos.addObject("Robot one", 0);
        rpos.addObject("Robot two", 1);
        rpos.addObject("Robot three", 2);
        rpos.addObject("Robot four", 3);
        rpos.addObject("Robot five", 4);
        
        def.addObject("Portcullis", new AutonomousPortcullis());
        def.addObject("Cheval de Frise", new AutonomousCheval());
        def.addObject("Moat", new AutonomousMoat());
        def.addObject("Ramparts", new AutonomousRamparts());
        def.addObject("DrawBridge", new AutonomousDrawBridge());
        def.addObject("Sally Port", new AutonomousSallyPort());
        def.addObject("Rock Wall", new AutonomousRockWall());
        def.addObject("Rough Terrain", new AutonomousRoughTerrain());
        def.addObject("Low Bar", new AutonomousLowBar());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        //autonomousCommand = new AutonomousCommand();
        //AutonomousCommand = new AutonomousCommand();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        RobotMap.shooterTriggerSol.set(DoubleSolenoid.Value.kForward);
        RobotMap.shooterOneSol.set(DoubleSolenoid.Value.kForward);
        RobotMap.shooterTwoSol.set(DoubleSolenoid.Value.kForward);
        
        SmartDashboard.putData("Defense", def);
    }
   


    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	
        //if (autonomousCommand != null) autonomousCommand.start();
    	AutonomousCommand = (Command) Robot.def.getSelected();
    	if (AutonomousCommand != null) AutonomousCommand.start();
    	Robot.intake.tele = false;
    	Robot.chassis.tele = false;
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        
    	//if (autonomousCommand != null) autonomousCommand.cancel();
    	AutonomousCommand = (Command) def.getSelected();
    	if (AutonomousCommand != null) AutonomousCommand.cancel();
    	Robot.intake.tele = true;
    	Robot.chassis.tele = true;
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	//System.out.println(nav.getYaw());
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
