package cn.comico.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionFirstDTO
 * @Description TODO
 * @date 2018/6/28 13:54
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionFirstDTO implements Serializable {

    private Long id;

    private String icon;

    private String name;

    private List<PermissionDetailDTO> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PermissionDetailDTO> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionDetailDTO> children) {
        this.children = children;
    }
}
