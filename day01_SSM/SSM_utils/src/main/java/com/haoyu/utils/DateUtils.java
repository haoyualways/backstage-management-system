package com.haoyu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：日期转换
 * @create: 2020-12-10 22:16
 **/
public class DateUtils {

    //日期转换成字符串
    public static String date2String(Date date,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }

    //字符串转换成日期格式
    public static Date string2date(String str,String patt) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date format = simpleDateFormat.parse(str);
        return format;
    }
}
