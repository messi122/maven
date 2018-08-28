package cn.comico.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Province
 * @Description TODO
 * @date 2018/6/22 11:16
 **/
@Entity
@Table(name = "t_province")
public class Province implements Serializable {

    @Id
    private Long id;

    /**
     * 区域
     */
    @Column(name = "area_id")
    private Long areaId;

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

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
