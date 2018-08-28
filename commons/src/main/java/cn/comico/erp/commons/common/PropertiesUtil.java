package cn.comico.erp.commons.common;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PropertiesUtil
 * @Description TODO
 * @date 2018/8/1 9:50
 **/
public class PropertiesUtil {

    public static <T> T get(T t, T def) {
        return null != t ? t : def;
    }

}
