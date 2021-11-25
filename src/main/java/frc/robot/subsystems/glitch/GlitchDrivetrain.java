// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.glitch;

import java.util.function.Supplier;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.geometry.Rotation2d;
import frc.lightning.LightningConfig;
import frc.lightning.subsystems.CTREDrivetrain;
import frc.lightning.subsystems.IMU.IMUFunction;

public class GlitchDrivetrain extends CTREDrivetrain {

    public GlitchDrivetrain(LightningConfig config, Supplier<Rotation2d> heading, IMUFunction zeroHeading) {
        super(
            config, 
            new TalonSRX(1), 
            new TalonSRX(4), 
            new VictorSPX[]{
                new VictorSPX(2), 
                new VictorSPX(3)
            },
            new VictorSPX[]{
                new VictorSPX(5), 
                new VictorSPX(6)
            }, heading, zeroHeading
        );
        initMotorDirections();
    }

    @Override
    public void initMotorDirections() {
        getLeftMotors()[0].setInverted(true);
        getRightMaster().setInverted(true);
        getRightMotors()[1].setInverted(true);
    }

}