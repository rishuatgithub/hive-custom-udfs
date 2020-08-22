package org.apache.hive.custom.udfs.text;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class FindStrOccurance extends UDF {

    public Text evaluate(final Text word, final Text search_word){
        return null; //TODO
    }
}
