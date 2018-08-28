package cn.comico.facade;


import cn.comico.dto.ManagerDTO;
import cn.comico.dto.ManagerSaveDTO;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.supply.dto.ManagerDTO;
import cn.comico.supply.dto.ManagerSaveDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "管理员接口")
@RequestMapping(value = "/manager")
public interface ManagerApi {

    /**
    * 
    * @author      changhuanhu
    * @Description 查询用户列表
    * @Param [type, channelId, keywords]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.ManagerDTO>>
    * @Date 2018/6/28 16:25
    **/
    @ApiOperation(value = "查询用户列表", notes = "根据类型、代理ID、关键词搜索用户")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MANAGER_READ)")
    @GetMapping(value = "/list")
    ResultResp<DataGrid<List<ManagerDTO>>> list(Integer type, Long channelId, String keywords, int offset, int pageSize);

    /**
    * 
    * @author      changhuanhu
    * @Description 获取管理员信息
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.ManagerDTO
    * @Date 2018/7/3 17:08
    **/
    @ApiOperation(value = "获取管理员信息", notes = "根据ID获取管理员信息")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MANAGER_READ)")
    @GetMapping(value = "/{id}")
    ResultResp<ManagerSaveDTO> getManager(@PathVariable(value = "id") Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询管理员
    * @Param [keywords, offset, pageSize]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.commons.result.DataGrid<cn.comico.erp.service.set.api.dto.ManagerDTO>>
    * @Date 2018/6/27 18:12
    **/
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MANAGER_READ)")
    @ApiOperation(value = "查询管理员", notes = "根据名称查询管理员")
    @GetMapping(value = "/search")
    ResultResp<DataGrid<ManagerDTO>> search(String keywords, Long offset, Long pageSize);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存管理员信息
    * @Param [managerSaveDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/28 17:41
    **/
    @ApiOperation(value = "保存管理员", notes = "保存管理员信息并分配权限")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MANAGER_OPERATE)")
    @PostMapping(value = "/")
    ResultResp saveManager(ManagerSaveDTO managerSaveDTO);

    /**
    * 
    * @author      changhuanhu
    * @Description 更新管理员状态
    * @Param [id, status]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/28 17:41
    **/
    @ApiOperation(value = "启用/禁用", notes = "更新管理员状态")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MANAGER_OPERATE)")
    @PutMapping(value = "/status/{id}")
    ResultResp updateStatus(@PathVariable Long id, Integer status);

    /**
    * 
    * @author      changhuanhu
    * @Description 删除管理员
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/28 17:44
    **/
    @ApiOperation(value = "删除管理员", notes = "根据ID删除管理员")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MANAGER_OPERATE)")
    @DeleteMapping(value = "/{id}")
    ResultResp deleteManager(@PathVariable Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 更新管理员信息
    * @Param [id, managerSaveDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/28 17:50
    **/
    @ApiOperation(value = "更新管理员信息", notes = "更新管理员信息")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MANAGER_OPERATE)")
    @PutMapping(value = "/{id}")
    ResultResp updateManager(@PathVariable Long id, ManagerSaveDTO managerSaveDTO);
}
