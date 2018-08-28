package cn.comico.set;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetMarketSale
 * @Description TODO
 * @date 2018/7/3 17:50
 **/
@Entity
@Table(name = "t_set_market_sale")
public class SetMarketSale implements Serializable {

    public static final int TYPE_HOT            = 0;    //热销
    public static final int TYPE_NORMAL         = 1;    //平销
    public static final int TYPE_COLD           = 2;    //滞销

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "week_num")
    private Integer weekNum;

    @Column(name = "week_sale")
    private Integer weekSale;

    @Column(name = "type", columnDefinition = "tinyint")
    private Integer type;

    @Column(name = "update_date")
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public Integer getWeekSale() {
        return weekSale;
    }

    public void setWeekSale(Integer weekSale) {
        this.weekSale = weekSale;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
