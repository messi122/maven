package cn.comico.supply.api;

/**
 * @Description:
 * @ClassName: cn.comico.supply.api
 * @Author: yuyong
 * @CreateDate: 2018/9/10 18:12
 * @UpdateUser:
 * @UpdateDate: 2018/9/10 18:12
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class ClientTest {
    public static void main(String[] args) {
        Human human = null;
        human = new Factory().getHuman(Factory.CHINESE);
        human.eat();
        human.wolk();
        human = new Factory().getHuman(Factory.AMERICAN);
        human.eat();
        human.wolk();
    }
}
