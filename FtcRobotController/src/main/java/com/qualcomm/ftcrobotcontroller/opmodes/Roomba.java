package com.qualcomm.ftcrobotcontroller.opmodes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;



/**
 * Created by Ak Man and ethan on 1/30/16.
 */
public class Roomba extends OpMode {
    Servo leftKnock;                                          //Knockers
    Servo rightKnock;

    DcMotor string;                                             //things
    DcMotor tape;//measure

    DcMotor rightDrive;                                         //drive
    DcMotor leftDrive;

    Double creep;
    Double time;

    TouchSensor touch;
    ElapsedTime timer;

    public void init() {
        leftKnock = hardwareMap.servo.get("leftKnock");
        rightKnock = hardwareMap.servo.get("rightKnock");
        string = hardwareMap.dcMotor.get("string");
        tape = hardwareMap.dcMotor.get("tape");
        leftDrive = hardwareMap.dcMotor.get("leftDrive");
        rightDrive = hardwareMap.dcMotor.get("rightDrive");
        touch = hardwareMap.touchSensor.get("touch");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);      // sets leftDrive the same direction for right
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        creep = 0.5;
        timer.reset();
    }

    public void loop() {

        while (!touch.isPressed()) {                            //forwards
            leftDrive.setPower(0.5);
            rightDrive.setPower(0.5);
        }

        time = timer.time() / 2;
        timer.reset();

        while (timer.time() < time) {                           //back up
            leftDrive.setPower(-0.5);
            rightDrive.setPower(-0.5);
        }

        timer.reset();
        while (timer.time() < 0.1) {                            //turn
            leftDrive.setPower(0.5);
            rightDrive.setPower(-0.5);
        }
    }
}