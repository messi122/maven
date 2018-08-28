package cn.comico.service;


import cn.comico.dto.SetAdjustionDTO;
import cn.comico.supply.dto.SetAdjustionDTO;

/**
 * @Description:
 * @ClassName: cn.comico.erp.service.set.api.service
 * @Author: yuyong
 * @CreateDate: 2018/8/7 15:42
 * @UpdateUser:
 * @UpdateDate: 2018/8/7 15:42
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
public interface ISetAdjustionService {


    /**
    * @author yuyong
    * @Description  获取可调设置的参数信息
    * @param []
    * @return cn.comico.erp.commons.result.ResultResp<cn.comico.erp.service.set.api.dto.SetAdjustionDTO>
    * @date 2018/8/7 15:44
    */
    SetAdjustionDTO getSetAdjustion();
}
