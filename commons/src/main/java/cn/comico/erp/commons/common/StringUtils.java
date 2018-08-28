package cn.comico.erp.commons.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName StringUtils
 * @Description TODO
 * @date 2018/7/27 17:40
 **/
public class StringUtils {

    private static final String SQL_IN_DELIM = ",";         //sql in 分隔符
    private static final String SQL_IN_PREFIX = "'";        //sql in 前缀
    private static final String SQL_IN_SUFFIX = "'";        //sql in 后缀

    /**
    * 
    * @author      changhuanhu
    * @Description collection 转 SQL in string
    * @Param [collection]
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/27 17:46
    **/
    public static String collectionToSqlInString(Collection<?> collection) {
        return org.springframework.util.StringUtils.collectionToDelimitedString(collection, SQL_IN_DELIM, SQL_IN_PREFIX, SQL_IN_SUFFIX);
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 是否为null 或 空字符串
    * @Param [string]
    * @exception   
    * @return      boolean
    * @Date 2018/7/27 17:55
    **/
    public static boolean isEmpty(String string) {
        return null == string || 0 == string.trim().length();
    }
    
    /**
    * 
    * @author      changhuanhu
    * @Description 不为空, 也不为空字符串
    * @Param [string]
    * @exception   
    * @return      boolean
    * @Date 2018/7/27 17:55
    **/
    public static boolean nonEmpty(String string) {
        return !isEmpty(string);
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 相等
    * @Param [charSequence1, charSequence2]
    * @exception   
    * @return      boolean
    * @Date 2018/7/27 18:15
    **/
    public static boolean equals(CharSequence charSequence1, CharSequence charSequence2) {
        return org.apache.commons.codec.binary.StringUtils.equals(charSequence1, charSequence2);
    }

    /**
    * 
    * @author      changhuanhu
    * @Description string 转list
    * @Param [string]
    * @exception   
    * @return      java.util.List<java.lang.Integer>
    * @Date 2018/7/31 10:43
    **/
    public static List<Integer> splitStringToListInteger(String string, String split) {
        List<Integer> list = new ArrayList<>();
        if (nonEmpty(string)) {
            try {
                String[] stringArrays = string.split(split);
                for (String str : stringArrays) {
                    Collections.addAll(list, Integer.valueOf(str));
                }
            } catch (NumberFormatException e) {

            }
        }
        return list;
    }
}
