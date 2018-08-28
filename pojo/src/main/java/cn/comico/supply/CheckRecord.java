package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName CheckRecord
 * @Description TODO
 * @date 2018/7/27 10:14
 **/
@Entity
@Table(name = "t_check_record")
public class CheckRecord implements Serializable {

    private static final long serialVersionUID = 2325573971191447311L;

    public static final int TYPE_PURCHASE   = 0;    //采购单
    public static final int TYPE_SORTING    = 1;    //配货单
    public static final int TYPE_RETURN     = 2;    //退货单
    public static final int TYPE_RECEIPT    = 3;    //入库单
    public static final int TYPE_PLAN_PRODUCE = 4;  //计划生产单

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 单号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 创建人
     */
    @Column(name = "operator")
    private Long operator;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 类型
     */
    @Column(name = "type", columnDefinition = "tinyint")
    private int type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
