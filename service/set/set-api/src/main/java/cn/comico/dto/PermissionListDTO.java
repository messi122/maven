package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionListDTO
 * @Description TODO
 * @date 2018/6/25 13:57
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionListDTO implements Serializable {

    private Long permissionId;

    private String permission;

    private List<PermissionManagerDTO> managerList;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<PermissionManagerDTO> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<PermissionManagerDTO> managerList) {
        this.managerList = managerList;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
