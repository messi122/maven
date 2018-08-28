package cn.comico.set;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ParamsConfig
 * @Description TODO
 * @date 2018/7/23 10:54
 **/
@Entity
@Table(name = "t_params_config")
public class ParamsConfig implements Serializable {

    private static final long serialVersionUID = 7545648206211425323L;

    @Id
    @Column(name = "[key]")
    private String key;

    @Column(name = "[group]")
    private String group;

    @Column(name = "name")
    private String name;

    @Column(name = "[value]")
    private String value;

    @Column(name = "remark")
    private String remark;

    @Version
    private Long version;       //乐观锁

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
