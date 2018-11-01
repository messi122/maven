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
            int temp =arr[i];
            int insert =i-1+0;
            while(insert>=0 && arr[insert]>temp){
                arr[insert+1]=arr[insert];
                insert--;
            }
            arr[insert+1]=temp;
        }

        return arr;
    }
}
