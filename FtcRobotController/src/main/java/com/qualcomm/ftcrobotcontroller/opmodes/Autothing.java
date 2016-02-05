package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
<<<<<<< HEAD
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
=======
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by ethan on 11/30/15
 * tweaked by ak man
 */

// knockers, string, tape (measure)

public class Comp extends OpMode {

    Servo leftKnock;                                          //Knockers
    Servo rightKnock;

    DcMotor string;                                             //things
    DcMotor tape;//measure

    DcMotor rightDrive;                                         //drive
    DcMotor leftDrive;
    Double creep;

//  Double turnPower;                                         //arcade drive
//  Double forwardPower;

    public void init() {
        leftKnock = hardwareMap.servo.get("leftKnock");
        rightKnock = hardwareMap.servo.get("rightKnock");
        string = hardwareMap.dcMotor.get("string");
        tape = hardwareMap.dcMotor.get("tape");
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);      // sets leftDrive the same direction for right
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        creep = 0.5;

    }


    public void loop() {
        if (gamepad1.left_bumper) {                            //knocking things
            leftKnock.setPosition(0.5);
        }
        else if (gamepad1.left_trigger >= 0.5) {
            leftKnock.setPosition(1.0);
        }

        if (gamepad1.right_bumper) {                            //knocking things
            rightKnock.setPosition(0.5);
        }
        else if (gamepad1.right_trigger >= 0.5) {
            rightKnock.setPosition(1.0);
        }

        string.setPower(gamepad2.right_stick_y);                //climby stuff
        tape.setPower(gamepad2.left_stick_y);

        /*
        if (gamepad2.y) {
            if (intakeOn) {
                intakeOn = false;
            }
            else {
                intakeOn = true;
            }
        }
        if (intakeOn) {
            intake.setPower(1.0);
        }
        else {
            intake.setPower(0.0);
        }
        */
        //
        if (gamepad1.right_stick_button) {                             //creep left
            if (creep == 0.5) {
                creep = 0.175;
            }
            else {
                creep = 0.5;
            }
        }
        if (gamepad1.left_stick_button) {                            //creep right
            if (creep == 0.5) {
                creep = 0.25;
            }
            else {
                creep = 0.5;
            }
        }
        /*
        turnPower = -creep * gamepad1.right_stick_x;                  //arcade drive
        forwardPower = creep * gamepad1.left_stick_y;
        if (gamepad1.left_stick_y == 0) {
            leftDrive.setPower((turnPower * -2));
            rightDrive.setPower((turnPower * 2));
        }
        else {
            leftDrive.setPower(forwardPower + turnPower);
            rightDrive.setPower(forwardPower - turnPower);
        }
        */
        leftDrive.setPower(gamepad1.left_stick_y * creep);      //tank drive
	    rightDrive.setPower(gamepad2.right_stick_y*creep);

        //
    }
}
>>>>>>> 58ab35c9efae056202093ea67b34eb99c7fbd302