package cn.comico.set;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetAdjustion
 * @Description TODO
 * @date 2018/7/3 18:01
 **/
@Entity
@Table(name = "t_set_adjustion")
public class SetAdjustion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "week_num")
    private Integer weekNum;

    @Column(name = "week_sale")
    private Integer weekSale;

    @Column(name = "able_sale_week")
    private Integer ableSaleWeek;

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

    public Integer getAbleSaleWeek() {
        return ableSaleWeek;
    }

    public void setAbleSaleWeek(Integer ableSaleWeek) {
        this.ableSaleWeek = ableSaleWeek;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
