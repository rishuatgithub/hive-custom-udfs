package org.apache.hive.custom.udfs.text;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * This is a custom Hive UDFs for searching character/words in a sentence
 * Hive UDF Name: FindStrOccurance
 *
 * @Author: rishu shrivastava
 * @LastUpdated: Aug 22, 2020
 *
 *
 */

@Description(
    name = "Find Total Occurance of a character in a Word",
        value = "_FUNC_(str,str) - Return the total number of search character in a word"
)
public class FindStrOccurance extends UDF {

    public Integer evaluate(final String word, final String search_word){

        if(word == null || search_word == null) {
            return 0;
        }

        int number_of_occurances = StringUtils.countMatches(word,search_word);

        return new Integer(number_of_occurances);
    }
}
