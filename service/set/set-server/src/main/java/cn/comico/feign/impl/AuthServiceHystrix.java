package cn.comico.feign.impl;


import cn.comico.dto.JWT;
import cn.comico.feign.AuthServiceClient;
import org.springframework.stereotype.Component;

/**
 * 熔断器
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }

    @Override
    public JWT refreshToken(String authorization, String type, String refreshToken) {
        return null;
    }
}
