package cn.comico.controller;


import cn.comico.dto.ManagerLoginDTO;
import cn.comico.facade.OauthApi;
import cn.comico.service.IManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName OauthController
 * @Description TODO
 * @date 2018/6/28 14:52
 **/
@RestController
public class OauthController implements OauthApi {

    @Autowired
    private IManagerService managerService;

    @Override
    public ManagerLoginDTO login(@RequestParam String username, @RequestParam String password) {
        return managerService.login(username, password);
    }

    @Override
    public ManagerLoginDTO refreshToken(@RequestParam String refreshToken) {
        return managerService.refreshToken(refreshToken);
    }

}
