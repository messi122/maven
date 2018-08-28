package cn.comico.store;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Description:
 * @ClassName: cn.comico.erp.pojo.store
 * @Author: yuyong
 * @CreateDate: 2018/8/27 13:46
 * @UpdateUser:
 * @UpdateDate: 2018/8/27 13:46
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public class ShotPutDetail implements Serializable {
    private static final long serialVersionUID = 7483136275032551194L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_put_id")
    private String shopOutId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "num")
    private Integer num;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
