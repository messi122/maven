package cn.comico.set;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetChannelPurchase
 * @Description TODO
 * @date 2018/6/22 11:03
 **/
@Entity
@Table(name = "t_set_channel_purchase")
public class SetChannelPurchase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    private Long brandId;

    /**
     * 信用额度
     */
    @Column(name = "credit")
    private int credit;

    /**
     * 购货达标额
     */
    @Column(name = "purchase_amount")
    private long purchaseAmount;

    /**
     * z折扣
     */
    @Column(name = "discount1")
    private int discount1;

    /**
     * 折扣2
     */
    @Column(name = "discount2")
    private int discount2;

    /**
     * 折扣3
     */
    @Column(name = "discount3")
    private int discount3;

    /**
     * 所属渠道
     */
    @Column(name = "channel_id")
    private Long channelId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getDiscount1() {
        return discount1;
    }

    public void setDiscount1(int discount1) {
        this.discount1 = discount1;
    }

    public int getDiscount2() {
        return discount2;
    }

    public void setDiscount2(int discount2) {
        this.discount2 = discount2;
    }

    public int getDiscount3() {
        return discount3;
    }

    public void setDiscount3(int discount3) {
        this.discount3 = discount3;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
}
