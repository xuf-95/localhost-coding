package com.funcation.udf;

import com.funcation.utils.DateUtils;
import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @ClassName: DatePrase
 * @Description: TODO:
 * @Version: 1.0
 * @User: dandypeng
 * @Date: 2023/2/11 23:10
 * @E-Mail: pfux163@163.com
 **/
public class DatePrase extends UDF {
    /**
     *
     * @param dayTime 日期或者是时间戳
     * @param formatStr 输出格式
     * @return
     */
    public String evaluate (String  dayTime, String formatStr){
        if (dayTime == null || formatStr == null){
            return null;
        }
        return DateUtils.DateTimeParse(dayTime, formatStr);
    }

    public static void main(String[] args) {
        //System.out.println(new DateParse().evaluate("2022-01-09 10:03:59:3", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(new DatePrase().evaluate("2021年12月13日 12:23:12","yyyy-MM-dd HH我mm我ss"));
        /*System.out.println(new DateParse().evaluate("2022/1/7", "yyyy-MM-dd"));
        System.out.println(new DateParse().evaluate("2022/1/7", "yyyy-MM-dd  HH:mm:ss"));
        System.out.println(new DateParse().evaluate("2022-01-09 09:35:33:3", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(new DateParse().evaluate("2022/1/7 14:47:20:1", "yyyy年MM月dd日 HH时mm分ss秒"));
        System.out.println(new DateParse().evaluate("2022.1.7 14:47:20", "yyyy年MM月dd日 HH时mm分ss秒"));*/
    }

}
