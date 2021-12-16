// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.flash;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.can.*;
import com.lightningrobotics.common.subsystem.drivetrain.differential.*;

import edu.wpi.first.wpilibj.SpeedController;

public class FlashDrivetrain extends DifferentialDrivetrain {

    public FlashDrivetrain(DifferentialGains gains) {
        super(
            gains,
            new SpeedController[]{
                new WPI_TalonSRX(0),
                new WPI_TalonSRX(1), 
            },
            new SpeedController[]{
                new WPI_TalonSRX(2), 
                new WPI_TalonSRX(3), 
            }
        );
        initMotorDirections();
    }

    public void initMotorDirections() {
        //TODO: find flash inverted motors
    }

}