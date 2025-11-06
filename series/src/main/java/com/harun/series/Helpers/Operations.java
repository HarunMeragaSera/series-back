package com.harun.series.Helpers;

public class Operations {

    public static String trimBrackets(String message){
        if (message == null) {
            return null;
        }
        return message.replace("[", "").replace("]", "");
    }
}
