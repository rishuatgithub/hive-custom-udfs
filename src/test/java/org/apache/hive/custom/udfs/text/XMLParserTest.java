package org.apache.hive.custom.udfs.text;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test case for the XMLParser Hive UDF Function
 *
 * @Author: rishu shrivastava
 * @LastUpdated: Oct 4, 2020
 */
public class XMLParserTest {

    private XMLParser xmlParser;
    String testdata = null, malformed_testdata=null;

    @Before
    public void setup(){
        xmlParser = new XMLParser();
        testdata = "<?xml version = \"1.0\"?>\n" +
                "<class>\n" +
                "   <student rollno = \"393\">\n" +
                "      <firstname>Dinkar</firstname>\n" +
                "      <lastname>Kad</lastname>\n" +
                "      <nickname>Dinkar</nickname>\n" +
                "      <marks>85</marks>\n" +
                "   </student>\n" +
                "   \n" +
                "   <student rollno = \"493\">\n" +
                "      <firstname>Vineet</firstname>\n" +
                "      <lastname>Gupta</lastname>\n" +
                "      <nickname>Vinni</nickname>\n" +
                "      <marks>95</marks>\n" +
                "   </student>\n" +
                "   \n" +
                "   <student rollno = \"593\">\n" +
                "      <firstname>Jasvir</firstname>\n" +
                "      <lastname>Singh</lastname>\n" +
                "      <nickname>Jazz</nickname>\n" +
                "      <marks>90</marks>\n" +
                "   </student>\n" +
                "   <student rollno = \"999\">\n" +
                "      <firstname>XYZ</firstname>\n" +
                "      <lastname>PPPP</lastname>\n" +
                "      <marks>90</marks>\n" +
                "   </student>\n" +
                "</class>";

        malformed_testdata = "<?xml version = \"1.0\"?>\n" +
                "<class>\n" +
                "   <student rollno = \"393\">\n" +
                "      <firstname>Dinkar</firstname>\n" +
                "      <lastname>Kad</lastname>\n" +
                "      <nickname>Dinkar</nickname>\n" +
                "      <marks>85</marks>\n" +
                "   </student>\n" +
                "   \n" +
                "   <student rollno = \"493\">\n" +
                "      <firstname>Vineet</firstname>\n" +
                "      <lastname>Gupta</lastname>\n" +
                "      <nickname>Vinni</nickname>\n" +
                "      <marks>95</marks>\n";

    }

    @Test
    public void testNullData_basic01(){
        Assert.assertNull(xmlParser.evaluate(null,"ABC"));
    }

    @Test
    public void testNullData_basic02(){
        Assert.assertNull(xmlParser.evaluate(null,null));
    }

    @Test
    public void parseXPath_return_rollno_basic(){
        List<String> expected_output = new ArrayList<>();
        expected_output.add("393");
        expected_output.add("493");
        expected_output.add("593");
        expected_output.add("999");

        Assert.assertEquals(expected_output,xmlParser.evaluate(testdata,"/class/student/@rollno"));
    }

    @Test
    public void parseXPath_return_Name_basic(){
        List<String> expected_output = new ArrayList<>();
        expected_output.add("Dinkar");
        expected_output.add("Vineet");
        expected_output.add("Jasvir");
        expected_output.add("XYZ");

        Assert.assertEquals(expected_output,xmlParser.evaluate(testdata,"/class/student/firstname/text()"));
    }

    @Test
    public void searchforspecificname_return_marks(){
        List<String> expected_output = new ArrayList<>();
        expected_output.add("95");

        Assert.assertEquals(expected_output,xmlParser.evaluate(testdata,"/class/student[firstname='Vineet']/marks/text()"));
    }

    @Test
    public void testmissingattribute_returnNull_nickname_missing(){
        List<String> expected_output = new ArrayList<>();
        expected_output.add("Dinkar");
        expected_output.add("Vinni");
        expected_output.add("Jazz");

        Assert.assertEquals(expected_output,xmlParser.evaluate(testdata,"/class/student/nickname/text()"));
    }

    @Test
    public void malformedXMLtest(){
        Assert.assertNull(xmlParser.evaluate(malformed_testdata,"/class/student/@rollno"));
    }


}
