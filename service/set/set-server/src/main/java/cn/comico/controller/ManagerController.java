package cn.comico.controller;


import cn.comico.dto.ManagerDTO;
import cn.comico.dto.ManagerSaveDTO;
import cn.comico.facade.ManagerApi;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController implements ManagerApi {

    @Autowired
    private IManagerService managerService;


    @Override
    public ResultResp<DataGrid<List<ManagerDTO>>> list(Integer type, Long channelId, @RequestParam(required = false, defaultValue = "") String keywords
            , @RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int pageSize) {

        return managerService.findManagerList(type, channelId, keywords, offset, pageSize);
    }

    @Override
    public ResultResp<ManagerSaveDTO> getManager(@PathVariable Long id) {
        return managerService.getOne(id);
    }

    @Override
    public ResultResp<DataGrid<ManagerDTO>> search(@RequestParam String keywords, @RequestParam(defaultValue = "0") Long offset, @RequestParam(defaultValue = "10") Long pageSize) {
        return managerService.search(keywords, offset, pageSize);
    }

    @Override
    public ResultResp saveManager(ManagerSaveDTO managerSaveDTO) {

        return managerService.saveManager(managerSaveDTO);
    }

    @Override
    public ResultResp updateStatus(@PathVariable Long id, Integer status) {
        return managerService.updateStatus(id, status);
    }

    @Override
    public ResultResp deleteManager(@PathVariable Long id) {
        return managerService.deleteManager(id);
    }

    @Override
    public ResultResp updateManager(@PathVariable Long id, ManagerSaveDTO managerSaveDTO) {
        managerSaveDTO.setId(id);
        return managerService.updateManager(managerSaveDTO);
    }


}
