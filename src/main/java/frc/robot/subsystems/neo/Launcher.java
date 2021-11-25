// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.neo;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {

    private Victor left1;
    private Victor left2;

    private Victor right1;
    private Victor right2;

    public Launcher() {
        //TODO: get real PWM ids for neo's launcher
        left1 = new Victor(5);
        left2 = new Victor(6);

        right1 = new Victor(7);
        right2 = new Victor(8);

        //TODO: get real motor directions for neo's launcher
        right1.setInverted(true);
        right2.setInverted(true);
    }

    @Override
    public void periodic() {}

    public void setPower(double power) {
        left1.set(power);
        left2.set(power);

        right1.set(power);
        right2.set(power);
    }

    public void extend() {
        //TODO: pneumatics on neo
    }

    public void retract() {}

    public void stop() {
        setPower(0);
    }
}
