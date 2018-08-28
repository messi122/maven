package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Store
 * @Description TODO
 * @date 2018/7/6 11:12
 **/
@Entity
@Table(name = "t_store")
public class Store implements Serializable {

    public static final int TYPE_CHANNEL    = 0;
    public static final int TYPE_COMPANY    = 1;

    public static final int ENABLE_DEL      = 0;    //可删
    public static final int DISABLE_DEL     = 1;    //不可删

    public static final int STATUS_ENABLE   = 0;
    public static final int STATUS_DISABLE  = 1;

    public static final long COMPANY_ID     = 1;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 用途
     */
    @Column(name = "useage")
    private String useage;

    /**
     * 地址
     */
    @Column(name = "address")
    private String address;

    /**
     * 联系人
     */
    @Column(name = "linkman")
    private String linkman;

    /**
     * 联系人电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 类型（1-公司仓库、0-渠道仓库）
     */
    @Column(name = "type", columnDefinition = "tinyint")
    private int type;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 渠道ID
     */
    @Column(name = "channel_id")
    private Long channelId;

    /**
     * 是否可删
     */
    @Column(name = "is_delete", columnDefinition = "tinyint")
    private int isDelete;

    /**
     * 状态
     */
    @Column(name = "status", columnDefinition = "tinyint")
    private int status;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUseage() {
        return useage;
    }

    public void setUseage(String useage) {
        this.useage = useage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
