package cn.comico.erp.commons.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @ClassName ObjectMapUtil
 * @Description TODO
 * @Author LuckyQi
 * @Date 2018/8/9 16:26
 * @Version 1.0
 */
public class ObjectMapUtil {

    public static Object map2Bean(Class type, Map map)
            throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {

        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    /**
     * 将指定类转换为Map类型
     * @param bean
     * @param mp
     * @param <T>
     * @param <K>
     * @param <V>
     * @return
     * @throws Exception
     * @throws IllegalAccessException
     */
    public static <T, K, V> Map<String, Object> beanToMap(T bean, Map<String, Object> mp)
            throws Exception, IllegalAccessException {

        if (bean == null) {
            return null;
        }

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                if (!key.equals("class")) {

                    Method getter = property.getReadMethod();// Java中提供了用来访问某个属性的
                    // getter/setter方法
                    Object value;

                    value = getter.invoke(bean);
                    mp.put(key, value);
                }

            }

        } catch (IntrospectionException e) {

            e.printStackTrace();
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return mp;

    }
}
