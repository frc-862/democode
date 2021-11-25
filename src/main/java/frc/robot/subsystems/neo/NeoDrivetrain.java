// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.neo;

import edu.wpi.first.wpilibj.Victor;
import frc.robot.subsystems.VictorDrivetrain;

public class NeoDrivetrain extends VictorDrivetrain {
    public NeoDrivetrain() {
        //TODO: get real pwm ports for neo
        super(
            new Victor[]{
                new Victor(1),
                new Victor(2)
            }, 
            new Victor[]{
                new Victor(3),
                new Victor(4)
            }
        );
    }

    @Override
    public void initMotorDirections() {
        //TODO: get real motor directions for neo
        for (Victor m : getRightMotors()) {m.setInverted(true);}
    }
}
