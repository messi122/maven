package cn.comico.erp.commons.spring;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Bean工具类
 */
public class BeanUtils {

    /**
     * 复制对象属性值
     * @param obj
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T copyObject(Object obj, Class<T> clazz) {
        T t = null;
        try {
            if (null != obj) {
                t = clazz.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(obj, t);
            }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
         return t;
    }

    /**
     * 复制列表
     * @param list
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> copyList(List<?> list, Class<T> clazz) {
        return Optional.ofNullable(list).orElse(new ArrayList<>())
                .stream()
                .map(obj -> copyObject(obj, clazz))
                .collect(Collectors.toList());

    }
}
