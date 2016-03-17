package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by ethan on 3/17/16
 * tweaked by ak man
 */

// knockers, string, tape (measure)

public class RaceCar extends OpMode {

    DcMotor drive;                                             //drive
    DcMotor turn;
    Double creep;


//  Double turnPower;                                         //arcade drive
//  Double forwardPower;

    public void init() {
        drive = hardwareMap.dcMotor.get("drive");
        turn = hardwareMap.dcMotor.get("turn");
        creep = 1.0;
    }


    public void loop() {

        if (gamepad1.right_stick_button) {                    //creep left
            if (creep == 1.0) {
                creep = 0.5;
            }
            else {
                creep = 1.0;
            }
        }
        if (gamepad1.left_stick_button) {                     //creep right
            if (creep == 1.0) {
                creep = 0.25;
            }
            else {
                creep = 1.0;
            }
        }
        /*
        turnPower = -creep * gamepad1.right_stick_x;          //arcade drive
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
        drive.setPower(gamepad1.left_stick_y * creep);    //tank drive
        turn.setPower(gamepad1.right_stick_x / 10);

        //
    }
}