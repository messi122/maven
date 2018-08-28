package cn.comico.facade;


import cn.comico.dto.SetWorkflowDTO;
import cn.comico.dto.WorkflowDTO;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName WorkFlowApi
 * @Description TODO
 * @date 2018/7/4 13:56
 **/
@Api(tags = "流程设置")
@RequestMapping(value = "/workflow")
public interface WorkFlowApi {

    /**
    * 
    * @author      changhuanhu
    * @Description 根据级别查询流程设置
    * @Param [level, channelId]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/4 14:00
    **/
    @ApiOperation(value = "查询流程设置")
    @PreAuthorize("hasAnyAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_WORKFLOW_READ, T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_PROXY_WORKFLOW_READ)")
    @GetMapping(value = "/list")
    ResultResp<DataGrid<SetWorkflowDTO>> findWorkflowListByLevel(Integer level, Long channelId);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存流程设置
    * @Param [setWorkflowDTOList]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/4 14:05
    **/
    @ApiOperation(value = "保存流程设置")
    @PreAuthorize("hasAnyAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_WORKFLOW_OPERATE" +
            ", T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_PROXY_WORKFLOW_OPERATE)")
    @PostMapping(value = "/")
    ResultResp saveWorkflow(List<SetWorkflowDTO> setWorkflowDTOList);

    /**
    * 
    * @author      changhuanhu
    * @Description 获取流程设置
    * @Param [channelId, code]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.WorkflowDTO
    * @Date 2018/8/8 9:37
    **/
    @ApiIgnore
    @GetMapping(value = "/get")
    WorkflowDTO getWorkflow(Long channelId, String code);
}
