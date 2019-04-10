package com.fengsri.restaurant.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author fengwen
 * @date 2019/4/9 17:21
 */
public class OrderUtil {
    public static String getOrderId(){
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        return year+month+date+hour+minute+second+"";
    }
}
