package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ChannelPurchase
 * @Description TODO
 * @date 2018/7/10 15:32
 **/
@Entity
@Table(name = "t_channel_purchase")
public class ChannelPurchase implements Serializable {

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
    private Integer credit;

    /**
     * 购货达标额
     */
    @Column(name = "purchase_amount")
    private Long purchaseAmount;

    /**
     * 折扣
     */
    @Column(name = "discount1")
    private Integer discount1;

    /**
     * 临时折扣
     */
    @Column(name = "discount2")
    private Integer discount2;

    /**
     * 购货使用折扣
     */
    @Column(name = "discount3")
    private String discount3;

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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Integer getDiscount1() {
        return discount1;
    }

    public void setDiscount1(Integer discount1) {
        this.discount1 = discount1;
    }

    public Integer getDiscount2() {
        return discount2;
    }

    public void setDiscount2(Integer discount2) {
        this.discount2 = discount2;
    }

    public String getDiscount3() {
        return discount3;
    }

    public void setDiscount3(String discount3) {
        this.discount3 = discount3;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
}
