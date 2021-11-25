// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.orion;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {

    private Victor shooter1;
    private Victor shooter2;

    public Shooter() {
        shooter1 = new Victor(5);
        shooter2 = new Victor(6);
    }

    @Override
    public void periodic() {}

    public void setPower(double power) {
        shooter1.set(power);
        shooter2.set(power);
    }

    public void stop() {
        setPower(0);
    }
    
}
