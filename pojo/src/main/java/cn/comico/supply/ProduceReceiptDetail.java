package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ProduceReceiptDetail
 * @Description TODO    生产入库详情
 * @date 2018/8/9 16:49
 **/
@Entity
@Table(name = "t_produce_receipt_detail")
public class ProduceReceiptDetail implements Serializable {

    private static final long serialVersionUID = -7632261678834992545L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 生产入库单ID
     */
    @Column(name = "produce_receipt_id")
    private String produceReceiptId;

    /**
     * 计划生产ID
     */
    @Column(name = "plan_produce_id")
    private Long planProduceId;

    /**
     * 产品ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 产品数量
     */
    @Column(name = "num")
    private int num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduceReceiptId() {
        return produceReceiptId;
    }

    public void setProduceReceiptId(String produceReceiptId) {
        this.produceReceiptId = produceReceiptId;
    }

    public Long getPlanProduceId() {
        return planProduceId;
    }

    public void setPlanProduceId(Long planProduceId) {
        this.planProduceId = planProduceId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
