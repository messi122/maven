package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_shop_out_detail")
public class ShopOutDetail implements Serializable {

    private static final long serialVersionUID = 7209503298014159431L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 调货单号
     */
    @Column(name = "shop_out_id")
    private String shopOutId;

    /**
     * 调货量
     */
    @Column(name = "num")
    private Integer num;

    /**
     * 货品
     */
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "dp_price")
    private Integer dpPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopOutId() {
        return shopOutId;
    }

    public void setShopOutId(String shopOutId) {
        this.shopOutId = shopOutId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getDpPrice() {
        return dpPrice;
    }

    public void setDpPrice(Integer dpPrice) {
        this.dpPrice = dpPrice;
    }
}
