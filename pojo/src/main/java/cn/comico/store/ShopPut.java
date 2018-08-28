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
 * @CreateDate: 2018/8/27 13:46
 * @UpdateUser:
 * @UpdateDate: 2018/8/27 13:46
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name = "t_shop_put")
public class ShopPut implements Serializable {

    private static final long serialVersionUID = 2150996902408748635L;

    /**
     * 0-本地调货,1-销售退货
     */
    public static final int TYPE_LOCAL_DELIVERY=0;
    public static final int TYPE_SALE_RETURN=1;

    @Id
    private String id;

    @Column(name = "type")
    private Integer type;

    @Column(name ="`from`")
    private Long from;

    @Column(name = "`to`")
    private Long to;

    @Column(name = "creator")
    private Long creator;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "remark")
    private String remark;

    /**
     * 备注单号
     */
    @Column(name = "remark_no")
    private String remarkNo;

    /**
     * 操作者
     */
    @Column(name = "operator")
    private Long operator;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemarkNo() {
        return remarkNo;
    }

    public void setRemarkNo(String remarkNo) {
        this.remarkNo = remarkNo;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}
