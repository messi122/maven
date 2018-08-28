package cn.comico.service;


import cn.comico.dto.ParamsConfigDTO;
import cn.comico.supply.dto.ParamsConfigDTO;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName IParamsConfigService
 * @Description TODO
 * @date 2018/7/23 11:48
 **/
public interface IParamsConfigService {

    /**
    * 
    * @author      changhuanhu
    * @Description 根据组名查询
    * @Param [group]
    * @exception   
    * @return      java.util.List<cn.comico.erp.service.set.api.dto.ParamsConfigDTO>
    * @Date 2018/7/23 14:27
    **/
    List<ParamsConfigDTO> findParamsConfigByGroup(String group);

    /**
    * 
    * @author      changhuanhu
    * @Description 批量保存或者更新
    * @Param [paramsConfigDTOList]
    * @exception   
    * @return      void
    * @Date 2018/7/23 14:27
    **/
    void batchSaveOrUpdate(List<ParamsConfigDTO> paramsConfigDTOList);

    /**
    * 
    * @author      changhuanhu
    * @Description 根据key查询
    * @Param [key]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.ParamsConfigDTO
    * @Date 2018/7/23 15:02
    **/
    ParamsConfigDTO getParamsConfigByKey(String key);
}
