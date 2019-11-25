package com.example.earlychildhooddevelopmentapp.Model;

import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by CryoFlar3 on 4/19/2015.
 */
public class Calculate {

    public Date Calculate(DatePicker dob, int early){

        Date newDate = new Date(dob.getYear() - 1900, dob.getMonth(), dob.getDayOfMonth());
        int numOfDays = early * 7;

        // Calculateing actual Birth
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(newDate);
        calendar.add(Calendar.DATE, numOfDays);
        newDate.setTime(calendar.getTime().getTime());

        return newDate;
    }

    public int getYear(Date date){

        // Parse Birth Date
        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        return age;
    }

    public int getMonth(Date date){

        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.MONTH) - dob.get(Calendar.MONTH);

        return age;
    }
}





























