package org.apache.hive.custom.udfs.text;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the FindStrOccurance Hive UDF Function
 *
 * @Author: rishu shrivastava
 * @LastUpdated: Aug 29, 2020
 */
public class FindStrOccuranceTest {

    private FindStrOccurance findStrOccurance;

    @Before
    public void setup(){
        findStrOccurance = new FindStrOccurance();
    }

    @Test
    public void testEvaluate_basic(){
        assertEquals(new Integer(2), findStrOccurance.evaluate("Hello This is a test function","is"));
    }

    @Test
    public void testEvaluate_basic2(){
        assertEquals(new Integer(3), findStrOccurance.evaluate("hive@org@apache@.com","@"));
    }

    @Test
    public void testEvaluate_basic3(){
        assertEquals(new Integer(1), findStrOccurance.evaluate("hive@org@apache@.com",".com"));
    }

    @Test
    public void testEvaluate_validate(){
        assertEquals(new Integer(0), findStrOccurance.evaluate("hive","hive2"));
    }

    @Test
    public void testEvaluate_validate2(){
        assertNull(findStrOccurance.evaluate(null,"is"));
    }

    @Test
    public void testEvaluate_validate3(){
        assertNull(findStrOccurance.evaluate(null,null));
    }

    @Test
    public void testEvaluate_validate4(){
        assertNull(findStrOccurance.evaluate("hive custom udfs",null));
    }

}
