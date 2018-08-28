package cn.comico.facade;


import cn.comico.dto.ManagerPermissionDTO;
import cn.comico.dto.MenuDTO;
import cn.comico.dto.PermissionDTO;
import cn.comico.dto.PermissionDetailDTO;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.supply.dto.ManagerPermissionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionApi
 * @Description TODO
 * @date 2018/6/22 15:12
 **/
@Api(tags = "权限接口")
@RequestMapping(value = "/permission")
public interface PermissionApi {

    /**
    * 
    * @author      changhuanhu
    * @Description 查询用户菜单权限
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.MenuDTO>>
    * @Date 2018/6/25 16:25
    **/
    @ApiOperation(value = "查询用户菜单权限")
    @GetMapping(value = "/list")
    ResultResp<List<MenuDTO>> list(Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 公司权限列表
    * @Param [level]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDTO>>
    * @Date 2018/6/25 13:49
    **/
    @ApiOperation(value = "查询总部菜单列表")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_COMPANY_READ)")
    @GetMapping(value = "/company/list")
    ResultResp<List<PermissionDTO>> findPermissionByLevel();

    /**
    * 
    * @author      changhuanhu
    * @Description 查询权限详情
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDetailDTO>>
    * @Date 2018/6/25 14:44
    **/
    @ApiOperation(value = "查询总部菜单详情")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_COMPANY_READ)")
    @GetMapping(value = "/company/{id}")
    ResultResp<List<PermissionDetailDTO>> getPermissionDetail(@PathVariable Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询一级菜单列表
    * @Param []
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDTO>>
    * @Date 2018/6/27 18:46
    **/
    @ApiOperation(value = "查询一级菜单列表")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_FIRST_READ)")
    @GetMapping(value = "/first/list")
    ResultResp<List<PermissionDTO>> findFirstPermissionByLevel();

    /**
    * 
    * @author      changhuanhu
    * @Description 查询一级菜单详情
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDetailDTO>>
    * @Date 2018/6/27 18:46
    **/
    @ApiOperation(value = "查询一级菜单详情")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_FIRST_READ)")
    @GetMapping(value = "/first/{id}")
    ResultResp<List<PermissionDetailDTO>> getFirstPermissionDetail(@PathVariable Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询二级菜单列表
    * @Param []
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDTO>>
    * @Date 2018/6/27 18:47
    **/
    @ApiOperation(value = "查询二级菜单列表")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_SECOND_READ)")
    @GetMapping(value = "/second/list")
    ResultResp<List<PermissionDTO>> findSecondPermissionByLevel();

    /**
    * 
    * @author      changhuanhu
    * @Description 查询二级菜单详情
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDetailDTO>>
    * @Date 2018/6/27 18:47
    **/
    @ApiOperation(value = "查询二级菜单详情")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_SECOND_READ)")
    @GetMapping(value = "/second/{id}")
    ResultResp<List<PermissionDetailDTO>> getSecondPermissionDetail(@PathVariable Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询三级菜单列表
    * @Param []
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDTO>>
    * @Date 2018/6/27 18:48
    **/
    @ApiOperation(value = "查询三级菜单列表")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_THIRD_READ)")
    @GetMapping(value = "/third/list")
    ResultResp<List<PermissionDTO>> findThirdPermissionByLevel();

    /**
    * 
    * @author      changhuanhu
    * @Description 查询三级菜单详情
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDetailDTO>>
    * @Date 2018/6/27 18:49
    **/
    @ApiOperation(value = "查询三级菜单详情")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_THIRD_READ)")
    @GetMapping(value = "/third/{id}")
    ResultResp<List<PermissionDetailDTO>> getThirdPermissionDetail(@PathVariable Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询店铺菜单列表
    * @Param []
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDTO>>
    * @Date 2018/6/27 18:49
    **/
    @ApiOperation(value = "查询店铺菜单列表")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_SHOP_READ)")
    @GetMapping(value = "/shop/list")
    ResultResp<List<PermissionDTO>> findShopPermissionByLevel();

    /**
    * 
    * @author      changhuanhu
    * @Description 查询店铺菜单详情
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDetailDTO>>
    * @Date 2018/6/27 18:50
    **/
    @ApiOperation(value = "查询店铺菜单详情")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_SHOP_READ)")
    @GetMapping(value = "/shop/{id}")
    ResultResp<List<PermissionDetailDTO>> getShopPermissionDetail(@PathVariable Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存更新权限
    * @Param [list]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/26 19:01
    **/
    @ApiOperation(value = "保存权限")
    @PreAuthorize("hasAnyAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_SHOP_OPERATE, T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_COMPANY_OPERATE, T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_FIRST_OPERATE, T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_SECOND_OPERATE, T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_THIRD_OPERATE)")
    @PostMapping(value = "/company")
    ResultResp updatePermission(List<ManagerPermissionDTO> list);


}
