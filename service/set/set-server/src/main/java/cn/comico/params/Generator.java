package cn.comico.params;


import cn.comico.dto.ParamsConfigDTO;
import cn.comico.service.IParamsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName Generator
 * @Description TODO
 * @date 2018/7/23 13:57
 **/
@Component
public class Generator {

    private Map<String, AtomicLong> codeMap = new ConcurrentHashMap<>();

    private ReentrantLock lock = new ReentrantLock();

    @Autowired
    private IParamsConfigService paramsConfigService;

    @PostConstruct
    public void init() {
        List<ParamsConfigDTO> paramsConfigDTOList = paramsConfigService.findParamsConfigByGroup(ParamsConfigKeyConstant.GROUP_NAME);
        Optional.ofNullable(paramsConfigDTOList)
                .orElse(new ArrayList<>())
                .forEach(paramsConfigDTO -> {
                    long value = Long.valueOf(paramsConfigDTO.getValue());
                    codeMap.put(paramsConfigDTO.getKey(), new AtomicLong(value));
                    paramsConfigDTO.setValue(String.valueOf(value + ParamsConfigKeyConstant.PULL_SIZE));
                });

        paramsConfigService.batchSaveOrUpdate(paramsConfigDTOList);
    }

    public String generate(String key) {
        String result = "";
        try {
            lock.tryLock();
            AtomicLong atomicLong = codeMap.get(key);
            result = String.valueOf(atomicLong.get());
            long val = atomicLong.incrementAndGet();
            check(key, val);
        } finally {
            lock.unlock();
        }
        return result;
    }

    private void check(String key, long val) {
        if (val % ParamsConfigKeyConstant.PULL_SIZE == 0) {
            ParamsConfigDTO paramsConfigDTO = paramsConfigService.getParamsConfigByKey(key);
            if (null != paramsConfigDTO) {
                paramsConfigDTO.setValue(String.valueOf(Long.valueOf(paramsConfigDTO.getValue()) + ParamsConfigKeyConstant.PULL_SIZE));
                paramsConfigService.batchSaveOrUpdate(Collections.singletonList(paramsConfigDTO));
            }
        }
    }

}
