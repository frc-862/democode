// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.eddie;

import com.lightningrobotics.common.subsystem.drivetrain.differential.DifferentialDrivetrain;
import com.lightningrobotics.common.subsystem.drivetrain.differential.DifferentialGains;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

public class EddieDrivetrain extends DifferentialDrivetrain {
    public EddieDrivetrain(DifferentialGains gains) {
        super(
            gains,
            new SpeedController[]{
                new Victor(3),
                new Victor(1)
            }, 
            new SpeedController[]{
                new Victor(2),
                new Victor(4)
            }
        );
        initMotorDirections();
    }

    public void initMotorDirections() {
        withEachRightMotor(m -> m.setInverted(true));
    }

}
