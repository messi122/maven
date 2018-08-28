package cn.comico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetWorkflowDTO
 * @Description TODO
 * @date 2018/7/3 18:27
 **/
public class SetWorkflowDTO implements Serializable {

    private static final long serialVersionUID = -4371377165259075071L;

    private Long id;

    private Long permissionId;

    private String permissionName;

    private String permissionIcon;

    private String name;

    private Integer level;

    private Long channelId;

    private String code;

    private Long auditor;

    private String auditorName; //审核人名字

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getAuditor() {
        return auditor;
    }

    public void setAuditor(Long auditor) {
        this.auditor = auditor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionIcon() {
        return permissionIcon;
    }

    public void setPermissionIcon(String permissionIcon) {
        this.permissionIcon = permissionIcon;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName;
    }

    public SetWorkflowDTO() {

    }

    public SetWorkflowDTO(Long id, Long permissionId, String permissionName, String permissionIcon, String name, Integer level, Long channelId, String code, Long auditor, Integer status, Date updateDate
        , String auditorName) {
        this.id = id;
        this.permissionId = permissionId;
        this.permissionName = permissionName;
        this.permissionIcon = permissionIcon;
        this.name = name;
        this.level = level;
        this.channelId = channelId;
        this.code = code;
        this.auditor = auditor;
        this.status = status;
        this.updateDate = updateDate;
        this.auditorName = auditorName;
    }
}
