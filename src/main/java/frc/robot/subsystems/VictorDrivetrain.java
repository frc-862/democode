// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lightning.subsystems.LightningDrivetrain;
import frc.lightning.util.RamseteGains;

public class VictorDrivetrain extends SubsystemBase implements LightningDrivetrain {

    private Victor[] leftMotors;
    private Victor[] rightMotors;
    
    /** Creates a new Drivetrain. */
    public VictorDrivetrain(Victor[] leftMotors, Victor[] rightMotors) {
        this.leftMotors = leftMotors;
        this.rightMotors = rightMotors;
    }

    @Override
    public void periodic() { super.periodic(); }

    protected void withEachMotor(Consumer<Victor> op) {
		for (var m : leftMotors)
			op.accept(m);
		for (var m : rightMotors)
			op.accept(m);
	}

    protected void withEachMotorIndexed(BiConsumer<Victor, Integer> op) {
		for (var i = 0; i < leftMotors.length; ++i) {
			op.accept(leftMotors[i], i);
		}
		for (var i = 0; i < rightMotors.length; ++i) {
			op.accept(rightMotors[i], i);
		}
	}

    protected void withEachLeftMotor(Consumer<Victor> op) {
		for(var m : leftMotors) op.accept(m);
	}

	protected void withEachRightMotor(Consumer<Victor> op) {
		for(var m : rightMotors) op.accept(m);
	}

    @Override
	public void initMotorDirections() {}

    @Override
	public void setPower(double left, double right) {
        for (Victor m : leftMotors) {
            m.set(left);
        }

        for (Victor m : rightMotors) {
            m.set(right);
        }
	}

    @Override
	public void setVelocity(double left, double right) {}

    public Victor[] getLeftMotors() {
		return leftMotors;
	}

	public Victor[] getRightMotors() {
		return rightMotors;
	}

    public Victor getMotorByPWMID(int id) {
		for(var m : getLeftMotors()) if(m.getChannel() == id) return m;
		for(var m : getRightMotors()) if(m.getChannel() == id) return m;
		return null;
	}

    @Override
	public void setOutput(double leftVolts, double rightVolts) {
        for (Victor m : leftMotors) {
		    m.setVoltage(leftVolts);
        }

        for (Victor m : rightMotors) {
		    m.setVoltage(rightVolts);
        }
	}

    @Override
	public double getRightVolts() {
        double totalOutput = 0d;
		for (Victor m : rightMotors) {
            totalOutput += m.getSpeed() * RobotController.getBatteryVoltage();
        }

        return totalOutput / rightMotors.length;
	}

	@Override
	public double getLeftVolts() {
		double totalOutput = 0d;
		for (Victor m : leftMotors) {
            totalOutput += m.getSpeed() * RobotController.getBatteryVoltage();
        }

        return totalOutput / leftMotors.length;
	}

    //The rest is empty, partially because old victors don't support some of the features,
    //But mostly because I'm too lazy to implement workarounds

    @Override
    public void brake() {}

    @Override
    public void coast() {}

    @Override
    public RamseteGains getConstants() { return null; }

    @Override
    public DifferentialDriveKinematics getKinematics() { return null; }

    @Override
    public double getLeftDistance() { return 0; }

    @Override
    public PIDController getLeftPidController() { return null; }

    @Override
    public double getLeftTemp() { return 0; }

    @Override
    public double getLeftVelocity() { return 0; }

    @Override
    public Pose2d getPose() { return null; }

    @Override
    public Pose2d getRelativePose() { return null; }

    @Override
    public double getRightDistance() { return 0; }

    @Override
    public PIDController getRightPidController() { return null; }

    @Override
    public double getRightTemp() { return 0; }

    @Override
    public double getRightVelocity() { return 0; }

    @Override
    public DifferentialDriveWheelSpeeds getSpeeds() { return null; }

    @Override
    public void resetDistance() {}

    @Override
    public void resetSensorVals() {}

    @Override
    public void setRamseteOutput(double arg0, double arg1) {}

    @Override
    public void setRelativePose() {}

}
