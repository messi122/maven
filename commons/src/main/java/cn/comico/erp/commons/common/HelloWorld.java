package cn.comico.erp.commons.common;
import java.util.Arrays;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/10/17 9:26
 * @UpdateUser:
 * @UpdateDate: 2018/10/17 9:26
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class HelloWorld {

    public static void main(String[] args) {
        int[] arr ={-10,10,2,5,1,0,45,21,3,100,-20,6,7,8,9,5454,657,65,565,4,23,23,423,43,65,545,656,54545,54362,546};
        Long start = System.currentTimeMillis();
        insertSort(arr);
        Long end =System.currentTimeMillis();
        System.out.println("排序耗时:" +end+":"+start);
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort(int[] arr){
        int len =arr.length;
        for (int i=1;i<len;i++){
        int temp =arr[i];
        int insert =i-1;

        while(insert>=0 && arr[insert]>temp){
            arr[insert+1]=arr[insert];
            insert--;
        }

        arr[insert+1] =temp;
        }

    }
}
