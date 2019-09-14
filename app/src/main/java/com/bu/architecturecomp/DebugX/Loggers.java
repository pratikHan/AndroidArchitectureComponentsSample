package com.bu.architecturecomp.DebugX;

import android.util.Log;

public class Loggers {

    private final static String TAG = "Loggers";
    public static String class_name;
    public static String function_name;
    public static String message;

    public static void show(String c_name, String f_name, String msg){

        class_name = c_name;
        function_name = f_name;
        message = msg;

        Log.d(TAG,class_name+" :"+ function_name +" ::"+message);

    }
}
