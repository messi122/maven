package cn.comico.controller;


import cn.comico.dto.GroupDTO;
import cn.comico.dto.PermissionFirstDTO;
import cn.comico.facade.GroupApi;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.service.IGroupService;
import cn.comico.service.IPermissionService;
import cn.comico.supply.dto.GroupDTO;
import cn.comico.supply.dto.PermissionFirstDTO;
import cn.comico.supply.erp.commons.result.ResultResp;
import cn.comico.supply.facade.GroupApi;
import cn.comico.supply.service.IGroupService;
import cn.comico.supply.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName GroupController
 * @Description TODO
 * @date 2018/6/28 17:50
 **/
@RestController
public class GroupController implements GroupApi {

    @Autowired
    private IGroupService groupService;

    @Autowired
    private IPermissionService permissionService;

    @Override
    public ResultResp<DataGrid<GroupDTO>> findGroupList(@RequestParam Integer type, @RequestParam(defaultValue = "0") int offset
            , @RequestParam(defaultValue = "10") int pageSize) {
        return groupService.findGroupList(type, offset, pageSize);
    }

    @Override
    public ResultResp<List<PermissionFirstDTO>> findPermissionByType(Integer type) {
        return permissionService.findPermissionByType(type);
    }

    @Override
    public ResultResp saveGroup(GroupDTO groupDTO) {
        return groupService.saveGroup(groupDTO);
    }

    @Override
    public ResultResp<GroupDTO> getGroup(@PathVariable Long id) {
        return groupService.getGroup(id);
    }

    @Override
    public ResultResp updateGroup(@PathVariable Long id, GroupDTO groupDTO) {
        groupDTO.setId(id);
        return groupService.updateGroup(groupDTO);
    }

    @Override
    public ResultResp updateStatus(@PathVariable Long id, Integer status) {
        return groupService.updateStatus(id, status);
    }

    @Override
    public ResultResp deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }
}
