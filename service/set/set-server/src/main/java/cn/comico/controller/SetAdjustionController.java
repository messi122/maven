package cn.comico.controller;


import cn.comico.dto.SetAdjustionDTO;
import cn.comico.facade.SetAdjustionApi;
import cn.comico.service.ISetAdjustionService;
import cn.comico.supply.dto.SetAdjustionDTO;
import cn.comico.supply.facade.SetAdjustionApi;
import cn.comico.supply.service.ISetAdjustionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: cn.comico.erp.service.set.api.controller
 * @Author: yuyong
 * @CreateDate: 2018/8/7 15:41
 * @UpdateUser:
 * @UpdateDate: 2018/8/7 15:41
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@RestController
public class SetAdjustionController implements SetAdjustionApi {
    @Autowired
    private ISetAdjustionService adjustionService;

    @Override
    public SetAdjustionDTO getSetAdjustion() {
        return adjustionService.getSetAdjustion();
    }
}
