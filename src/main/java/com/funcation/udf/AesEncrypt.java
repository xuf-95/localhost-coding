package com.funcation.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @ClassName: AesEncrypt
 * @Description: TODO:
 * @Version: 1.0
 * @User: dandypeng
 * @Date: 2023/2/8 23:48
 * @E-Mail: pfux163@163.com
 **/
public class AesEncrypt extends UDF {
    /*
     * 加密用的Key 可以用26个字母和数字组成 使用AES-128-CBC加密模式，key需要为16位。
     */
    private static final String iv = "NIfb&95GUY86Gfgh";

}
