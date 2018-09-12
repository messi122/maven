package cn.comico.service.impl;

import cn.comico.dto.SetAdjustionDTO;
import cn.comico.erp.commons.spring.BeanUtils;
import cn.comico.repository.SetAdjustionRepository;
import cn.comico.service.ISetAdjustionService;
import cn.comico.set.SetAdjustion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @ClassName: cn.comico.erp.service.set.api.service.impl
 * @Author: yuyong
 * @CreateDate: 2018/8/7 15:43
 * @UpdateUser:
 * @UpdateDate: 2018/8/7 15:43
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Service
public class SetAdjustionServiceImpl implements ISetAdjustionService {
    @Autowired
    private SetAdjustionRepository setAdjustionRepository;

    @Override
    public SetAdjustionDTO getSetAdjustion() {
        List<SetAdjustion> adjustionListist = setAdjustionRepository.findAll();
        SetAdjustionDTO adjustionDTO = BeanUtils.copyObject(adjustionListist.get(0),SetAdjustionDTO.class);
        return adjustionDTO;
    }
}
