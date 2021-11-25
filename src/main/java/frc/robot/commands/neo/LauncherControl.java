// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.neo;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.neo.Launcher;

public class LauncherControl extends CommandBase {
    DoubleSupplier power;
    Launcher launcher;

    public LauncherControl(Launcher launcher, DoubleSupplier power) {
        addRequirements(launcher);
        this.launcher = launcher;
        this.power = power;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        launcher.setPower(power.getAsDouble());
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {}

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        launcher.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
