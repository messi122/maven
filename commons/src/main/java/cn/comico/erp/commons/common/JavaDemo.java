package cn.comico.erp.commons.common;

import java.util.Scanner;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/10/22 17:14
 * @UpdateUser:
 * @UpdateDate: 2018/10/22 17:14
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class JavaDemo {

    public static void main(String[] args) {
        String str = "";

        Scanner scan = new Scanner(System.in);

        str = scan.nextLine();

        permutation(str.toCharArray(), 0);
    }

    /**
     * abc
     * temp =a
     *
     *
     * @param str
     * @param i
     */
    public static void permutation(char[] str, int i) {
        if (i >= str.length) {
            return;
        }
        if (i == str.length - 1) {
            System.out.println(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;

                permutation(str, i + 1);

                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }

}
