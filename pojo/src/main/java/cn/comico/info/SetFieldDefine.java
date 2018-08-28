package cn.comico.info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetFieldDefine
 * @Description TODO
 * @date 2018/7/16 18:59
 **/
@Entity
@Table(name = "t_set_field_define")
public class SetFieldDefine implements Serializable {

    private static final long serialVersionUID = -586735381736801965L;

    public static final int INPUT   = 0;        //输入
    public static final int SELECT  = 1;        //可选


    /**
     * 字段
     */
    @Id
    private String field;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 是否选择（0-输入、1-选择）
     */
    @Column(name = "is_select", columnDefinition = "tinyint")
    private int isSelect;


    @Column(name = "remark")
    private String remark;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(int isSelect) {
        this.isSelect = isSelect;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
