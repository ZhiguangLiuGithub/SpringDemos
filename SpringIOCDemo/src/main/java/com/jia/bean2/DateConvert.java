package com.jia.bean2;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        System.out.println("text value=" + text);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setValue(date);
    }
}

