package cn.comico.erp.commons.config.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
* 
* @author      changhuanhu
* @Description spring security 配置
* @Param 
* @exception   
* @return      
* @Date 2018/7/6 17:26
**/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = false)
public class GlobalMethodSecurityConfig {
}
