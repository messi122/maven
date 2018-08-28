package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Skil
 * @Description TODO
 * @date 2018/7/13 15:29
 **/
@Entity
@Table(name = "t_skil")
public class Skil implements Serializable {
    private static final long serialVersionUID = 2526384810491731449L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skil")
    private String skil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkil() {
        return skil;
    }

    public void setSkil(String skil) {
        this.skil = skil;
    }
}
