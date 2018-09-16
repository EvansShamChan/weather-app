package com.esc.weatherapp.converter;

import java.sql.Date;

public class StringToSqlDateConverter {
    public static Date getSqlDate(String s) {
        java.util.Date date = new java.util.Date(s.replace("-", "/"));
        System.out.println(date);
        return new Date(date.getTime());
    }
}
