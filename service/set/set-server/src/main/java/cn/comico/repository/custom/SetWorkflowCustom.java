package cn.comico.repository.custom;



import cn.comico.dto.SetWorkflowDTO;
import cn.comico.dto.WorkflowDTO;
import cn.comico.supply.dto.SetWorkflowDTO;
import cn.comico.supply.dto.WorkflowDTO;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetWorkflowCustom
 * @Description TODO
 * @date 2018/7/4 15:51
 **/
public interface SetWorkflowCustom {
    
    /**
    * 
    * @author      changhuanhu
    * @Description 根据级别查询流程设置
    * @Param [level, channelId]
    * @exception   
    * @return      java.util.List<cn.comico.erp.service.set.api.dto.SetWorkflowDTO>
    * @Date 2018/7/4 15:55
    **/
    List<SetWorkflowDTO> findWorkflowListByLevel(Integer level, Long channelId);

    /**
    * 
    * @author      changhuanhu
    * @Description 根据渠道编号、流程编号查询
    * @Param [channelId, code]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.WorkflowDTO
    * @Date 2018/8/8 16:16
    **/
    WorkflowDTO getSetWorkflow(Long channelId, String code);
}
