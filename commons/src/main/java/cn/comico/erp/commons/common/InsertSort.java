package cn.comico.erp.commons.common;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/10/16 17:09
 * @UpdateUser:
 * @UpdateDate: 2018/10/16 17:09
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr ={80,9,-1,20,10,5,4,10};
        System.out.println(Arrays.toString(sort(arr)));
    }


    public static int[] sort(int[] arr){
        int len =arr.length;

        for(int i=1;i<len;i++){
            int temp =arr[i];//储存待排序元素值
            int insert =i-1;//储存当前元素的下标值
            while(insert>=0 && arr[insert]>temp){//如果待排序元素值小于之前的元素值
                arr[insert+1]=arr[insert];//当前元素的位置后移一位
                insert--;
            }
            arr[insert+1]=temp;//找到插入的位置
        }
        return arr;
    }
}
