package cn.comico.store;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description:
 * @ClassName: cn.comico.erp.pojo.store
 * @Author: yuyong
 * @CreateDate: 2018/8/20 18:33
 * @UpdateUser:
 * @UpdateDate: 2018/8/20 18:33
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name = "t_transfer_detail")
public class TransferDetail implements Serializable {
    private static final long serialVersionUID = -3763188603153855936L;
    /**
     * CREATE TABLE `t_transfer_detail` (
     *   `id` bigint(20) NOT NULL AUTO_INCREMENT,
     *   `transfer_id` varchar(32) NOT NULL COMMENT '转仓单号',
     *   `product_id` bigint(20) NOT NULL COMMENT '产品ID',
     *   `rfid` varchar(32) DEFAULT '' COMMENT '产品RFID',
     *   `mark` tinyint(4) DEFAULT '0' COMMENT '标记（0-无、1-人为损坏、2-质量问题）',
     *   `desc` varchar(256) DEFAULT '' COMMENT '描述',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 转仓单号
     */
    @Column(name = "transfer_id")
    private String transferId;

    /**
     * 产品ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 产品RFID
     */
    @Column(name = "rfid")
    private String rfid;

    /**
     * 标记（0-无、1-人为损坏、2-质量问题）
     */
    @Column(name = "mark")
    private Integer mark;

    /**
     * 描述
     */
    @Column(name = "desc")
    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
