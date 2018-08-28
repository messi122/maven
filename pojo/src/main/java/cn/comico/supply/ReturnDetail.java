package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @ClassName: cn.comico.erp.pojo.supply
 * @Author: yuyong
 * @CreateDate: 2018/7/26 11:37
 * @UpdateUser:
 * @UpdateDate: 2018/7/26 11:37
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name="t_return_detail")
public class ReturnDetail implements Serializable {
    private static final long serialVersionUID = 5337140869678761214L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 退货单Id
     */
    @Column(name="return_id")
    private String returnId;

    /**
     * 吊牌价
     */
    @Column(name="dp_price")
    private Integer dpPrice;

    /**
     * 退货价
     */
    @Column(name="return_price")
    private Integer returnPrice;

    /**
     * 货品数量
     */
    @Column(name = "num")
    private Integer num;

    /**
     * 商品Id
     */
    @Column(name="product_id")
    private Long productId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public Integer getDpPrice() {
        return dpPrice;
    }

    public void setDpPrice(Integer dpPrice) {
        this.dpPrice = dpPrice;
    }

    public Integer getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(Integer returnPrice) {
        this.returnPrice = returnPrice;
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
}
