package cn.comico.info;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Color
 * @Description TODO
 * @date 2018/7/13 15:07
 **/
@Entity
@Table(name = "t_color")
public class Color implements Serializable {

    private static final long serialVersionUID = 205722063008900709L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "color")
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
