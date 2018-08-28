package cn.comico.repository;


import cn.comico.set.ParamsConfig;
import cn.comico.supply.set.ParamsConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ParamsConfigRepository
 * @Description TODO
 * @date 2018/7/23 11:49
 **/
public interface ParamsConfigRepository extends JpaRepository<ParamsConfig, String> {

    List<ParamsConfig> findParamsConfigByGroup(String group);

    ParamsConfig findParamsConfigByKey(String key);
}
