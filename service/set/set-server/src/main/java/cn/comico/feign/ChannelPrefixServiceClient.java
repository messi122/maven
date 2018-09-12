package cn.comico.feign;


import cn.comico.feign.impl.ChannelPrefixServiceHystrix;
import cn.comico.erp.commons.constant.ApplicationConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @ClassName: cn.comico.erp.service.set.api.feign
 * @Author: yuyong
 * @CreateDate: 2018/8/10 9:29
 * @UpdateUser:
 * @UpdateDate: 2018/8/10 9:29
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@FeignClient(value = ApplicationConstant.ERP_SERVICE_INFO_SERVER, fallback = ChannelPrefixServiceHystrix.class)
public interface ChannelPrefixServiceClient {

    @GetMapping(value = "/channel/prefix/{channelId}")
    String findChannelPrefix(@PathVariable(value = "channelId") Long channelId);

}
