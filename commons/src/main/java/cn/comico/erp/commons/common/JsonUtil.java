package cn.comico.erp.commons.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName JsonUtil
 * @Description TODO
 * @date 2018/7/18 10:36
 **/
public class JsonUtil {

    /**
     * @return java.lang.String
     * @throws
     * @author changhuanhu
     * @Description 对象转json字符串
     * @Param [obj]
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
     * @return T
     * @throws
     * @author changhuanhu
     * @Description JSON字符串转对象
     * @Param [str, clazz]
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

        String date ="";
        boolean is =StringUtils.isEmpty(date);
        System.out.println(is);*/
        String purchase = "CG201809120001,CG201809120002,CG201809120009";

        List<String> list = Arrays.asList(purchase.split(","));
        List<String> stringList = new ArrayList<>();
        stringList.add("messi");
        stringList.add(0, "marry");
        stringList.add("555");

        List<String> nameList = new ArrayList<>();
        nameList.add("messi");
        nameList.add("marry");

        nameList.retainAll(stringList);

        System.out.println("nameList:" + nameList);

        for (String s : stringList) {
            // System.out.println(s);
        }
        // System.out.println(list);
        // System.out.println(list.size());
        //  System.out.println("CG20180917001");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("I'm ok");
            }
        });
    }
}
