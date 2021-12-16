// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.glitch;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.can.*;
import com.lightningrobotics.common.subsystem.drivetrain.differential.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

public class GlitchDrivetrain extends DifferentialDrivetrain {

    final static SpeedController[] leftMotors = new SpeedController[]{
        new WPI_TalonSRX(1),
        new WPI_VictorSPX(2), 
        new WPI_VictorSPX(3)
    };

    final static SpeedController[] rightMotors = new SpeedController[]{
        new WPI_TalonSRX(4), 
        new WPI_VictorSPX(5), 
        new WPI_VictorSPX(6)
    };

    public GlitchDrivetrain(DifferentialGains gains) {
        super(
            gains,
            leftMotors,
            rightMotors
        );
        initMotorDirections();
    }

    public void initMotorDirections() {
        leftMotors[0].setInverted(true);
        rightMotors[0].setInverted(true);
        rightMotors[1].setInverted(true);
    }

}