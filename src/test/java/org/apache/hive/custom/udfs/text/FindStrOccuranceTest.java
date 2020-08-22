package org.apache.hive.custom.udfs.text;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case for the FindStrOccurance Hive UDF Function
 *
 * @Author: rishu shrivastava
 * @LastUpdated: Aug 22, 2020
 */
public class FindStrOccuranceTest {

    private FindStrOccurance findStrOccurance;

    @Before
    public void setup(){
        findStrOccurance = new FindStrOccurance();
    }

    @Test
    public void testEvaluate(){
        Integer count1 = findStrOccurance.evaluate("Hello This is a test function","is");
        assertEquals(new Integer(2), count1);

        Integer count2 = findStrOccurance.evaluate("hive@org@apache@.com","@");
        assertEquals(new Integer(3), count2);

        Integer count3 = findStrOccurance.evaluate("hive","hive2");
        assertEquals(new Integer(0), count3);

        Integer count4 = findStrOccurance.evaluate("null","is");
        assertEquals(new Integer(0), count4);

        Integer count5 = findStrOccurance.evaluate("null","null");
        assertEquals(new Integer(1), count5);

        Integer count6 = findStrOccurance.evaluate("hive custom udfs","null");
        assertEquals(new Integer(0), count6);

    }

}
