package cn.comico.controller;


import cn.comico.dto.ManagerPermissionDTO;
import cn.comico.dto.MenuDTO;
import cn.comico.dto.PermissionDTO;
import cn.comico.dto.PermissionDetailDTO;
import cn.comico.facade.PermissionApi;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.service.IManagerService;
import cn.comico.service.IPermissionService;
import cn.comico.set.Permission;
import cn.comico.supply.dto.ManagerPermissionDTO;
import cn.comico.supply.dto.PermissionDTO;
import cn.comico.supply.dto.PermissionDetailDTO;
import cn.comico.supply.erp.commons.result.ResultResp;
import cn.comico.supply.facade.PermissionApi;
import cn.comico.supply.service.IManagerService;
import cn.comico.supply.service.IPermissionService;
import cn.comico.supply.set.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionController
 * @Description TODO
 * @date 2018/6/22 15:38
 **/
@RestController
public class PermissionController implements PermissionApi {

    @Autowired
    private IManagerService managerService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public ResultResp<List<MenuDTO>> list(@RequestParam Long id) {
        return managerService.listPermission(id);
    }

    @Override
    public ResultResp<List<PermissionDTO>> findPermissionByLevel() {

        return permissionService.findPermission(Permission.TYPE_MENU, Permission.LEVEL_COMPANY, Permission.MENU_LEVEL_FIRST);
    }

    @Override
    public ResultResp<List<PermissionDetailDTO>> getPermissionDetail(@PathVariable Long id) {
        return permissionService.getPermissionDetail(id, Permission.TYPE_MENU, Permission.LEVEL_COMPANY, Permission.MENU_LEVEL_SECOND);
    }

    @Override
    public ResultResp<List<PermissionDTO>> findFirstPermissionByLevel() {
        return permissionService.findPermission(Permission.TYPE_MENU, Permission.LEVEL_FIRST, Permission.MENU_LEVEL_FIRST);
    }

    @Override
    public ResultResp<List<PermissionDetailDTO>> getFirstPermissionDetail(@PathVariable Long id) {
        return permissionService.getPermissionDetail(id, Permission.TYPE_MENU, Permission.LEVEL_FIRST, Permission.MENU_LEVEL_SECOND);
    }

    @Override
    public ResultResp<List<PermissionDTO>> findSecondPermissionByLevel() {
        return permissionService.findPermission(Permission.TYPE_MENU, Permission.LEVEL_SECOND, Permission.MENU_LEVEL_FIRST);
    }

    @Override
    public ResultResp<List<PermissionDetailDTO>> getSecondPermissionDetail(@PathVariable Long id) {
        return permissionService.getPermissionDetail(id, Permission.TYPE_MENU, Permission.LEVEL_SECOND, Permission.MENU_LEVEL_SECOND);
    }

    @Override
    public ResultResp<List<PermissionDTO>> findThirdPermissionByLevel() {
        return permissionService.findPermission(Permission.TYPE_MENU, Permission.LEVEL_THIRD, Permission.MENU_LEVEL_FIRST);
    }

    @Override
    public ResultResp<List<PermissionDetailDTO>> getThirdPermissionDetail(@PathVariable Long id) {
        return permissionService.getPermissionDetail(id, Permission.TYPE_MENU, Permission.LEVEL_THIRD, Permission.MENU_LEVEL_SECOND);
    }

    @Override
    public ResultResp<List<PermissionDTO>> findShopPermissionByLevel() {
        return permissionService.findPermission(Permission.TYPE_MENU, Permission.LEVEL_SHOP, Permission.MENU_LEVEL_FIRST);
    }

    @Override
    public ResultResp<List<PermissionDetailDTO>> getShopPermissionDetail(@PathVariable Long id) {
        return permissionService.getPermissionDetail(id, Permission.TYPE_MENU, Permission.LEVEL_SHOP, Permission.MENU_LEVEL_SECOND);
    }

    @Override
    public ResultResp updatePermission(@RequestBody List<ManagerPermissionDTO> list) {

        return permissionService.updatePermission(list);
    }


}
