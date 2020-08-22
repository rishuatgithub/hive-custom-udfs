package org.apache.hive.custom.udfs.dates;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class FindAgeExcludeWeekdays extends UDF {

    public Text evaluate(final String date1, final String date2){
        return new Text("TODO");
    }
}
