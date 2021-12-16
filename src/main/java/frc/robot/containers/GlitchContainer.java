// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.containers;

import com.lightningrobotics.common.LightningContainer;
import com.lightningrobotics.common.subsystem.drivetrain.LightningDrivetrain;
import com.lightningrobotics.common.subsystem.drivetrain.differential.DifferentialGains;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.TankDrive;
import frc.robot.commands.glitch.*;
import frc.robot.subsystems.glitch.*;


public class GlitchContainer extends LightningContainer {

    private static final GlitchDrivetrain drivetrain = new GlitchDrivetrain(new DifferentialGains());

    private static final Elevator elevator = new Elevator();
    private static final FourBar fourBar = new FourBar();
    private static final Grippers grippers = new Grippers();

    private static final Joystick driverLeft = new Joystick(0);
    private static final Joystick driverRight = new Joystick(1);

    private static final Joystick operator = new Joystick(2);

    @Override
    protected void configureButtonBindings() {
        //All button bindings are on OPERATOR controller
        //Right bumper to collect cubes
        (new JoystickButton(operator, 6)).whileHeld(new GripperControl(grippers, () -> 1));

        //Left bumper to eject cubes
        (new JoystickButton(operator, 5)).whileHeld(new GripperControl(grippers, () -> -1));
    }

    @Override
    protected void configureDefaultCommands() {
        //Standard Tank Drive Controls
        drivetrain.setDefaultCommand(new TankDrive(drivetrain, () -> driverLeft.getY(), () -> driverRight.getY()));

        //Left Stick to move elevator
        elevator.setDefaultCommand(new ElevatorControl(elevator, () -> operator.getY(Hand.kLeft)));

        //Right Stick to move four bar
        fourBar.setDefaultCommand(new FourBarControl(fourBar, () -> operator.getY(Hand.kRight)));
    }

    @Override
    public LightningDrivetrain getDrivetrain() { return drivetrain; }

    @Override
    protected void configureAutonomousCommands() {};

    @Override
    protected void configureSystemTests() {};

    @Override
    protected void initializeDashboardCommands() {};

    @Override
    protected void releaseDefaultCommands() {}

    @Override
    protected void configureAutonomousPaths() {}

    @Override
    protected void configureFaultCodes() {}

    @Override
    protected void configureFaultMonitors() {};

}
