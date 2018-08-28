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
 * @ClassName Purchase
 * @Description TODO
 * @date 2018/7/24 13:31
 **/
@Entity
@Table(name = "t_purchase")
public class Purchase implements Serializable {

    private static final long serialVersionUID = 6804933343366754435L;

    public static final int STATUS_GZ_NOT_SUBMIT = 0;                   //总部待提交
    public static final int STATUS_GZ_NOT_CHECK = 1;                    //待审核
    public static final int STATUS_GZ_NOT_PASS = 2;                     //被驳回
    public static final int STATUS_GZ_PASS = 3;                         //审核通过
    public static final int STATUS_GZ_MARKET_NOT_SURE = 4;              //改动待市场确认
    public static final int STATUS_GZ_MARKET_SURE = 5;                  //已确认
    public static final int STATUS_GZ_NOT_SORTING = 6;                  //未配完
    public static final int STATUS_GZ_SORTING = 7;                      //已配完

    public static final int STATUS_FIRST_NOT_SUBMIT = 10;               //一级待提交
    public static final int STATUS_FIRST_NOT_CHECK = 11;                //一级待审核
    public static final int STATUS_FIRST_NOT_PASS = 12;                 //一级被驳回

    public static final int STATUS_SECOND_NOT_SUBMIT = 20;              //二级待提交
    public static final int STATUS_SECOND_NOT_CHECK = 21;               //二级待审核
    public static final int STATUS_SECOND_NOT_PASS = 22;                //二级被驳回

    public static final int STATUS_THIRD_NOT_SUBMIT = 30;               //三级待提交
    public static final int STATUS_THIRD_NOT_CHECK = 31;                //三级待审核
    public static final int STATUS_THIRD_NOT_PASS = 32;                 //三级被驳回

    public static final int CHECK_PASS = 0;                             //审核通过
    public static final int CHECK_NOT_PASS = 1;                         //审核不通过

    public static final int CHANNEL_ID_GZ_MARKET = 1;                   //总部的渠道ID


    @Id
    private String id;

    /**
     * 计划单号
     */
    @Column(name = "plan_id")
    private String planId;

    /**
     * 创建人
     */
    @Column(name = "operator")
    private Long operator;

    /**
     * 渠道编号
     */
    @Column(name = "channel_id")
    private Long channelId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

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

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
