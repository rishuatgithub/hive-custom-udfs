package org.apache.hive.custom.udfs.dates;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This is a custom Hive UDFs for finding
 * Hive UDF Name: DateDiffminusWeekends
 *
 * @Author: rishu shrivastava
 * @LastUpdated: Aug 27, 2020
 *
 *
 */

@Description(
        name = "Find difference between two dates minus the weekends",
        value = "_FUNC_(str,str) - Returns the days in total minus the weekends in hive.",
        extended = "SELECT datediff_minus_weekends(\"2020-08-01\",\"2020-08-10\") from table"
)
public class DateDiffminusWeekends extends UDF {

    public Integer getdatediff(String d1, String d2){

        if(d1 == null || d2 == null){
            return 0;
        }

        int sat = 0, sun = 0, total_days = 0, net_total_days =0;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {

            c1.setTime(simpleDateFormat.parse(d1));
            c2.setTime(simpleDateFormat.parse(d2));

            while(!c1.after(c2)){
                if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                    sat +=1;
                }
                if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                    sun +=1;
                }
                total_days +=1;
                c1.add(Calendar.DATE,1);
            }

            net_total_days = total_days - (sun + sat);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Integer(net_total_days);
    }
}
