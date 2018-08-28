package cn.comico.erp.commons.config.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
* 
* @author      changhuanhu
* @Description resource server配置
* @Param 
* @exception   
* @return      
* @Date 2018/7/6 17:27
**/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers("/user/login", "/user/register").permitAll()
                .antMatchers("/oauth/getToken", "/manager/register", "/oauth/refreshToken").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/hystrix.stream").permitAll()
                .antMatchers("/hystrix").permitAll()
                .antMatchers("/hystrix/**").permitAll()
                .antMatchers("/proxy.stream").permitAll()
                .antMatchers("/turbine.stream").permitAll()
//                .antMatchers("/**").permitAll();
                .antMatchers("/**").authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

}
