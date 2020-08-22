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
        int count1 = findStrOccurance.evaluate("Hello This is a test function","is");
        assertEquals(2, count1);

        int count2 = findStrOccurance.evaluate("hive@org@apache@.com","@");
        assertEquals(3, count2);

        int count3 = findStrOccurance.evaluate("hive","hive2");
        assertEquals(0, count3);

        int count4 = findStrOccurance.evaluate("null","is");
        assertEquals(0, count4);

        int count5 = findStrOccurance.evaluate("null","null");
        assertEquals(1, count5);

        int count6 = findStrOccurance.evaluate("hive custom udfs","null");
        assertEquals(0, count6);

    }

}
