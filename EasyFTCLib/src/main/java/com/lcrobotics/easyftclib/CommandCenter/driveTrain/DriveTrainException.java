package com.lcrobotics.easyftclib.CommandCenter.driveTrain;

/**
 * DriveTrain exception, thrown if there's an error
 */
public class DriveTrainException extends Exception {
    public DriveTrainException(String errorMessage){
        super(errorMessage);
    }
}
