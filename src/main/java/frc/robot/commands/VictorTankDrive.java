package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VictorDrivetrain;

import java.util.function.DoubleSupplier;

import com.lightningrobotics.common.util.filter.JoystickFilter;

public class VictorTankDrive extends CommandBase {
    private final VictorDrivetrain drivetrain;
    private final DoubleSupplier leftThrottle;
    private final DoubleSupplier rightThrottle;
    private double deadband = 0.1;
    private double minPower = 0.1;
    private double maxPower = 1.0;
    private final JoystickFilter filter = new JoystickFilter(deadband, minPower, maxPower, JoystickFilter.Mode.CUBED);

    public VictorTankDrive(VictorDrivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
        this.drivetrain = drivetrain;
        this.leftThrottle = left;
        this.rightThrottle = right;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        final double targetLeft = filter.filter(leftThrottle.getAsDouble());
        final double targetRight = filter.filter(rightThrottle.getAsDouble());

        drivetrain.tankDrive(targetLeft, targetRight);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }

}
