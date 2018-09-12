package cn.comico.params;


import cn.comico.feign.ChannelPrefixServiceClient;
import cn.comico.erp.commons.common.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName CodeGenerator
 * @Description TODO
 * @date 2018/7/23 13:36
 **/
@Component
public class CodeGenerator {

    @Autowired
    private Generator generator;

    @Autowired
    private ChannelPrefixServiceClient channelServiceClient;


    /**
    * 
    * @author      changhuanhu
    * @Description 生产长度为len的字符串，不足用c填充
    * @Param [str, len, c]
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 13:43
    **/
    public String lpad(String str, int len, char c) {
        if (str.length() >= len) {
            return str;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, l = len - str.length(); i < l; i++) {
            stringBuilder.append(c);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 字符串添加前缀
    * @Param [prefix, str]
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 13:44
    **/
    public String prefix(String prefix, String str) {

        return prefix + str;
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 连接字符串
    * @Param [strs]
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 17:43
    **/
    public String concat(String... strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0, len = strs.length; i < len; i++) {
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取销售单编号
    * @Param []
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 18:14
    **/
    public String generateSaleCode() {
        return concat(ParamsConfigKeyConstant.ERP_MARKET_SALE_ORDER_PREFIX
                , DateUtil.getDay()
                , lpad(generator.generate(ParamsConfigKeyConstant.ERP_MARKET_SALE_ORDER_KEY), ParamsConfigKeyConstant.LENGTH, '0'));
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 获取采购单单号
    * @Param []
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 18:14
    **/
    public String generateCGCode() {
        return concat(ParamsConfigKeyConstant.ERP_MARKET_CG_ORDER_PREFIX
                , DateUtil.getDay()
                , lpad(generator.generate(ParamsConfigKeyConstant.ERP_MARKET_CG_ORDER_KEY), ParamsConfigKeyConstant.LENGTH, '0'));
    }

    /**
    * 
    * @author      changhuanhu
    * @Description 生成入库单号
    * @Param []
    * @exception   
    * @return      java.lang.String
    * @Date 2018/7/23 18:20
    **/
    public String generateRKCode() {
        return concat(ParamsConfigKeyConstant.ERP_MARKET_RK_ORDER_PREFIX
                , DateUtil.getDay()
                , lpad(generator.generate(ParamsConfigKeyConstant.ERP_MARKET_RK_ORDER_KEY), ParamsConfigKeyConstant.LENGTH, '0'));
    }

    /**
    * @author yuyong
    * @Description   生成配货单号
    * @param
    * @return java.lang.String
    * @date 2018/8/9 16:43
    */
    public String generatePHCode() {
        return concat(ParamsConfigKeyConstant.ERP_MARKET_PH_ORDER_PREFIX
                , DateUtil.getDay()
                , lpad(generator.generate(ParamsConfigKeyConstant.ERP_MARKET_PH_ORDER_KEY), ParamsConfigKeyConstant.LENGTH, '0'));
    }

    /**
    * @author yuyong
    * @Description  生成计划单号
    * @param [channelId]
    * @return java.lang.String
    * @date 2018/8/10 9:11
    */
    public String generateJHCode(Long channelId) {
        String channelPrefix = channelServiceClient.findChannelPrefix(channelId);

        return concat(channelPrefix ==null ?"":channelPrefix
                , DateUtil.getDay()
                , lpad(generator.generate(ParamsConfigKeyConstant.ERP_MARKET_JH_ORDER_KEY), ParamsConfigKeyConstant.LENGTH, '0'));
    }

    public String generateTHCode() {
        return concat(ParamsConfigKeyConstant.ERP_MARKET_TH_ORDER_PREFIX
                , DateUtil.getDay()
                , lpad(generator.generate(ParamsConfigKeyConstant.ERP_MARKET_TH_ORDER_KEY), ParamsConfigKeyConstant.LENGTH, '0'));
    }
}
