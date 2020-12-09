package org.firstinspires.ftc.teamcode;

import com.lcrobotics.easyftclib.commandCenter.driveTrain.DriveTrain;
import com.lcrobotics.easyftclib.commandCenter.driveTrain.WheelType;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

public abstract class SuperOp extends OpMode {

    public DcMotor FrontLeftDrive = null;
    public DcMotor FrontRightDrive = null;
    public DcMotor BackLeftDrive = null;
    public DcMotor BackRightDrive = null;

    public DriveTrain wheels = null;

    public enum AUTOSTATUS {START, MOVETOZONE, DROPGOAL, MOVEFROMZONE, SHOOTRINGS, PARK, STOP}

    @Override
    public void init() {

        FrontLeftDrive = hardwareMap.get(DcMotor.class, "FrontLeftDrive");
        FrontRightDrive = hardwareMap.get(DcMotor.class, "FrontRightDrive");
        BackLeftDrive = hardwareMap.get(DcMotor.class, "BackLeftDrive");
        BackRightDrive = hardwareMap.get(DcMotor.class, "BackRightDrive");

        FrontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        FrontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        BackLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        BackRightDrive.setDirection(DcMotor.Direction.REVERSE);

        wheels = new DriveTrain(WheelType.MECANUM, FrontLeftDrive, FrontRightDrive, BackLeftDrive, BackRightDrive);
    }
    double getBatteryVoltage() {
        double result = Double.POSITIVE_INFINITY;
        for (VoltageSensor sensor : hardwareMap.voltageSensor) {
            double voltage = sensor.getVoltage();
            if (voltage > 0) {
                result = Math.min(result, voltage);
            }
        }
        return result;
    }
}
