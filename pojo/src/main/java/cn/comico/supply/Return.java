package cn.comico.supply;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:退货单
 * @ClassName: cn.comico.erp.pojo.supply
 * @Author: yuyong
 * @CreateDate: 2018/7/26 11:25
 * @UpdateUser:
 * @UpdateDate: 2018/7/26 11:25
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name="t_return")
public class Return implements Serializable {
    private static final long serialVersionUID = -6205072270356863741L;

    public static final int STATUS_GZ_NOT_CONFIRM = 0;                  //总部待确认
    public static final int STATUS_AGENT_NOT_DELIVERY=1;                //代理待出库
    public static final int STATUS_AGENT_ING_DELIVERY=2;                //代理待发货
    public static final int STATUS_GZ_NOT_CHECK = 3;                    //仓库待质检(待收货)
    public static final int STATUS_GZ_NOT_STORAGE = 4;                  //仓库待入库(待收货)
    public static final int STATUS_GZ_MARKET_SURE = 5;                  //已完成

    public static final int STATUS_FIRST_NOT_SUBMIT = 10;               //一级待提交
    public static final int STATUS_FIRST_NOT_CHECK = 11;                //一级待审核
    public static final int STATUS_FIRST_NOT_PASS = 12;                 //一级被驳回

    public static final int STATUS_SECOND_NOT_SUBMIT = 20;              //二级待提交
    public static final int STATUS_SECOND_NOT_CHECK = 21;               //二级待审核
    public static final int STATUS_SECOND_NOT_PASS = 22;                //二级被驳回

    public static final int STATUS_THIRD_NOT_SUBMIT = 30;               //三级待提交
    public static final int STATUS_THIRD_NOT_CHECK = 31;                //三级待审核
    public static final int STATUS_THIRD_NOT_PASS = 32;                 //三级被驳回

    public static final int SAVE_AND_SUBMIT = 1;                        //保存并提交
    public static final int CHECK_AGREE =0;                             //审核通过


    public static final int AGENT_NEW_RETURN =0;                             //新退货单
    public static final int RETURN_CHECKING =1;                               //审核中
    public static final int SUPPLY_CONFIRM =2;                               //供应确认
    public static final int STORE_OUT_ING =3;                                    //待出库
    public static final int RETURNING =4;                             //退货中(待发货、待收货(待质检和待入库))


    @Id
    private String id;

    /**
     * 退货类型(0-正常退货,1-虚拟退货)
     */
    @Column(name="type", columnDefinition = "tinyint")
    private Integer type;

    /**
     * 退货原因(0-质量问题、1-滞销、2-扫描识别问题、3-市场调货、4-其它)
     */
    @Column(name="reason")
    private Long reason;

    /**
     * 退货渠道
     */
    @Column(name="`from`")
    private Long from;

    /**
     * 收货渠道
     */
    @Column(name="`to`")
    private Long to;

    /**
     * 备注
     */
    @Column(name="remark")
    private String remark;

    /**
     * 配货单号
     */
    @Column(name = "sorting_id")
    private String sortingId;

    /**
     * 下单者
     */
    @Column(name="operator")
    private Long operator;

    /**
     * 下单日期
     */
    @Column(name="create_date")
    private Date createDate;

    /**
     * 退货单状态(0-待提交、1-已提交审核、2-被驳回、3-审核通过 、4-已确认、5-已完成)
     */
    @Column(name="status", columnDefinition = "tinyint")
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

    public Long getReason() {
        return reason;
    }

    public void setReason(Long reason) {
        this.reason = reason;
    }

    public Long getFrom() {
        return from;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSortingId() {
        return sortingId;
    }

    public void setSortingId(String sortingId) {
        this.sortingId = sortingId;
    }
}
