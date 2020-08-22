package org.apache.hive.custom.udfs.dates;

import org.apache.hadoop.io.Text;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FindAgeExcludeWeekdaysTest {

    private FindAgeExcludeWeekdays findAgeExcludeWeekdays;

    @Before
    public void setup(){
        findAgeExcludeWeekdays = new FindAgeExcludeWeekdays();
    }

    @Test
    public void findageexcludeweekdaystest(){
        Text age = findAgeExcludeWeekdays.evaluate("1970-01-01","1970-01-02");
        assertEquals(new Text("TODO"),age);
    }
}
