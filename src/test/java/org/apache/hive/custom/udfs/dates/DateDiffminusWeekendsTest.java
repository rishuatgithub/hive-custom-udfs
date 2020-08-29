package org.apache.hive.custom.udfs.dates;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test case for the DateDiffminusWeekends Hive UDF Function
 *
 * @Author: rishu shrivastava
 * @LastUpdated: Aug 29, 2020
 */
public class DateDiffminusWeekendsTest {

    private DateDiffminusWeekends dateDiffminusWeekends;

    @Before
    public void setup(){
        dateDiffminusWeekends = new DateDiffminusWeekends();
    }

    @Test
    public void finddatediff_basic(){
        Assert.assertEquals(new Integer(5),dateDiffminusWeekends.getdatediff("2020-08-28","2020-08-22"));
    }

    @Test
    public void finddatediff_validedates(){
        Assert.assertEquals(null,dateDiffminusWeekends.getdatediff("2020-08-28","2020-09-01"));
    }

    @Test
    public void finddatediff_validedates2(){
        Assert.assertEquals(null,dateDiffminusWeekends.getdatediff(null,"2020-09-01"));
    }

    @Test
    public void finddatediff_validedates3(){
        Assert.assertEquals(null,dateDiffminusWeekends.getdatediff("01-Jan-2020","2020-09-01"));
    }

    @Test
    public void finddatediff_validedates4(){
        Assert.assertNull(dateDiffminusWeekends.getdatediff(null,null));
    }

    @Test
    public void finddatediff_samedays(){
        Assert.assertEquals(new Integer(1),dateDiffminusWeekends.getdatediff("2020-09-01","2020-09-01"));
    }

}
