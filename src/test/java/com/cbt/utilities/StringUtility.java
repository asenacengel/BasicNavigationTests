package com.cbt.utilities;

public class StringUtility {

    public static String verifyEquals(String expected,String result){
        if(expected.equalsIgnoreCase(result)){
            return "PASS";
        }else {
            return "FAIL";
        }
    }
}
