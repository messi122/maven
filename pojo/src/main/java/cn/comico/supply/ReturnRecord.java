package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @ClassName: cn.comico.erp.pojo.supply
 * @Author: yuyong
 * @CreateDate: 2018/8/2 11:12
 * @UpdateUser:
 * @UpdateDate: 2018/8/2 11:12
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name="t_return_record")
public class ReturnRecord implements Serializable {
    private static final long serialVersionUID = -9136966119675915788L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 退货详情单Id
     */
    @Column(name="return_detail_id")
    private Long returnDetailId;

    /**
     * 货品Id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 是否为次品(0-次品，1-非次品)
     */
    @Column(name = "is_defect")
    private Long isDefect;

    /**
     * 详细描述
     */
    @Column(name = "`desc`")
    private String description;

    /**
     * 问题RFID
     */
    @Column(name = "rfid")
    private String RFId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReturnDetailId() {
        return returnDetailId;
    }

    public void setReturnDetailId(Long returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getIsDefect() {
        return isDefect;
    }

    public void setIsDefect(Long isDefect) {
        this.isDefect = isDefect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRFId() {
        return RFId;
    }

    public void setRFId(String RFId) {
        this.RFId = RFId;
    }
}
