package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ProduceReceiptRecord
 * @Description TODO
 * @date 2018/8/9 16:55
 **/
@Entity
@Table(name = "t_produce_receipt_record")
public class ProduceReceiptRecord implements Serializable {

    private static final long serialVersionUID = -2387492674111516537L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 入库单编号
     */
    @Column(name = "produce_receipt_id")
    private String produceReceiptId;

    /**
     * 产品编号
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * RFID
     */
    @Column(name = "rfid")
    private String rfid;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }
}
