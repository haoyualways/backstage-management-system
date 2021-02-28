package com.haoyu.utils;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import java.text.ParseException;
import java.util.Date;

/**
 * @program: day01_SSM
 * @author: haoyualways.top
 * @description：
 * @create: 2020-12-18 22:46
 **/
public class DateStringEditor extends PropertiesEditor {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Date date = DateUtils.string2date(text, "yyyy-MM-dd HH:mm");
            super.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
