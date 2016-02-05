package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by ethan on 2/4/15
 * tweaked by ak man
 */

// knockers, string, tape (measure)

public class VanillaTank extends OpMode {

    DcMotor rightDrive;                                       //drive
    DcMotor leftDrive;
    Double creep;


//  Double turnPower;                                         //arcade drive
//  Double forwardPower;

    public void init() {
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        leftDrive.setDirection(DcMotor.Direction.REVERSE);    // sets leftDrive the same direction for right
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        creep = 0.5;
    }


    public void loop() {

        if (gamepad1.right_stick_button) {                    //creep left
            if (creep == 0.5) {
                creep = 0.175;
            }
            else {
                creep = 0.5;
            }
        }
        if (gamepad1.left_stick_button) {                     //creep right
            if (creep == 0.5) {
                creep = 0.25;
            }
            else {
                creep = 0.5;
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
        leftDrive.setPower(gamepad1.left_stick_y * creep);    //tank drive
        rightDrive.setPower(gamepad1.right_stick_y * creep);

        //
    }
}