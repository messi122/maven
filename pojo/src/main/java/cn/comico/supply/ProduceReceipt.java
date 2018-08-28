package cn.comico.supply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ProduceReceipt
 * @Description TODO    生产入库
 * @date 2018/8/9 16:36
 **/
@Entity
@Table(name = "t_produce_receipt")
public class ProduceReceipt implements Serializable {

    private static final long serialVersionUID = -3101526767276987461L;

    public static final int STATUS_NOT_SUBMIT       = 0;    //未提交
    public static final int STATUS_NOT_INPUT        = 1;    //未录入
    public static final int STATUS_INPUT_NOT_PASS   = 2;    //录入不通过
    public static final int STATUS_INPUT_CONFIRM    = 3;    //录入确认
    public static final int STATUS_RECEIPT_NOT_PASS = 4;    //入库不通过
    public static final int STATUS_RECEIPT_CONFIRM  = 5;    //入库确认

    @Id
    private String id;

    /**
     * 创建人
     */
    @Column(name = "[operator]")
    private Long operator;

    /**
     * 创建时间
     */
    @Column(name = "createDate")
    private Date createDate;

    /**
     * 生产单位
     */
    @Column(name = "workshop_id")
    private Long workshopId;

    /**
     * 状态
     */
    @Column(name = "status", columnDefinition = "tinyint")
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(Long workshopId) {
        this.workshopId = workshopId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
