package cn.comico.supply.api;

/**
 * @Description:
 * @ClassName: cn.comico.supply.api
 * @Author: yuyong
 * @CreateDate: 2018/9/10 18:02
 * @UpdateUser:
 * @UpdateDate: 2018/9/10 18:02
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class American implements  Human{
    @Override
    public void eat() {
        System.out.println("美国人就吃汉堡");
    }

    @Override
    public void wolk() {
        System.out.println("美国人爱做汽车");
    }
}
