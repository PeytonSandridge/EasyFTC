package com.lcrobotics.easyftclib.commandCenter.controllers;

public class PDController extends PIDController {
    /**
     * Default constructor with just the coefficients
     */
    public PDController(double kp, double kd){
        super(kp, 0, kd);
    }

    /**
     * The extended constructor.
     */
    public PDController(double kp, double kd, double sp, double pv) {
        super(kp, 0, kd, sp, pv);
    }
}
