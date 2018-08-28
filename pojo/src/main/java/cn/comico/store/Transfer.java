package cn.comico.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @ClassName: cn.comico.erp.pojo.store
 * @Author: yuyong
 * @CreateDate: 2018/8/20 18:21
 * @UpdateUser:
 * @UpdateDate: 2018/8/20 18:21
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Entity
@Table(name = "t_transfer")
public class Transfer implements Serializable {
    private static final long serialVersionUID = 3710355338513968346L;

    @Id
    private String id;

    /**
     * 转仓单状态:0-待确认,1-已完成
     */
    public static  final  int  STATUS_TRANSFER_CONFIRMING=0;

    public static  final  int  STATUS_TRANSFER_COMPLETE=1;

    /**
     * 数量
     */
    @Column(name = "num")
    private Integer num;

    /**
     * 调出仓库
     */
    @Column(name = "`from`")
    private Long from;

    /**
     * 调入仓库
     */
    @Column(name = "`to`")
    private Long to;

    /**
     * 下单者
     */
    @Column(name = "creator")
    private Long creator;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;


    /**
     * 完成时间
     */
    @Column(name = "complete_date")
    private Date completeDate;

    /**
     * 状态(0-待确认,1-已完成)
     */
    @Column(name = "status")
    private Integer status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}
