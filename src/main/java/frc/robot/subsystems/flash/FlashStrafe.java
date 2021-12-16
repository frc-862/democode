// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.flash;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlashStrafe extends SubsystemBase {
    final PWMTalonSRX front1 = new PWMTalonSRX(4);
    final PWMTalonSRX front2 = new PWMTalonSRX(5);
    final PWMTalonSRX rear1 = new PWMTalonSRX(6);
    final PWMTalonSRX rear2 = new PWMTalonSRX(7);

    public FlashStrafe() {
        //TODO: get flash strafe directions
    }

    @Override
    public void periodic() {}

    public void setPower(double rearPower, double frontPower) {
        rear1.set(rearPower);
        rear2.set(rearPower);
        front1.set(frontPower);
        front2.set(frontPower);
    }

    public void stop() {
        setPower(0, 0);
    }
    
}
