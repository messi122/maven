package cn.comico.dto;

import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetMarketSortDTO
 * @Description TODO
 * @date 2018/7/3 18:25
 **/
public class SetMarketSortDTO implements Serializable {

    private Long id;

    private Integer type;

    private Integer data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
