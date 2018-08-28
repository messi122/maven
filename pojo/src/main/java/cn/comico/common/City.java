package cn.comico.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName City
 * @Description TODO
 * @date 2018/6/22 11:19
 **/
@Entity
@Table(name = "t_city")
public class City implements Serializable {

    @Id
    private Long id;

    /**
     * 所属省
     */
    @Column(name = "province_id")
    private Long provinceId;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
