package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Category
 * @Description TODO
 * @date 2018/7/13 15:05
 **/
@Entity
@Table(name = "t_category")
public class Category implements Serializable {

    private static final long serialVersionUID = -183680675472226158L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
