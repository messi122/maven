package cn.comico.info;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ProductModifyRecord
 * @Description TODO
 * @date 2018/7/16 19:12
 **/
@Entity
@Table(name = "t_product_modify_record")
public class ProductModifyRecord implements Serializable {

    private static final long serialVersionUID = -8833372309810554528L;

    public static final String EVENT_CODE_PRODUCT_ADD              = "00";      //保存
    public static final String EVENT_CODE_PRODUCT_NOT_PASS         = "01";       //审核不通过
    public static final String EVENT_CODE_PRODUCT_PASS             = "02";      //审核通过
    public static final String EVENT_CODE_PRODUCT_UPDATE           = "03";      //产品修改
    public static final String EVENT_CODE_PRODUCT_ADD_PRICE        = "04";       //添加价格
    public static final String EVENT_CODE_PRODUCT_UPDATE_PRICE     = "05";      //更新价格
    public static final String EVENT_CODE_PRODUCT_PRICE_NOT_PASS   = "06";          //价格审核不通过
    public static final String EVENT_CODE_PRODUCT_PRICE_PASS       = "07";      //价格审核通过
    public static final String EVENT_CODE_PRODUCT_ENABLE           = "08";      //产品在产
    public static final String EVENT_CODE_PRODUCT_DISABLE          = "09";      //产品停产


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "content")
    private String content;

    @Column(name = "eventCode")
    private String eventCode;

    @Column(name = "create_date")
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
