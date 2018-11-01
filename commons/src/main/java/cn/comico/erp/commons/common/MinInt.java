package cn.comico.erp.commons.common;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/10/22 17:39
 * @UpdateUser:
 * @UpdateDate: 2018/10/22 17:39
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class MinInt {

    public static void f(int array[]){
        for(int i=0;i<array.length-1;i++){
            int big=0;
            for(int  j=0;j<array.length-i;j++){
                if(compare(String.valueOf(array[j]),String.valueOf(array[big]))>0){
                    big=j;
                }
            }
            if(big!=array.length-i-1){
                int temp=array[big];
                array[big]=array[array.length-i-1];
                array[array.length-i-1]=temp;
            }
        }
        for(int a:array){
            System.out.print(a+" ");
        }
    }
    public static int compare(String a, String b){
        //compare
        String  left=a+b;
        String  right=b+a;
        for(int i=0;i<left.length()-1;i++){
            if(left.charAt(i)>right.charAt(i)){
                return 1;
            }else if(left.charAt(i)<right.charAt(i)){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String args []){
        int array[]=/*{23,345, 121,42,1}*/{6,32,321,4};
        MinInt.f(array);
    }
}

