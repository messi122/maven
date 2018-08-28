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
 * @ClassName Plan
 * @Description TODO
 * @date 2018/7/24 13:46
 **/
@Entity
@Table(name = "t_plan")
public class Plan implements Serializable {

    private static final long serialVersionUID = -5198020416622937728L;

    public static final int PLAN_TYPE_GZ =1;        //计划单类型(0-一级渠道、1-总部)

    public static final int PLAN_TYPE_CHANNEL =0;   //计划单类型(0-一级渠道、1-总部)

    /**
     * 未提交市场确认(0-未提交确认、1-提交待审核、2-审核驳回、3-审核通过待市场确认、4-市场已确认、5-本体已确认、6-来货完成、7-配货完成)
     */
    public static final int STATUS_MARKET_NOT_CONFIRM = 0;

    public static final int STATUS_SUBMIT_CHECKING=1;

    public static final int STATUS_CHECK_NOT_PASS =2;

    public static final int STATUS_MARKET_CONFIRMING =3;

    public static final int STATUS_MARKET_CONFIRMED =4;

    public static final int STATUS_GUANGZHOU_CONFIRMED =5;

    public static final int STATUS_DELIVERY_PRODUCT_COMPLETE=6;

    public static final int STATUS_SORTING_PRODUCT_COMPLETE=7;


    @Id
    private String id;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

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
     * 类型
     */
    @Column(name = "type", columnDefinition = "tinyint")
    private int type;

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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
