package cn.comico.erp.commons.spring;

import cn.comico.erp.commons.exception.CommonException;
import cn.comico.erp.commons.result.ResultCode;
import org.springframework.validation.BindingResult;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName BaseController
 * @Description TODO
 * @date 2018/7/24 14:42
 **/
public class BaseController {

    /**
    * 
    * @author      changhuanhu
    * @Description 验证参数
    * @Param [bindingResult]
    * @exception   
    * @return      void
    * @Date 2018/7/24 14:52
    **/
    protected void valid(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            throw new CommonException(ResultCode.PARAM_ERROR, message);
        }
    }

}
