package com.apache.hive;


import java.io.UTFDataFormatException;

public class CustomeUDF extends UTFDataFormatException {

    public String evaluate (String input){
        return  "hello:" + input;
    }

    public String evaluate (String input,String input2){
        return "Hello:" + input + ":" + input2;
    }

    public static void main(String[] args) {
        CustomeUDF udf = new CustomeUDF();
        System.out.println(udf.evaluate("小明","小花"));
    }
}
