package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Style
 * @Description TODO
 * @date 2018/7/13 15:19
 **/
@Entity
@Table(name = "t_style")
public class Style implements Serializable {

    private static final long serialVersionUID = -5531366015893014222L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "style")
    private String style;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
