package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Ak Man on 1/28/16.
 * tweaked by ethan
 */
public class Autothing extends OpMode {
    DcMotor rightDrive;                                         //drive
    DcMotor leftDrive;
    ElapsedTime timer;

    Double forwardTime;
    Double turnTime;
    Double climbTime;


    public void init() {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        timer.reset();
        leftDrive.setDirection(DcMotor.Direction.REVERSE);      // sets leftDrive the same direction for right
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        forwardTime = 0.0;
        turnTime = 91.0;
        climbTime = 0.0;

    }

    public void loop() {

        while (timer.time() <= forwardTime) {
            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
        }
        timer.reset();

        while (timer.time() <= turnTime) {
            leftDrive.setPower(1.0);
            rightDrive.setPower(-1.0);
        }
        timer.reset();

        while (timer.time() <= climbTime) {
            leftDrive.setPower(1.0);
            rightDrive.setPower(1.0);
        }
        while (true) {
            leftDrive.setPower(0.0);
            rightDrive.setPower(0.0);
        }
    }
}