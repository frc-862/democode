// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.containers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.lightning.LightningConfig;
import frc.lightning.LightningContainer;
import frc.lightning.commands.VoltDrive;
import frc.lightning.subsystems.LightningDrivetrain;
import frc.robot.subsystems.neo.*;
import frc.robot.commands.neo.*;



public class NeoContainer extends LightningContainer {

    private static final NeoDrivetrain drivetrain = new NeoDrivetrain();

    private static final Launcher launcher = new Launcher();
    private static final Collector collector = new Collector();

    private static final Joystick driverLeft = new Joystick(0);
    private static final Joystick driverRight = new Joystick(1);

    private static final XboxController operator = new XboxController(2);

    @Override
    protected void configureButtonBindings() {
        //Right flight stick trigger to run launcher
        (new JoystickButton(driverRight, 1)).whileHeld(new LauncherControl(launcher, () -> 1));
    }

    @Override
    protected void configureDefaultCommands() {
        //Standard Tank Drive Controls
        drivetrain.setDefaultCommand(new VoltDrive(drivetrain, () -> driverLeft.getY(), () -> driverRight.getY()));

        //Control Collector with right xbox trigger
        collector.setDefaultCommand(
            new CollectorControl(
                collector, 
                () -> (operator.getTriggerAxis(GenericHID.Hand.kRight)-operator.getTriggerAxis(GenericHID.Hand.kLeft))
            )
        );
    }

    @Override
    public LightningDrivetrain getDrivetrain() { return drivetrain; }

    @Override
    public LightningConfig getConfig() { return null; }

    @Override
    protected void configureAutonomousCommands() {};

    @Override
    protected void configureSystemTests() {};

    @Override
    protected void initializeDashboardCommands() {};

    @Override
    protected void releaseDefaultCommands() {};
}
