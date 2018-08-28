package cn.comico.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetAdjustionDTO
 * @Description TODO
 * @date 2018/7/3 18:18
 **/
public class SetAdjustionDTO implements Serializable {

    private Long id;

    private Integer weekNum;

    private Integer weekSale;

    private Integer ableSaleWeek;

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
