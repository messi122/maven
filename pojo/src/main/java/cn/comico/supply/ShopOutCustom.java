package cn.comico.supply;

import javax.persistence.Transient;

/**
 * @ClassName ShopOutCustom
 * @Description TODO
 * @Author win 10
 * @Date 2018/7/26 15:50
 * @Version 1.0
 */
public class ShopOutCustom extends ShopOut {

    @Transient
    private transient Integer nums;

    @Transient
    private transient Long dpPrices;

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Long getDpPrices() {
        return dpPrices;
    }

    public void setDpPrices(Long dpPrices) {
        this.dpPrices = dpPrices;
    }
}
