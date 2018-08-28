package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PurchaseDetail
 * @Description TODO
 * @date 2018/7/24 13:39
 **/
@Entity
@Table(name = "t_purchase_detail")
public class PurchaseDetail implements Serializable {

    private static final long serialVersionUID = -633287577617467689L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 采购单编号
     */
    @Column(name = "purchase_id")
    private String purchaseId;

    /**
     * 产品条码
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 吊牌价
     */
    @Column(name = "dp_price")
    private int dpPrice;

    /**
     * 数量
     */
    @Column(name = "num")
    private int num;

    /**
     * 计划时间
     */
    @Column(name = "plan_date")
    private Date planDate;

    /**
     * 原数量
     */
    @Column(name = "old_num")
    private int oldNum;

    /**
     * 原计划时间
     */
    @Column(name = "old_plan_date")
    private Date oldPlanDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getDpPrice() {
        return dpPrice;
    }

    public void setDpPrice(int dpPrice) {
        this.dpPrice = dpPrice;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public int getOldNum() {
        return oldNum;
    }

    public void setOldNum(int oldNum) {
        this.oldNum = oldNum;
    }

    public Date getOldPlanDate() {
        return oldPlanDate;
    }

    public void setOldPlanDate(Date oldPlanDate) {
        this.oldPlanDate = oldPlanDate;
    }
}
