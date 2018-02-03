package com.nan.date;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FindDates {

    public static void main(String[] args) throws Exception {

        /*Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2017); // 2010年
        cal.set(Calendar.MONTH, 10); // 6 月
        cal.set(Calendar.DAY_OF_MONTH, 26);
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));*/
        
        BigDecimal f = new BigDecimal("19374.00");
        System.out.println(f.compareTo(BigDecimal.ZERO));
        System.out.println(f.compareTo(BigDecimal.ZERO)<=0);
        
       //(2017,12,18,2,0,NOW(),NOW(),1);
        
        /*Calendar calendarnow = Calendar.getInstance();
        calendarnow.setTime(new Date());
        System.out.println(calendarnow.get(Calendar.DAY_OF_MONTH));*/
        
        
        /*Calendar now = Calendar.getInstance();
        System.out.println(now.get(Calendar.MONTH));*/
        
       /* Calendar cal = Calendar.getInstance();
        String start = "2018-01-01";
        String end = "2019-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = sdf.parse(start);
        Date dEnd = sdf.parse(end);
        List<Date> lDate = findDates(dBegin, dEnd);
        for (Date date : lDate) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH) + 1;
            String str = calendar.get(Calendar.YEAR) + "," + month + "," + calendar.get(Calendar.DAY_OF_MONTH) + "," + calendar.get(Calendar.DAY_OF_WEEK) + "";
            if (calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
                str = str + ",1,NOW(),NOW(),1";
            } else {
                str = str + ",0,NOW(),NOW(),1";
            }

            System.out.println(str );//+ "------" + sdf.format(date)
        }*/
    }

    /*public static List<Date> findDates(Date dBegin, Date dEnd) {
        List lDate = new ArrayList();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            if((dEnd.after(calBegin.getTime())))
                lDate.add(calBegin.getTime());
        }
        return lDate;
    }*/
}
