package cn.comico.supply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Sorting
 * @Description TODO
 * @Author LuckyQi
 * @Date 2018/8/2 13:36
 * @Version 1.0
 */
@Entity
@Table(name = "t_sorting")
public class Sorting implements Serializable {


    public static final int SHPO_OUT_NOT_CONFIRM = 0;                   //市场未确认

    public static final int TYPE_MARKETDEPLOY = 0;                      //市场调配
    public static final int TYPE_HQDEPLOY = 1;                          //本地配货



    private static final long serialVersionUID = 6257640723575037411L;

    public static final int STATUS_NOT_SUBMIT = 0;                      //待提交调出方确认
    public static final int STATUS_AWAIT_EXPORT_VERIFY = 1;             //待调出方确认
    public static final int STATUS_NEED_REVAMP = 2;                     //待修改
    public static final int STATUS_AWAIT_VERIFY = 3;                    //待确认
    public static final int STATUS_ALREADY_VERIFY = 4;                  //已确认
    public static final int STATUS_AWAIT_RECEIVE = 5;                   //待收货
    public static final int STATUS_ALREADY_ACHIEVE = 6;                 //已完成
    public static final int STATUS_ALREADY_FINISH = 7;                  //已终止

    public static final int STATUS_THREE_LEVEL_VERIFY = 34;             //三级确认
    public static final int STATUS_TWO_LEVEL_VERIFY = 24;               //二级确认

    @Id
    private String id;

    @Column(name = "plan_id")
    private String planId;

    @Column(name = "purchase_id")
    private String purchaseId;

    @Column(name = "`type`")
    private Integer type;

    @Column(name = "`from`")
    private Long from;

    @Column(name = "`to`")
    private Long to;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "operator")
    private Long operator;

    @Column(name = "status")
    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
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
