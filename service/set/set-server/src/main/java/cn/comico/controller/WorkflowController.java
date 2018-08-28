package cn.comico.controller;


import cn.comico.dto.SetWorkflowDTO;
import cn.comico.dto.WorkflowDTO;
import cn.comico.facade.WorkFlowApi;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.service.IWorkflowService;
import cn.comico.supply.dto.SetWorkflowDTO;
import cn.comico.supply.dto.WorkflowDTO;
import cn.comico.supply.erp.commons.result.ResultResp;
import cn.comico.supply.facade.WorkFlowApi;
import cn.comico.supply.service.IWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName WorkflowController
 * @Description TODO
 * @date 2018/7/4 14:22
 **/
@RestController
public class WorkflowController implements WorkFlowApi {

    @Autowired
    private IWorkflowService workflowService;

    @Override
    public ResultResp<DataGrid<SetWorkflowDTO>> findWorkflowListByLevel(@RequestParam(defaultValue = "0") Integer level, @RequestParam(defaultValue = "1") Long channelId) {
        return workflowService.findWorkflowListByLevel(level, channelId);
    }

    @Override
    public ResultResp saveWorkflow(@RequestBody List<SetWorkflowDTO> setWorkflowDTOList) {
        return workflowService.saveWorkflow(setWorkflowDTOList);
    }

    @Override
    public WorkflowDTO getWorkflow(@RequestParam Long channelId, @RequestParam String code) {
        return workflowService.getWorkflow(channelId, code);
    }
}
