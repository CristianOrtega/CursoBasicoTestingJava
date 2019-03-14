package com.platzi.javatest.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static String repeat(String str, int times){
        String result = "";
        if(times < 0){
            throw new IllegalArgumentException("negative times not allowed");
        }
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }

    public static boolean isEmpty(String str){
        return str == null ? true : StringUtils.isEmpty(str.trim());
    }
}
