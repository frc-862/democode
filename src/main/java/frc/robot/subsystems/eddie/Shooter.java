// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.eddie;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    public final Victor shooterMotor;

    public Shooter() {
        shooterMotor = new Victor(6);
    }

    @Override
    public void periodic() {}

    public void setPower(double power) {
        shooterMotor.set(power);
    }

    public void stop() {
        setPower(0);
    }
    
}
