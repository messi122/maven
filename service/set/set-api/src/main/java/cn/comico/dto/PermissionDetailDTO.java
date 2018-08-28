package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionDetailDTO
 * @Description TODO
 * @date 2018/6/25 13:53
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermissionDetailDTO implements Serializable {

    private Long id;

    private String name;

    private List<PermissionThirdDTO> permissionThirdList;

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

    public List<PermissionThirdDTO> getPermissionThirdList() {
        return permissionThirdList;
    }

    public void setPermissionThirdList(List<PermissionThirdDTO> permissionThirdList) {
        this.permissionThirdList = permissionThirdList;
    }
}
