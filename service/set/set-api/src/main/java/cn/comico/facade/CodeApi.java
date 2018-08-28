package cn.comico.facade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName CodeApi
 * @Description TODO    单号API
 * @date 2018/7/23 18:20
 **/
@Api(tags = "单号")
@RequestMapping(value = "/code")
public interface CodeApi {

    /**
    * 
    * @author      changhuanhu
    * @Description 生成销售单号
    * @Param []
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 18:24
    **/
    @ApiOperation(value = "销售单号")
    @GetMapping(value = "/sale")
    String generateSaleCode();

    /**
    *
    * @author      changhuanhu
    * @Description 生成采购单号
    * @Param []
    * @exception
    * @return      java.lang.String
    * @Date 2018/7/23 18:24
    **/
    @ApiOperation(value = "采购单号")
    @GetMapping(value = "/cg")
    String generateCGCode();

    /**
    * 
    * @author      changhuanhu
    * @Description 生成入库单号
    * @Param []
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 18:26
    **/
    @ApiOperation(value = "入库单号")
    @GetMapping(value = "/rk")
    String generateRKCode();


    /**
    * @author yuyong
    * @Description 生成配货单号
    * @param []
    * @return java.lang.String
    * @date 2018/8/9 9:25
    */
    @ApiOperation(value = "配货单号")
    @GetMapping(value = "/ph")
    String generatePHCode();


    /**
    * @author yuyong
    * @Description 生成计划单号
    * @param []
    * @return java.lang.String
    * @date 2018/8/9 18:32
    */
    @ApiOperation(value = "计划单号")
    @GetMapping(value = "/jh")
    String generateJHCode(Long channelId);


    /**
    * @author yuyong
    * @Description  生成退货单号
    * @param []
    * @return java.lang.String
    * @date 2018/8/10 10:46
    */
    @ApiOperation(value = "退货单号")
    @GetMapping(value = "/th")
    String generateTHCode();

}
