package cn.comico.feign;


import cn.comico.dto.JWT;
import cn.comico.feign.impl.AuthServiceHystrix;
import cn.comico.supply.dto.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 声明式feign调用
 */
@FeignClient(value = "erp-uaa", fallback = AuthServiceHystrix.class)
public interface AuthServiceClient {

    /**
     * 获取oauth token
     * @param authorization
     * @param type
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam(value = "grant_type") String type
            , @RequestParam("username") String username, @RequestParam("password") String password);


    /**
    *
    * @author      changhuanhu
    * @Description 刷新token
    * @Param [authorization, type, refreshToken]
    * @exception
    * @return      cn.comico.erp.service.set.api.dto.JWT
    * @Date 2018/6/27 17:46
    **/
    @PostMapping(value = "/oauth/token")
    JWT refreshToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam(value = "grant_type") String type
            , @RequestParam("refresh_token") String refreshToken);

}
