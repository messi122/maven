package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionDTO
 * @Description TODO
 * @date 2018/6/25 13:37
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionDTO {

    private Long id;

    private String nmae;

    private String icon;

    private String children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmae() {
        return nmae;
    }

    public void setNmae(String nmae) {
        this.nmae = nmae;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
