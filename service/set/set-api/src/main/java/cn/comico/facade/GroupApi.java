package cn.comico.facade;

import cn.comico.dto.GroupDTO;
import cn.comico.dto.PermissionFirstDTO;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.supply.dto.GroupDTO;
import cn.comico.supply.dto.PermissionFirstDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName GroupApi
 * @Description TODO
 * @date 2018/6/28 13:27
 **/
@Api(tags = "权限组接口")
@RequestMapping(value = "/group")
public interface GroupApi {

    /**
     * @return cn.comico.erp.commons.result.ResultResp<cn.comico.erp.commons.result.DataGrid < cn.comico.erp.service.set.api.dto.GroupDTO>>
     * @throws
     * @author changhuanhu
     * @Description 查询权限组列表
     * @Param [type, offset, pageSize]
     * @Date 2018/6/28 13:35
     **/
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_GROUP_READ)")
    @ApiOperation(value = "权限组列表", notes = "根据类型查询权限组列表")
    @GetMapping(value = "/list")
    ResultResp<DataGrid<GroupDTO>> findGroupList(Integer type, int offset, int pageSize);

    /**
     * @return cn.comico.erp.commons.result.ResultResp<java.util.List < cn.comico.erp.service.set.api.dto.PermissionFirstDTO>>
     * @throws
     * @author changhuanhu
     * @Description 根据类型查询权限列表
     * @Param [type]
     * @Date 2018/6/28 14:01
     **/
    @ApiOperation(value = "查询类型权限", notes = "根据类型查询权限")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_GROUP_READ)")
    @GetMapping(value = "/permission/list")
    ResultResp<List<PermissionFirstDTO>> findPermissionByType(Integer type);

    /**
     * @return cn.comico.erp.commons.result.ResultResp
     * @throws
     * @author changhuanhu
     * @Description 保存权限组
     * @Param [groupDTO]
     * @Date 2018/6/28 14:15
     **/
    @ApiOperation(value = "保存权限组")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_GROUP_OPERATE)")
    @PostMapping(value = "/")
    ResultResp saveGroup(GroupDTO groupDTO);

    /**
    * 
    * @author      changhuanhu
    * @Description 根据ID获取权限组
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.service.set.api.dto.GroupDTO>
    * @Date 2018/6/28 14:22
    **/
    @ApiOperation(value = "获取权限组", notes = "根据ID获取权限组")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_GROUP_READ)")
    @GetMapping(value = "/{id}")
    ResultResp<GroupDTO> getGroup(@PathVariable Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 更新权限组
    * @Param [id, groupDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/28 14:36
    **/
    @ApiOperation(value = "更新权限组", notes = "更新权限组信息")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_GROUP_OPERATE)")
    @PutMapping(value = "/{id}")
    ResultResp updateGroup(@PathVariable(value = "id") Long id, GroupDTO groupDTO);

    /**
    * 
    * @author      changhuanhu
    * @Description 启用/禁用权限组
    * @Param [id, status]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/28 14:36
    **/
    @ApiOperation(value = "权限组启用/禁用")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_GROUP_OPERATE)")
    @PutMapping(value = "/status/{id}")
    ResultResp updateStatus(@PathVariable Long id, Integer status);

    /**
    * 
    * @author      changhuanhu
    * @Description 删除权限组
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/28 14:38
    **/
    @ApiOperation(value = "删除权限组", notes = "根据ID删除权限组")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_GROUP_OPERATE)")
    @DeleteMapping(value = "/{id}")
    ResultResp deleteGroup(@PathVariable Long id);
}