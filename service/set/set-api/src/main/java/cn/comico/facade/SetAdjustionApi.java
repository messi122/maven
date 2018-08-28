package cn.comico.facade;


import cn.comico.dto.SetAdjustionDTO;
import cn.comico.supply.dto.SetAdjustionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @ClassName: cn.comico.erp.service.set.api.facade
 * @Author: yuyong
 * @CreateDate: 2018/8/7 15:36
 * @UpdateUser:
 * @UpdateDate: 2018/8/7 15:36
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Api(tags = "市场配货设置接口")
@RequestMapping(value = "/adjustion")
public interface SetAdjustionApi {

    @ApiOperation(value = "查询总部配货设置参数")
    @GetMapping(value = "/find")
    SetAdjustionDTO getSetAdjustion();
}
