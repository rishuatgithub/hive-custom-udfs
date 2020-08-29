package org.apache.hive.custom.udfs.text;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a custom Hive UDFs for searching character/words in a sentence
 * Hive UDF Name: FindStrOccurance
 *
 * @Author: rishu shrivastava
 * @LastUpdated: Aug 22, 2020
 *
 */
@Description(
        name = "Find Total Occurance of a character in a Word",
        value = "_FUNC_(str,str) - Return the total number of search character in a word",
        extended = "USAGE: select find_str_occurance(\"Hello This is a test function\",\"is\") from table"
)
public class FindStrOccurance extends UDF {

    public Integer evaluate(String word, String search_word){

        if(word == null || search_word == null) {
            return null;
        }

        int count = 0;

        Pattern pattern = Pattern.compile(search_word);
        Matcher matcher = pattern.matcher(word);

        while (matcher.find()){
            count += 1;
        }

        return count;
    }
}
