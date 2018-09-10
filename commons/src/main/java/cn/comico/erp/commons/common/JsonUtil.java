package cn.comico.erp.commons.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName JsonUtil
 * @Description TODO
 * @date 2018/7/18 10:36
 **/
public class JsonUtil {

    /**
    * 
    * @author      changhuanhu
    * @Description 对象转json字符串
    * @Param [obj]
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/18 10:39
    **/
    public static String writeValueAsString(Object obj) {
        String result = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
    * 
    * @author      changhuanhu
    * @Description JSON字符串转对象
    * @Param [str, clazz]
    * @exception   
    * @return      T
    * @Date 2018/7/18 10:43
    **/
    public static <T> T readValue(String str, Class<T> clazz) {
        T t = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            t = mapper.readValue(str, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        /*String str = "[{\"name\":\"hch\"},{\"name\":\"cx\"}]";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.reader().readTree(str);
        JsonNode jsonNode1 = jsonNode.get(0);
        String name = jsonNode1.get("name").asText();
        System.out.println(name);*/
        /*Integer purchasePrice =288800;
        Integer discount =6547;

        BigDecimal bigPrice =new BigDecimal(String.valueOf(purchasePrice));
        BigDecimal bigDiscount =new BigDecimal(String.valueOf(discount/10000.0));
        BigDecimal price =bigPrice.multiply(bigDiscount).setScale(0,BigDecimal.ROUND_HALF_UP);
        //BigDecimal count =a.multiply(b);
        System.out.println(price);

        String date ="";
        int length =date.trim().length();
        System.err.println("length:"+length);
        boolean is =StringUtils.isEmpty(date);
        System.out.println(is);*/
        String purchase ="CG20180808,2013656";

        List<String> list = Arrays.asList(purchase.split(","));
        System.out.println(list);

    }
}
