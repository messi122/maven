package cn.comico.params;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName ParamsConfigKeyConstant
 * @Description TODO
 * @date 2018/7/23 11:53
 **/
public interface ParamsConfigKeyConstant {

    int PULL_SIZE   = 2000;                                             //大小
    int LENGTH   = 4;                                             //长度

    String GROUP_NAME = "code";                                         //编号

    String ERP_MARKET_SALE_ORDER_PREFIX = "xs";                                 //销售订单前缀
    String ERP_MARKET_RK_ORDER_PREFIX = "rk";                                   //入库订单前缀
    String ERP_MARKET_CG_ORDER_PREFIX = "cg";                                   //采购订单前缀
    String ERP_MARKET_PH_ORDER_PREFIX = "ph";                                   //配货订单前缀
    String ERP_MARKET_JH_ORDER_PREFIX = "jh";                                   //计划订单前缀
    String ERP_MARKET_TH_ORDER_PREFIX = "th";                                   //退货订单前缀


    String ERP_MARKET_SALE_ORDER_KEY    = "erp_market_sale_order_key";           //市场销售订单key
    String ERP_MARKET_RK_ORDER_KEY      = "erp_market_rk_order_key";            //市场入库订单key
    String ERP_MARKET_CG_ORDER_KEY      = "erp_market_cg_order_key";            //市场采购订单key
    String ERP_MARKET_PH_ORDER_KEY      = "erp_market_ph_order_key";            //市场配货订单key
    String ERP_MARKET_JH_ORDER_KEY      = "erp_market_jh_order_key";            //市场计划订单key
    String ERP_MARKET_TH_ORDER_KEY      = "erp_market_th_order_key";            //市场退货订单key

}
