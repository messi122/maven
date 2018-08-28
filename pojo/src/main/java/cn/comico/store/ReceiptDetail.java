package cn.comico.store;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @ClassName: cn.comico.erp.pojo.store
 * @Author: yuyong
 * @CreateDate: 2018/8/24 18:16
 * @UpdateUser:
 * @UpdateDate: 2018/8/24 18:16
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name = "t_receipt")
public class ReceiptDetail implements Serializable {
    private static final long serialVersionUID = -6208112350833275403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "receipt_id")
    private String receiptId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "num")
    private Integer num;


    @Column(name = "dp_price")
    private Integer dpPrice;

    @Column(name = "sale_price")
    private Integer salePrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDpPrice() {
        return dpPrice;
    }

    public void setDpPrice(Integer dpPrice) {
        this.dpPrice = dpPrice;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
    }
}
