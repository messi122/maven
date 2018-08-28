package cn.comico.dto;

import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ParamsConfigDTO
 * @Description TODO
 * @date 2018/7/23 14:10
 **/
public class ParamsConfigDTO implements Serializable {

    private String key;

    private String group;

    private String name;

    private String value;

    private String remark;

    private Long version;

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
