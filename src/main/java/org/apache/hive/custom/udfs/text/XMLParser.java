package org.apache.hive.custom.udfs.text;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a custom Hive UDFs for parsing XML data from the dataset
 * Hive UDF Name: XMLParser
 *
 * @Author: rishu shrivastava
 * @LastUpdated: October 4, 2020
 *
 */
@Description(
        name = "Parse XML data based on the xpath provided by the user",
        value = "__FUNC(str,str)__ : Returns the value of the xml data based on the xpath expression provided."
)
public class XMLParser extends UDF {

    public List<String> evaluate(String data, String xpath){

        // return null if there is no data or xpath provided by the user.
        if(data == null || xpath == null ){
            return null;
        }

        return parseXPath(data,xpath);
    }

    private List<String> parseXPath(String data, String xpath_expression){

        Document document = convertStringToXMLDocument(data);

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        List<String> result = new ArrayList<>();

        try {
            XPathExpression xPathExpression = xPath.compile(xpath_expression);
            NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

            for(int i=0; i<nodeList.getLength(); i++){
                result.add(nodeList.item(i).getNodeValue());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

    private Document convertStringToXMLDocument(String data){
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document doc = null;

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(new InputSource(new StringReader(data)));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return doc;
    }
}
