package cn.comico.erp.commons.common;

/**
 * @Description:
 * @ClassName: cn.comico.erp.commons.common
 * @Author: yuyong
 * @CreateDate: 2018/10/22 16:33
 * @UpdateUser:
 * @UpdateDate: 2018/10/22 16:33
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class ThreeSingle {

    public static void main(String[] args) {
        int row =8;
        int[][] array =new int[row][row];

        for(int i=0;i<row;i++){
            for(int j=0;j<=i;j++){
                if(j==0 ||j==i){
                    array[i][j]=1;
                }else {
                    array[i][j]=array[i-1][j]+array[i-1][j-1];
                }
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }

        /**
         * 等腰输出
         */
         for(int i=0;i<row;i++){
             int num =row-i;
             for(int j=0;j<=num;j++){
                 System.out.print(" ");
             }

             for(int k=0;k<=i;k++){
                 System.out.print(array[i][k]+" ");
             }

             System.out.println();

         }


    }
}
