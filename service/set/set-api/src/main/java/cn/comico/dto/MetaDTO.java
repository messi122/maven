package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName MetaDTO
 * @Description TODO
 * @date 2018/6/25 16:15
 **/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MetaDTO implements Serializable {

    private String title;

    private String icon;

    private List<String> permission;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

}
