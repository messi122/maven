package cn.comico.supply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_shop_out")
public class ShopOut implements Serializable {

    private static final long serialVersionUID = 6028042685668274153L;
    @Id
    private String id;

    /**
     * 类型
     */
    @Column(name = "type", columnDefinition = "tinyint")
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
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 下单人
     */
    @Column(name = "operator")
    private Long operator;

    /**
     * 状态（0-待提交、1-待审核、1-被驳回、2-已审核待调出、3-已调出待收、4-已完成）
     */
    @Column(name = "status", columnDefinition = "tinyint")
    private Integer status;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
