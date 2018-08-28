package cn.comico.schedule;


import cn.comico.dto.ParamsConfigDTO;
import cn.comico.params.Generator;
import cn.comico.params.ParamsConfigKeyConstant;
import cn.comico.service.IParamsConfigService;
import cn.comico.supply.dto.ParamsConfigDTO;
import cn.comico.supply.params.Generator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Schedule
 * @Description TODO
 * @date 2018/7/23 17:20
 **/
@EnableScheduling
@Component
public class Schedule {

    private static final Logger log = LoggerFactory.getLogger(Schedule.class);

    @Autowired
    private IParamsConfigService paramsConfigService;

    @Autowired
    private Generator generator;
    
    /**
    * 
    * @author      changhuanhu
    * @Description 重置单号, 每天凌晨
    * @Param []
    * @exception   
    * @return      void
    * @Date 2018/7/23 17:21
    **/
    @Scheduled(cron = "0 0 0 * * ?")
    public void restOrderCode() {
        List<ParamsConfigDTO> paramsConfigDTOList = paramsConfigService.findParamsConfigByGroup(ParamsConfigKeyConstant.GROUP_NAME);
        Optional.ofNullable(paramsConfigDTOList)
                .orElse(new ArrayList<>())
                .forEach(paramsConfigDTO -> {
                    paramsConfigDTO.setValue(String.valueOf("0"));
                });
        try {
            paramsConfigService.batchSaveOrUpdate(paramsConfigDTOList);
            generator.init();
            log.info("rest order code successful");
        } catch (Exception e) {
            log.info(e.getMessage());
            generator.init();
            log.info("rest order code successful");
        }
    }
    
}
