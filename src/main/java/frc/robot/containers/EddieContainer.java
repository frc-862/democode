// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.containers;

import com.lightningrobotics.common.LightningContainer;
import com.lightningrobotics.common.subsystem.drivetrain.LightningDrivetrain;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.eddie.*;
import frc.robot.commands.VictorTankDrive;
import frc.robot.commands.eddie.*;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class EddieContainer extends LightningContainer {

    private final EddieDrivetrain drivetrain = new EddieDrivetrain();
    private final Shooter shooter = new Shooter();
    private final Indexer indexer = new Indexer();

    public final Joystick driverLeft = new Joystick(0);
    public final Joystick driverRight = new Joystick(1);

    @Override
    protected void configureButtonBindings() {
        //Right flight stick trigger to spin shooter
        (new JoystickButton(driverRight, 1)).whileHeld(new ShooterControl(shooter, () -> 1));
        //Left flight stick trigger to run indexer
        (new JoystickButton(driverLeft, 1)).whileHeld(new IndexerControl(indexer, () -> 1));
    }

    @Override
    protected void configureAutonomousCommands() {}

    @Override
    protected void configureDefaultCommands() {
        //Standard tank drive bindings
        drivetrain.setDefaultCommand(new VictorTankDrive(drivetrain, () -> -driverRight.getY(), () -> -driverLeft.getY()));
    }

    @Override
    protected void configureSystemTests() {}

    @Override
    protected void initializeDashboardCommands() {}

    @Override
    protected void releaseDefaultCommands() {}

    @Override
    protected void configureAutonomousPaths() {}

    @Override
    protected void configureFaultCodes() {}

    @Override
    protected void configureFaultMonitors() {}

    @Override
    public LightningDrivetrain getDrivetrain() {
        return drivetrain;
    }
}
