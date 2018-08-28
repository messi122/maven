package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Workshop
 * @Description TODO 生产车间
 * @date 2018/7/11 14:28
 **/
@Entity
@Table(name = "t_workshop")
public class Workshop implements Serializable {

    public static final int TYPE_INNER = 0; //内部
    public static final int TYPE_OUTER = 1; //外发

    public static final int STATUS_ENABLE       = 0;    //启用
    public static final int STATUS_DISABLE      = 1;    //禁用

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "type", columnDefinition = "tinyint")
    private Integer type;

    @Column(name = "linkman")
    private String linkman;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status", columnDefinition = "tinyint")
    private Integer status;

    @Column(name = "address")
    private String address;

    @Column(name = "remark")
    private String remark;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static int getTypeInner() {
        return TYPE_INNER;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
