package com.test.springboot.utils;

/**
 * ClassName: verifyUtil
 * Description:
 * @since JDK 1.8
 */
public class VerifyUtil {

    public static boolean isNull(Object param){
        if (param == null || "".equals(param)){
            return true;
        }
        return false;
    }

    public static boolean isNotNull(Object param){
        if (param != null && !"".equals(param)){
            return true;
        }
        return false;
    }

    public static boolean isNull(String param){
        if (param == null || "".equals(param)){
            return true;
        }
        return false;
    }

    public static boolean isNotNull(String param){
        if (param != null && !"".equals(param)){
            return true;
        }
        return false;
    }

    public static boolean isNull(Long param){
        if (param == null){
            return true;
        }
        return false;
    }

    public static boolean isNotNull(Long param){
        if (param != null){
            return true;
        }
        return false;
    }

}
