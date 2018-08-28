package cn.comico.supply;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName SortingDetail
 * @Description TODO
 * @Author LuckyQi
 * @Date 2018/8/2 13:53
 * @Version 1.0
 */
@Entity
@Table(name = "t_sorting_detail")
public class SortingDetail implements Serializable {

    private static final long serialVersionUID = 392453077994843057L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sorting_id")
    private String sortingId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "num")
    private Integer num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSortingId() {
        return sortingId;
    }

    public void setSortingId(String sortingId) {
        this.sortingId = sortingId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
