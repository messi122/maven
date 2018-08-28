package cn.comico.service.impl;


import cn.comico.dto.ParamsConfigDTO;
import cn.comico.erp.commons.constant.CacheConstant;
import cn.comico.erp.commons.spring.BeanUtils;
import cn.comico.repository.ParamsConfigRepository;
import cn.comico.service.IParamsConfigService;
import cn.comico.set.ParamsConfig;
import cn.comico.supply.dto.ParamsConfigDTO;
import cn.comico.supply.erp.commons.spring.BeanUtils;
import cn.comico.supply.set.ParamsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ParamsConfigServiceImpl
 * @Description TODO
 * @date 2018/7/23 11:48
 **/
@CacheConfig(cacheNames = CacheConstant.ERP_SET_PARAMS_CONFIG)
@Service
public class ParamsConfigServiceImpl implements IParamsConfigService {

    @Autowired
    private ParamsConfigRepository paramsConfigRepository;

    @Cacheable(key = "#group")
    @Override
    public List<ParamsConfigDTO> findParamsConfigByGroup(String group) {
        List<ParamsConfig> paramsConfigList = paramsConfigRepository.findParamsConfigByGroup(group);
        return BeanUtils.copyList(paramsConfigList, ParamsConfigDTO.class);
    }

    @CacheEvict(allEntries = true)
    @Transactional
    @Override
    public void batchSaveOrUpdate(List<ParamsConfigDTO> paramsConfigDTOList) {
        Optional.ofNullable(paramsConfigDTOList)
                .orElse(new ArrayList<>())
                .forEach(paramsConfigDTO -> {
                    ParamsConfig paramsConfig = BeanUtils.copyObject(paramsConfigDTO, ParamsConfig.class);
                    paramsConfigRepository.saveAndFlush(paramsConfig);
                });

    }

    @Override
    public ParamsConfigDTO getParamsConfigByKey(String key) {
        ParamsConfig paramsConfig = paramsConfigRepository.findParamsConfigByKey(key);
        return BeanUtils.copyObject(paramsConfig, ParamsConfigDTO.class);
    }
}
