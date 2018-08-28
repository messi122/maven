package cn.comico.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @ClassName: cn.comico.erp.pojo.store
 * @Author: yuyong
 * @CreateDate: 2018/8/24 18:03
 * @UpdateUser:
 * @UpdateDate: 2018/8/24 18:03
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name = "t_receipt")
public class Receipt implements Serializable {
    private static final long serialVersionUID = -7362942710043116341L;
    /**
     * 0-本地调货、1-供应配货、2-虚拟调货、3-虚拟退货、4-虚拟配货、5-退货
     */
    public static final int TYPE_LOCAL_DELIVERY=0;
    public static final int TYPE_SUPPLY_SORTING=1;
    public static final int TYPE_VIRTUAL_SORTING=2;
    public static final int TYPE_VIRTUAL_RETURN=3;
    public static final int TYPE_VIRTUAL_DELIVERY=4;
    public static final int TYPE_RETURN_STORE=5;

    public static final int LEVEL_GZ =0;
    public static final int LEVEL_AGENT =1;
    public static final int LEVEL_SHOP =2;

    public static final int STATUS_CONFIRMING =0;
    public static final int STATUS_COMPLETED =1;


    @Id
    private String id;

    /**
     * 类型(0-本地调货、1-供应配货、2-虚拟调货、3-虚拟退货、4-虚拟配货、5-退货)
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 调出方
     */
    @Column(name = "`from`")
    private Long from;

    /**
     * 调入方
     */
    @Column(name = "`to`")
    private Long to;

    /**
     * 调出仓库
     */
    @Column(name = "from_store")
    private Long fromStore;

    /**
     * 调入仓库
     */
    @Column(name = "to_store")
    private Long toStore;

    /**
     * 创建者
     */
    @Column(name = "creator")
    private Long creator;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 操作者
     */
    @Column(name = "operator")
    private Long operator;


    /**
     * 备注单号
     */
    @Column(name = "remark_no")
    private String remarkNo;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 状态(0-待入库、1-已完成)
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 完成时间
     */
    @Column(name = "complete_date")
    private Date completeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemarkNo() {
        return remarkNo;
    }

    public void setRemarkNo(String remarkNo) {
        this.remarkNo = remarkNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Long getFromStore() {
        return fromStore;
    }

    public void setFromStore(Long fromStore) {
        this.fromStore = fromStore;
    }

    public Long getToStore() {
        return toStore;
    }

    public void setToStore(Long toStore) {
        this.toStore = toStore;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

}



