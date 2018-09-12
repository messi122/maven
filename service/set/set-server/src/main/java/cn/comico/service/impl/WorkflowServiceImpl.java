package cn.comico.service.impl;


import cn.comico.dto.SetWorkflowDTO;
import cn.comico.dto.WorkflowDTO;
import cn.comico.erp.commons.constant.CacheConstant;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.erp.commons.spring.BeanUtils;
import cn.comico.repository.SetWorkflowRepository;
import cn.comico.service.IWorkflowService;
import cn.comico.set.SetWorkflow;
import cn.comico.workflow.WorkflowContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName WorkflowServiceImpl
 * @Description TODO
 * @date 2018/7/4 14:24
 **/
@CacheConfig(cacheNames = CacheConstant.ERP_SET_WORKFLOW)
@Service
public class WorkflowServiceImpl implements IWorkflowService {

    @Autowired
    private SetWorkflowRepository setWorkflowRepository;

    @Cacheable(key = "#root.methodName + T(cn.comico.erp.commons.constant.CacheConstant).SPIDER_CHAR + #level + T(cn.comico.erp.commons.constant.CacheConstant).SPIDER_CHAR + #channelId")
    @Override
    public ResultResp<DataGrid<SetWorkflowDTO>> findWorkflowListByLevel(Integer level, Long channelId) {

        List<SetWorkflowDTO> setWorkflowList = setWorkflowRepository.findWorkflowListByLevel(level, channelId);
        if (CollectionUtils.isEmpty(setWorkflowList)) {
            setWorkflowList = getInitSetWorkflow(level, channelId);
        }

        return ResultResp.code(ResultCode.SUCCESS)
                .data(new DataGrid<SetWorkflowDTO>(null != setWorkflowList ? setWorkflowList.size() : 0, setWorkflowList))
                .build();
    }

    private List<SetWorkflowDTO> getInitSetWorkflow(Integer level, Long channelId) {
        return WorkflowContent.get(0 == level ? 0 : level, channelId, level);
    }

    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public ResultResp saveWorkflow(List<SetWorkflowDTO> setWorkflowDTOList) {
        Date currDate = new Date();
        Optional.ofNullable(setWorkflowDTOList).orElse(new ArrayList<>())
                .forEach(setWorkflowDTO -> {
                    SetWorkflow setWorkflow = BeanUtils.copyObject(setWorkflowDTO, SetWorkflow.class);
                    setWorkflow.setUpdateDate(currDate);
                    setWorkflowRepository.saveAndFlush(setWorkflow);
                });
        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @Cacheable(key = "#root.methodName + T(cn.comico.erp.commons.constant.CacheConstant).SPIDER_CHAR + #channelId + T(cn.comico.erp.commons.constant.CacheConstant).SPIDER_CHAR + #code")
    @Override
    public WorkflowDTO getWorkflow(Long channelId, String code) {
        WorkflowDTO setWorkflow = setWorkflowRepository.getSetWorkflow(channelId, code);
        return setWorkflow;
    }

}
