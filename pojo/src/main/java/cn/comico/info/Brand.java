package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Brand
 * @Description TODO
 * @date 2018/6/22 10:24
 **/
@Entity
@Table(name = "t_brand")
public class Brand implements Serializable {

    public static final int ENABLE          = 0;        //启用
    public static final int DISABLE         = 1;        //禁用

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * logo
     */
    @Column(name = "logo")
    private String logo;

    /**
     * 简介
     */
    @Column(name = "[desc]")
    private String desc;

    /**
     * 状态
     */
    @Column(name = "status", columnDefinition = "tinyint")
    private int status;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
