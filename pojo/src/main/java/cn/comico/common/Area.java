package cn.comico.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Area
 * @Description TODO
 * @date 2018/6/22 11:14
 **/
@Entity
@Table(name = "t_area")
public class Area implements Serializable {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
