package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Ak Man on 1/28/16.
 * tweaked by ethan
 */
public class BlueAuto extends LinearOpMode {
    DcMotor rightDrive;                                         //drive
    DcMotor leftDrive;

    Servo rightKnock;

    double forwardTime;
    double turnTime;
    double climbTime;
    double knockTime;
    double reverseTime;
    double finishTime;

    public void runOpMode() throws InterruptedException {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        rightKnock = hardwareMap.servo.get("rightKnock");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);      // sets leftDrive the same direction for right
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        forwardTime = 3350.0;
        turnTime = 910.0;
        climbTime = 5000.0;
        knockTime = 1000.0;
        reverseTime = 1000.0;
        finishTime = 2000.0;

        waitForStart();

        leftDrive.setPower(1.0);                                //forwards
        rightDrive.setPower(1.0);
        Thread.sleep((long) forwardTime);

        leftDrive.setPower(-1.0);                               //turn
        rightDrive.setPower(1.0);
        Thread.sleep((long) turnTime);

        rightKnock.setPosition(0.5);                             //extend knocker
        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
        Thread.sleep((long) knockTime);

        leftDrive.setPower(1.0);                                //climb
        rightDrive.setPower(1.0);
        Thread.sleep((long) climbTime);
        rightKnock.setPosition(0.0);
        Thread.sleep((long) knockTime);

        leftDrive.setPower(-1.0);                               //back up
        rightDrive.setPower(-1.0);
        Thread.sleep((long) reverseTime);

        leftDrive.setPower(1.0);                               //turn again
        rightDrive.setPower(-1.0);
        Thread.sleep((long) turnTime);

        leftDrive.setPower(1.0);                                //get in zone
        rightDrive.setPower(1.0);
        Thread.sleep((long) finishTime);

        leftDrive.setPower(0.0);                                //stop
        rightDrive.setPower(0.0);
    }
}