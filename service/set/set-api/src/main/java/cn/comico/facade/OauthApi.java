package cn.comico.facade;

import cn.comico.dto.ManagerLoginDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 鉴权接口
 * @author changhuanhu
 * @version 1.0
 * @ClassName OauthApi
 * @Description TODO
 * @date 2018/6/28 14:46
 **/
@Api(tags = "鉴权接口")
@RequestMapping(value = "/oauth")
public interface OauthApi {

    /**
    * 
    * @author      changhuanhu
    * @Description 获取token
    * @Param [username, password]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.ManagerLoginDTO
    * @Date 2018/6/28 14:50
    **/
    @ApiOperation(value = "获取access_token", notes = "获取账号密码获取access_token")
    @GetMapping(value = "/getToken")
    ManagerLoginDTO login(String username, String password);

    /**
    * 
    * @author      changhuanhu
    * @Description 刷新access_token
    * @Param [refreshToken]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.ManagerLoginDTO
    * @Date 2018/6/28 14:51
    **/
    @ApiOperation(value = "刷新access_token", notes = "根据refreshToken刷新token")
    @GetMapping(value = "/refreshToken")
    ManagerLoginDTO refreshToken(String refreshToken);
}
