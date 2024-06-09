package com.test.springboot.utils;

public class PageUtil {
    public static int getStartPage(int page, int limit){
        return (page - 1) * limit;
    }
}
