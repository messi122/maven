package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Season
 * @Description TODO
 * @date 2018/7/20 16:48
 **/
@Entity
@Table(name = "t_season")
public class Season implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "season")
    private String season;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
