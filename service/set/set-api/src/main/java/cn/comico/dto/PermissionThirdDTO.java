package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionThirdDTO
 * @Description TODO
 * @date 2018/6/25 14:01
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionThirdDTO implements Serializable {

    private Long id;

    private String name;

    private List<PermissionListDTO> permissionList;

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

    public List<PermissionListDTO> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionListDTO> permissionList) {
        this.permissionList = permissionList;
    }
}
