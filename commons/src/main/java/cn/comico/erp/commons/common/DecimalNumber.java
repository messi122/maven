package cn.comico.erp.commons.common;

import java.math.BigDecimal;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName DecimalNumber
 * @Description TODO
 * @date 2018/7/26 17:26
 **/
public class DecimalNumber{

    private BigDecimal bd;

    public DecimalNumber(Number number) {
        bd = newBigDecimal(number);
    }

    private BigDecimal newBigDecimal(Number number) {
        return new BigDecimal(String.valueOf(number));
    }

    public DecimalNumber add(Number number) {
        bd = bd.add(newBigDecimal(number));
        return this;
    }

    public DecimalNumber subtract(Number number) {
        bd = bd.subtract(newBigDecimal(number));
        return this;
    }

    public DecimalNumber multiply(Number number) {
        bd = bd.multiply(newBigDecimal(number));
        return this;
    }

    public DecimalNumber divide(Number number) {
        bd = bd.divide(newBigDecimal(number), 0, BigDecimal.ROUND_HALF_UP);
        return this;
    }

    public DecimalNumber divide(Number number, int scale) {
        bd = bd.divide(newBigDecimal(number), scale, BigDecimal.ROUND_HALF_UP);
        return this;
    }

    public DecimalNumber divide(Number number, int scale, int mode) {
        bd = bd.divide(newBigDecimal(number), scale, mode);
        return this;
    }

    public DecimalNumber scale(int scale) {
        scale(scale, BigDecimal.ROUND_HALF_UP);
        return this;
    }

    public DecimalNumber scale(int scale, int mode) {
        bd.setScale(scale, mode);
        return this;
    }

    public long longValue() {
        return bd.longValue();
    }

    public int intValue() {
        return bd.intValue();
    }

    public double doubleValue() {
        return bd.doubleValue();
    }

    public float floatValue() {
        return bd.floatValue();
    }

    public static void main(String[] args) {
        System.out.println(new DecimalNumber(5000).divide(3.6, 2).doubleValue());
        System.out.println(new DecimalNumber(5000).divide(3.6).scale(2).doubleValue());
    }
}
