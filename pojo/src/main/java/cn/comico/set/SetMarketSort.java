package cn.comico.set;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetMarketSort
 * @Description TODO
 * @date 2018/7/3 18:05
 **/
@Entity
@Table(name = "t_set_market_sort")
public class SetMarketSort implements Serializable {

    public static final int TYPE_BH     = 0;        //补货
    public static final int TYPE_PH     = 1;        //配货

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", columnDefinition = "tinyint")
    private Integer type;

    @Column(name = "[data]")
    private Integer data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
