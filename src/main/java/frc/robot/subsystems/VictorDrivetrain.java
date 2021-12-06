// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Victor;

import com.lightningrobotics.common.geometry.kinematics.DrivetrainSpeed;
import com.lightningrobotics.common.subsystem.drivetrain.*;
import com.lightningrobotics.common.util.LightningMath;


public class VictorDrivetrain extends LightningDrivetrain {

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


	public void setPower(double left, double right) {
        for (Victor m : leftMotors) {
            m.set(left);
        }

        for (Victor m : rightMotors) {
            m.set(right);
        }
	}

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

	public void setOutput(double leftVolts, double rightVolts) {
        for (Victor m : leftMotors) {
		    m.setVoltage(leftVolts);
        }

        for (Victor m : rightMotors) {
		    m.setVoltage(rightVolts);
        }
	}

    public void tankDrive(double leftSpeed, double rightSpeed) {
        leftSpeed = LightningMath.constrain(leftSpeed, -1.0, 1.0);
        rightSpeed = LightningMath.constrain(rightSpeed, -1.0, 1.0);
        setOutput(leftSpeed, rightSpeed);
    }

	public double getRightVolts() {
        double totalOutput = 0d;
		for (Victor m : rightMotors) {
            totalOutput += m.getSpeed() * RobotController.getBatteryVoltage();
        }

        return totalOutput / rightMotors.length;
	}

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
    public void configureMotors() {}

    @Override
    public LightningGains getGains() {
        return null;
    }

    @Override
    public void setDriveSpeed(DrivetrainSpeed arg0) {}

    @Override
    public void stop() {
        tankDrive(0.0, 0.0);
    }

}
