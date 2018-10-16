package cn.comico.erp.commons.common;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/9/17 14:35
 * @UpdateUser:
 * @UpdateDate: 2018/9/17 14:35
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class ThreadPool {
    public static void main(String[] args) {
        /*ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            final int index = i;
            try {
                Thread.sleep(index*1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index+":"+new Date().getSeconds());
                }
            });
        }*/

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for(int i=0;i<15;i++){
            final  int index =i;
            executorService1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }



    }
}
