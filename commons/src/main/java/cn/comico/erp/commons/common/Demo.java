package cn.comico.erp.commons.common;

import java.sql.Array;
import java.util.*;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/10/16 11:30
 * @UpdateUser:
 * @UpdateDate: 2018/10/16 11:30
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class Demo {

    public static void main(String[] args) {

        int [] arr ={4,5,1,10,7,9,7,8,1,10,11};

       // List<Integer> arrList =new ArrayList<>();
Set set =new HashSet();
        for(int i=0;i<arr.length;i++){
            /*if(!arrList.contains(arr[i])){
                arrList.add(arr[i]);
            }*/
            set.add(arr[i]);
        }
        System.out.println(Arrays.toString(set.toArray()));
        //System.out.println(arrList.to);

    }
}
