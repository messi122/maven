package cn.comico.supply.api;

/**
 * @Description:
 * @ClassName: cn.comico.supply.api
 * @Author: yuyong
 * @CreateDate: 2018/9/10 17:58
 * @UpdateUser:
 * @UpdateDate: 2018/9/10 17:58
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class Chinese implements Human{
    @Override
    public void eat() {
        System.out.println("中国人对吃饭很讲究");
    }

    @Override
    public void wolk() {
        System.out.println("中国人轻功贼好");
    }
}
