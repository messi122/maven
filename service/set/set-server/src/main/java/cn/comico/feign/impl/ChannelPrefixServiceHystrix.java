package cn.comico.feign.impl;

import cn.comico.feign.ChannelPrefixServiceClient;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @ClassName: cn.comico.erp.service.set.api.feign.impl
 * @Author: yuyong
 * @CreateDate: 2018/8/10 9:32
 * @UpdateUser:
 * @UpdateDate: 2018/8/10 9:32
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@Component
public class ChannelPrefixServiceHystrix implements ChannelPrefixServiceClient {


    @Override
    public String findChannelPrefix(Long channelId) {
        return null;
    }
}
