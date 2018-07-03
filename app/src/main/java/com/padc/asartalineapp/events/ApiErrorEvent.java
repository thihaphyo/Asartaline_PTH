package com.padc.asartalineapp.events;

/**
 * Created by Phyo Thiha on 7/3/18.
 */
public class ApiErrorEvent {

    private String errMessage;

    public ApiErrorEvent(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
