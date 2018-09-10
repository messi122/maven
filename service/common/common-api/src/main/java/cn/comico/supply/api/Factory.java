package cn.comico.supply.api;

/**
 * @Description:
 * @ClassName: cn.comico.supply.api
 * @Author: yuyong
 * @CreateDate: 2018/9/10 18:05
 * @UpdateUser:
 * @UpdateDate: 2018/9/10 18:05
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class Factory {

    public static final String CHINESE = "Chinese";
    public static final String AMERICAN = "American";

    public  Human getHuman(String name) {
        if (CHINESE.equals(name)) {
            return new Chinese();
        } else if (AMERICAN.equals(name)) {
            return new American();
        } else {
            throw new IllegalArgumentException("参数(人种)错误");
        }
    }





}
