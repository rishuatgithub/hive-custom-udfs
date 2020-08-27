package org.apache.hive.custom.udfs.dates;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateDiffminusWeekendsTest {

    private DateDiffminusWeekends dateDiffminusWeekends;

    @Before
    public void setup(){
        dateDiffminusWeekends = new DateDiffminusWeekends();
    }

    @Test
    public void finddatediff(){

        Integer diff1 = dateDiffminusWeekends.getdatediff("2020-01-01","2020-01-01");
        Assert.assertEquals(new Integer(1),diff1);

        Integer diff2 = dateDiffminusWeekends.getdatediff("2020-01-01","2020-01-03");
        Assert.assertEquals(new Integer(3),diff2);

        Integer diff3 = dateDiffminusWeekends.getdatediff("2020-08-22","2020-08-30");
        Assert.assertEquals(new Integer(5),diff3);

        Integer diff4 = dateDiffminusWeekends.getdatediff(null,null);
        Assert.assertEquals(new Integer(0),diff4);
    }
}
