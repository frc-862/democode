// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.eddie;

import edu.wpi.first.wpilibj.Victor;
import frc.robot.subsystems.VictorDrivetrain;

public class EddieDrivetrain extends VictorDrivetrain {
    public EddieDrivetrain() {
        super(
            new Victor[]{
                new Victor(3),
                new Victor(1)
            }, 
            new Victor[]{
                new Victor(2),
                new Victor(4)
            }
        );
        initMotorDirections();
    }

    public void initMotorDirections() {
        for (Victor m : getRightMotors()) {m.setInverted(true);}
    }
}
