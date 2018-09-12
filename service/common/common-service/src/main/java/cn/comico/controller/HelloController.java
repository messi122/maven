package cn.comico.controller;

import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: cn.comico.controller
 * @Author: yuyong
 * @CreateDate: 2018/8/23 16:18
 * @UpdateUser:
 * @UpdateDate: 2018/8/23 16:18
 * @UpdateRemark:
 * @Version: 1.0
 * @since JDK 1.8
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public ResultResp getName(){
        return ResultResp.code(ResultCode.SUCCESS).data("Hello messi ！！！").build();
    }

}
