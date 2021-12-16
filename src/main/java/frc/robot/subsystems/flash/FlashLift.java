// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.flash;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlashLift extends SubsystemBase {
    final PWMTalonSRX lift1 = new PWMTalonSRX(8);
    final PWMTalonSRX lift2 = new PWMTalonSRX(9);

    public FlashLift() {}

    @Override
    public void periodic() {}

    public void setPower(double power) {
        lift1.set(power);
        lift2.set(power);
    }

    public void stop() {
        setPower(0);
    }
    
}
