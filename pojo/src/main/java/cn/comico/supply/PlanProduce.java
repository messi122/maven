package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PlanProduce
 * @Description TODO
 * @date 2018/7/24 13:55
 **/
@Entity
@Table(name = "t_plan_produce")
public class PlanProduce implements Serializable {

    public static final int SAVE_AND_CONFIRM =1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 计划单编号
     */
    @Column(name = "plan_id")
    private String planId;

    /**
     * 产品编号
     */
    @Column(name = "product_id")
    private Long product_id;

    /**
     *库存配货数
     */
    @Column(name = "stock_sort_num")
    private int stockSortNum;

    /**
     *在产配货数
     */
    @Column(name = "producing_sort_num")
    private int producingSortNum;

    /**
     * 生产数
     */
    @Column(name = "num")
    private int num;

    /**
     * 计划时间
     */
    @Column(name = "plan_date")
    private Date planDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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

    public int getStockSortNum() {
        return stockSortNum;
    }

    public void setStockSortNum(int stockSortNum) {
        this.stockSortNum = stockSortNum;
    }

    public int getProducingSortNum() {
        return producingSortNum;
    }

    public void setProducingSortNum(int producingSortNum) {
        this.producingSortNum = producingSortNum;
    }
}
