package cn.comico.erp.commons.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/9/20 11:55
 * @UpdateUser:
 * @UpdateDate: 2018/9/20 11:55
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class Test {

    public static String getGapTime(long time) {
        long hours = time / (1000 * 60 * 60);
        long minutes = (time - hours * (1000 * 60 * 60)) / (1000 * 60);
        String diffTime = "";
        if (minutes < 10) {
            diffTime = hours + ":0" + minutes;
        } else {
            diffTime = hours + ":" + minutes;
        }
        return diffTime;
    }

    public static void main(String[] args) {
        /*long ms = 80000;
             SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
               String hms = formatter.format(ms);
               System.out.println(hms);
        String s="0";
        Long l =Long.parseLong(s);
        System.out.println(l);
        List<String> list = new ArrayList<>();
        list.add("VIP001");
        list.add("VIP002");
        list.add("VIP003");
        System.out.println(list.toString());
        String week = getDayOfWeekByDate("2018-09-09");
        System.out.println("今天是:" + week);*/
        /*int a = 0;
        int b = 1;
        int m;
        int n=0;
        do {
            m = a + b;
            int temp = 0;
            temp = m;
            a = b;
            b = temp;
            n+=a;
            System.out.print(a + " ");

        } while (m <= 9);*/
        /**
         * 1 1 2 3 5 8 13 21 34 55 89
         */
        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int n){
        int [] result={0,1};
        if(n<2){
            return result[n];
        }
        int one=0;
        int two =1;
        int fib=0;
        for(int i=2;i<=n;i++){
            fib =one+two;
            one =two;
            two=fib;
        }
        return fib;
    }




    public static int slove(int n) {
        if (n <= 2) {
            return n;
        } else if (n <= 0) {
            return 0;
        } else {
            /**
             * 3+2-->2+1+2
             */
            return slove(n - 1) + slove(n - 2);
        }

    }


    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            dayOfweek = str;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dayOfweek;
    }

}
