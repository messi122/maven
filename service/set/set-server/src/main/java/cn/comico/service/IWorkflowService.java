package cn.comico.service;


import cn.comico.dto.SetWorkflowDTO;
import cn.comico.dto.WorkflowDTO;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName IWorkflowService
 * @Description TODO
 * @date 2018/7/4 14:24
 **/
public interface IWorkflowService {

    /**
    * 
    * @author      changhuanhu
    * @Description 根据级别、代理ID查询
    * @Param [level, channelId]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.commons.result.DataGrid<cn.comico.erp.service.set.api.dto.SetWorkflowDTO>>
    * @Date 2018/7/5 13:52
    **/
    ResultResp<DataGrid<SetWorkflowDTO>> findWorkflowListByLevel(Integer level, Long channelId);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存流程设置
    * @Param [setWorkflowDTOList]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/4 15:31
    **/
    ResultResp saveWorkflow(List<SetWorkflowDTO> setWorkflowDTOList);

    /**
    * 
    * @author      changhuanhu
    * @Description 根据channelId、code查询流程设置
    * @Param [channelId, code]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.WorkflowDTO
    * @Date 2018/8/8 9:39
    **/
    WorkflowDTO getWorkflow(Long channelId, String code);
}
