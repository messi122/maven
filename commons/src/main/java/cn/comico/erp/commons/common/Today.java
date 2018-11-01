package cn.comico.erp.commons.common;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/10/23 10:35
 * @UpdateUser:
 * @UpdateDate: 2018/10/23 10:35
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class Today {

    public static void main(String[] args) {//循环输出等腰三角形  
        int max = 10;
        for (int i = 1;
             i <= max;
             i++) {//控制空格  
            for (int k = 1; k <= max - i; k++) {
                System.out.print(" ");
            }//控制“*”
            for (int j = 1;
                 j <= 2 * i - 1;
                 j++) {
                System.out.print("*");
            }
            System.out.println();//利用println输出换行  
        }
    }
}
