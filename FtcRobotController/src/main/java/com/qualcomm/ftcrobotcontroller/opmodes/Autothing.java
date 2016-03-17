package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Ak Man on 1/28/16.
 * tweaked by ethan
 */
public class Autothing extends LinearOpMode {
    DcMotor rightDrive;                                         //drive
    DcMotor leftDrive;

    double forwardTime;
    double turnTime;
    double climbTime;

    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);      // sets leftDrive the same direction for right
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        forwardTime = 3350.0;
        turnTime = 910.0;
        climbTime = 5000.0;

        waitForStart();

        leftDrive.setPower(1.0);
        rightDrive.setPower(1.0);
        Thread.sleep((long)forwardTime);

        leftDrive.setPower(1.0);
        rightDrive.setPower(-1.0);
        Thread.sleep((long)turnTime);

        leftDrive.setPower(1.0);
        rightDrive.setPower(1.0);
        Thread.sleep((long)climbTime);

        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
    }
}