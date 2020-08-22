# Hive Custom UDFs
#### This is a repository holding binaries of Apache hive custom user defined functions

[![Build Status](https://travis-ci.org/rishuatgithub/hive-custom-udfs.svg?branch=master)](https://travis-ci.org/rishuatgithub/hive-custom-udfs) 
[![codecov](https://codecov.io/gh/rishuatgithub/hive-custom-udfs/branch/master/graph/badge.svg)](https://codecov.io/gh/rishuatgithub/hive-custom-udfs) 
[![HitCount](http://hits.dwyl.com/rishuatgithub/hive-custom-udfs.svg)](http://hits.dwyl.com/rishuatgithub/hive-custom-udfs)

## Introduction

[Apache Hive](https://hive.apache.org) is a big data database that facilitates reading, writing, and managing large datasets residing in the distributed storage and queried using SQL syntax.
Built on top of [Apache Hadoop](http://hadoop.apache.org), hive enables easy access to data via SQL, thus enabling data warehousing tasks such as extract/transform/load (ETL), reporting, and data analysis.

Apache Hive supports many [in-built functions](https://cwiki.apache.org/confluence/display/Hive/LanguageManual+UDF) to manipulate and process the data. 
Though there are lot of available options, sometimes due to business use-cases, readily available functions may not be available.
Hive allows you to extend and create User defined functions (UDFs) by extending the `org.apache.hadoop.hive.ql.exec.UDF` class. 

This repository provides users with a single unified custom user defined binary for an array of plugins and functions. 
The idea is to solve the work-around-solutions in apache hive UDFs and create a single repository for all the custom udfs.

## Custom Plugins List

Below are the list of currently available plugins. Click on the below urls to learn more.

- [Find total occurance of a word/character in a sentence](https://github.com/rishuatgithub/hive-custom-udfs/wiki/Find-total-occurance-of-a-word-character-in-a-sentence)
- [Find days between two dates excluding weekends](https://github.com/rishuatgithub/hive-custom-udfs/wiki/Find-days-between-two-dates-excluding-weekends)

## General Usage

In order to use and plugin the UDFs, follow the below steps:

1. Download the `hive-custom-udfs-*.jar` onto your system or edge-node.
2. Upload the downloaded jar onto HDFS location. Use the below command:

       $ hadoop fs -copyFromLocal hive-custom-udfs-*.jar <path of your hdfs directory>
       
3. Login to Hive SHELL and add the jar to the Hive Classpath and define a function, as below:
        
       $ beeline -u jdbc:hive2://localhost:10000
       hive> create function <function_name> as '<function_java_class>' using JAR 'hdfs:///<path of hdfs directory>/hive-custom-udfs-*.jar';

    - The name of the function is specific to you. It is something we cannot define it for you.
    - The function Java class is the class path of the function to use. Every function class will have a definite Java Class Name. You need to ensure you use the exact class names. Follow the wiki page for more details. 

4. Use the function in hive
 
       hive> SELECT function_name(str,str) FROM <table_name>;

You can use the official Hive Documentation for more on [deploying hive udfs](https://cwiki.apache.org/confluence/display/Hive/HivePlugins#HivePlugins-DeployingJarsforUserDefinedFunctionsandUserDefinedSerDes).


## Raising Issues

For raising issues, you can make use of the [github issues](https://github.com/rishuatgithub/hive-custom-udfs/issues).