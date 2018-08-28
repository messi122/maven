package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionManagerDTO
 * @Description TODO
 * @date 2018/6/25 13:55
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionManagerDTO implements Serializable {

    private Long userId;

    private String username;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
