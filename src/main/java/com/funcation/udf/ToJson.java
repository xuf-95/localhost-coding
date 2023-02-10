package com.funcation.udf;

import com.google.gson.Gson;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ToJson
 * @Description: TODO:
 * @Version: 1.0
 * @User: dandypeng
 * @Date: 2023/2/10 23:55
 * @E-Mail: pfux163@163.com
 **/
public class ToJson extends UDF {
    public String evaluate (List<Map<String, String>> obj) {
        return new Gson().toJson(obj);
    }
}
