package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ManagerPermissionDTO
 * @Description TODO
 * @date 2018/6/26 18:52
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagerPermissionDTO implements Serializable {

    public static final int ADD = 1;
    public static final int DEL = 0;

    private Long permissionId;

    private Long userId;

    private int type;               //0-删除、1-增加

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
