package cn.comico.erp.commons.constant;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionConstant
 * @Description TODO
 * @date 2018/6/22 15:39
 **/
public interface PermissionConstant {

    //设置
    static final String ROLE_SET_PER_COMPANY_READ                           = "ROLE_SET_PER_COMPANY_READ";                          //总部读
    static final String ROLE_SET_PER_COMPANY_OPERATE                        = "ROLE_SET_PER_COMPANY_OPERATE";                       //总部操作
    static final String ROLE_SET_PER_FIRST_READ                             = "ROLE_SET_PER_FIRST_READ";                            //一级读
    static final String ROLE_SET_PER_FIRST_OPERATE                          = "ROLE_SET_PER_FIRST_OPERATE";                         //一级操作
    static final String ROLE_SET_PER_SECOND_READ                            = "ROLE_SET_PER_SECOND_READ";                           //二级读
    static final String ROLE_SET_PER_SECOND_OPERATE                         = "ROLE_SET_PER_SECOND_OPERATE";                        //二级操作
    static final String ROLE_SET_PER_THIRD_READ                             = "ROLE_SET_PER_THIRD_READ";                            //三级读
    static final String ROLE_SET_PER_THIRD_OPERATE                          = "ROLE_SET_PER_THIRD_OPERATE";                         //三级操作
    static final String ROLE_SET_PER_SHOP_READ                              = "ROLE_SET_PER_SHOP_READ";                             //店铺读
    static final String ROLE_SET_PER_SHOP_OPERATE                           = "ROLE_SET_PER_SHOP_OPERATE";                          //店铺操作
    static final String ROLE_SET_PER_MANAGER_READ                           = "ROLE_SET_PER_MANAGER_READ";                          //管理员读
    static final String ROLE_SET_PER_MANAGER_OPERATE                        = "ROLE_SET_PER_MANAGER_OPERATE";                       //管理严操作
    static final String ROLE_SET_PER_GROUP_READ                             = "ROLE_SET_PER_GROUP_READ";                            //组读
    static final String ROLE_SET_PER_GROUP_OPERATE                          = "ROLE_SET_PER_GROUP_OPERATE";                         //组操作
    static final String ROLE_SET_PER_MARKET_GOODS_READ                      = "ROLE_SET_PER_MARKET_GOODS_READ";                     //市场货品热度读
    static final String ROLE_SET_PER_MARKET_GOODS_OPERATE                   = "ROLE_SET_PER_MARKET_GOODS_OPERATE";                  //市场货品热度权限
    static final String ROLE_SET_PER_MARKET_SORT_READ                       = "ROLE_SET_PER_MARKET_SORT_READ";                      //市场配货读权限
    static final String ROLE_SET_PER_MARKET_SORT_OPERATE                    = "ROLE_SET_PER_MARKET_SORT_OPERATE";                   //市场配货操作权限
    static final String ROLE_SET_PER_WORKFLOW_READ                          = "ROLE_SET_PER_WORKFLOW_READ";                         //流程操作读
    static final String ROLE_SET_PER_WORKFLOW_OPERATE                       = "ROLE_SET_PER_WORKFLOW_OPERATE";                      //流程设置
    static final String ROLE_SET_PER_PROXY_WORKFLOW_READ                    = "ROLE_SET_PER_PROXY_WORKFLOW_READ";                   //代理流程设置
    static final String ROLE_SET_PER_PROXY_WORKFLOW_OPERATE                 = "ROLE_SET_PER_PROXY_WORKFLOW_OPERATE";                //代理流程设置

    //基本资料
    static final String ROLE_INFO_PER_COMPANY_READ                          = "ROLE_INFO_PER_COMPANY_READ";                         //公司基本资料
    static final String ROLE_INFO_PER_COMPANY_OPERATE                       = "ROLE_INFO_PER_COMPANY_OPERATE";                      //公司基本资料操作权限
    static final String ROLE_INFO_PER_COMPANY_SEAL_READ                     = "ROLE_INFO_PER_COMPANY_SEAL_READ";                    //公司电子印章读权限
    static final String ROLE_INFO_PER_COMPANY_SEAL_OPERATE                  = "ROLE_INFO_PER_COMPANY_SEAL_OPERATE";                 //公司电子印章操作权限
    static final String ROLE_INFO_PER_BRAND_READ                            = "ROLE_INFO_PER_BRAND_READ";                           //品牌资料操作权限
    static final String ROLE_INFO_PER_BRAND_OPERATE                         = "ROLE_INFO_PER_BRAND_OPERATE";                        //品牌操作权限
    static final String ROLE_INFO_PER_WORKSHOP_READ                         = "ROLE_INFO_PER_WORKSHOP_READ";                        //生产车间读
    static final String ROLE_INFO_PER_WORKSHOP_OPERATE                      = "ROLE_INFO_PER_WORKSHOP_OPERATE";                     //生产车间操作权限
    static final String ROLE_INFO_PER_STORE_READ                            = "ROLE_INFO_PER_STORE_READ";                           //仓库读
    static final String ROLE_INFO_PER_STORE_OPERATE                         = "ROLE_INFO_PER_STORE_OPERATE";                        //仓库操作权限
    static final String ROLE_INFO_PER_CHANNEL_READ                          = "ROLE_INFO_PER_CHANNEL_READ";                         //渠道读取权限
    static final String ROLE_INFO_PER_CHANNEL_OPERATE                       = "ROLE_INFO_PER_CHANNEL_OPERATE";                      //渠道操作权限
    static final String ROLE_INFO_PER_CHANNEL_NOT_CHECK_READ                = "ROLE_INFO_PER_CHANNEL_NOT_CHECK_READ";               //渠道待审核读权限
    static final String ROLE_INFO_PER_CHANNEL_NOT_CHECK_OPERATE             = "ROLE_INFO_PER_CHANNEL_NOT_CHECK_OPERATE";            //渠道待审核操作权限
    static final String ROLE_INFO_PER_CHANNEL_CHECK_READ                    = "ROLE_INFO_PER_CHANNEL_CHECK_READ";                   //渠道审核读权限
    static final String ROLE_INFO_PER_CHANNEL_CHECK_OPERATE                 = "ROLE_INFO_PER_CHANNEL_CHECK_OPERATE";                //渠道审核操作权限
    static final String ROLE_INFO_PER_PRODUCT_READ                          = "ROLE_INFO_PER_PRODUCT_READ";                         //货品读取权限
    static final String ROLE_INFO_PER_PRODUCT_OPERATE                       = "ROLE_INFO_PER_PRODUCT_OPERATE";                      //货品操作权限
    static final String ROLE_INFO_PER_PRODUCT_NOT_CHECK_READ                = "ROLE_INFO_PER_PRODUCT_NOT_CHECK_READ";               //货品未审核读取
    static final String ROLE_INFO_PER_PRODUCT_NOT_CHECK_OPERATE             = "ROLE_INFO_PER_PRODUCT_NOT_CHECK_OPERATE";            //货品未审核操作
    static final String ROLE_INFO_PER_PRODUCT_CHECK_READ                    = "ROLE_INFO_PER_PRODUCT_CHECK_READ";                   //货品审核读取
    static final String ROLE_INFO_PER_PRODUCT_CHECK_OPERATE                 = "ROLE_INFO_PER_PRODUCT_CHECK_OPERATE";                //货品审核操作
    static final String ROLE_INFO_PER_PRODUCT_PRICE_READ                    = "ROLE_INFO_PER_PRODUCT_PRICE_READ";                   //货品价格读取
    static final String ROLE_INFO_PER_PRODUCT_PRICE_OPERATE                 = "ROLE_INFO_PER_PRODUCT_PRICE_OPERATE";                //货品价格操作
    static final String ROLE_INFO_PER_PRODUCT_PRICE_CHECK_READ              = "ROLE_INFO_PER_PRODUCT_PRICE_CHECK_READ";             //货品价格审核读取
    static final String ROLE_INFO_PER_PRODUCT_PRICE_CHECK_OPERATE           = "ROLE_INFO_PER_PRODUCT_PRICE_CHECK_OPERATE";          //货品价格审核操作
    static final String ROLE_INFO_PER_PRODUCT_PARAM_READ                    = "ROLE_INFO_PER_PRODUCT_PARAM_READ";                   //货品参数读取
    static final String ROLE_INFO_PER_PRODUCT_PARAMS_OPERATE                = "ROLE_INFO_PER_PRODUCT_PARAMS_OPERATE";               //货品参数操作权限

    //供应链
    static final String ROLE_SUPPLY_PER_PURCHASE_READ                       = "ROLE_SUPPLY_PER_PURCHASE_READ";                      //采购订单-新采购单读
    static final String ROLE_SUPPLY_PER_PURCHASE_OPERATE                    = "ROLE_SUPPLY_PER_PURCHASE_OPERATE";                   //采购订单-新采购单操作
    static final String ROLE_SUPPLY_PER_PURCHASE_CHECK_READ                 = "ROLE_SUPPLY_PER_PURCHASE_CHECK_READ";                //采购订单-审核读
    static final String ROLE_SUPPLY_PER_PURCHASE_CHECK_OPERATE              = "ROLE_SUPPLY_PER_PURCHASE_CHECK_OPERATE";             //采购订单-审核操作
    static final String ROLE_SUPPLY_PER_PURCHASE_CONFIRM_READ               = "ROLE_SUPPLY_PER_PURCHASE_CONFIRM_READ";              //采购订单-确认读
    static final String ROLE_SUPPLY_PER_PURCHASE_CONFIRM_OPERATE            = "ROLE_SUPPLY_PER_PURCHASE_CONFIRM_OPERATE";           //采购订单-确认操作
    static final String ROLE_SUPPLY_PER_PURCHASE_SORTING_READ               = "ROLE_SUPPLY_PER_PURCHASE_SORTING_READ";              //采购订单-配货中读
    static final String ROLE_SUPPLY_PER_PURCHASE_SORING_OPERATE             = "ROLE_SUPPLY_PER_PURCHASE_SORING_OPERATE";            //采购订单-配货中操作
    static final String ROLE_SUPPLY_PER_PURCHASE_COMPLETE_READ              = "ROLE_SUPPLY_PER_PURCHASE_COMPLETE_READ";             //采购订单-已完成读
    static final String ROLE_SUPPLY_PER_PURCHASE_COMPLETE_OPERATE           = "ROLE_SUPPLY_PER_PURCHASE_COMPLETE_OPERATE";          //采购订单-已完成操作
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_PURCHASE_READ            = "ROLE_SUPPLY_PER_ORDER_PLAN_PURCHASE_READ";           //订单处理-待计划采购单读
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_PURCHASE_OPERATE         = "ROLE_SUPPLY_PER_ORDER_PLAN_PURCHASE_OPERATE";        //订单处理-待计划采购单操作
    static final String ROLE_SUPPLY_PER_ORDER_MARKET_SORTING_READ           = "ROLE_SUPPLY_PER_ORDER_MARKET_SORTING_READ";          //订单处理-市场调配读
    static final String ROLE_SUPPLY_PER_ORDER_MARKET_SORTING_OPERATE        = "ROLE_SUPPLY_PER_ORDER_MARKET_SORTING_OPERATE";       //订单处理-市场调配操作
    static final String ROLE_SUPPLY_PER_ORDER_MARKET_CONFIRM_READ           = "ROLE_SUPPLY_PER_ORDER_MARKET_CONFIRM_READ";          //订单处理-市场调配确认读
    static final String ROLE_SUPPLY_PER_ORDER_MARKET_CONFIRM_OPERATE        = "ROLE_SUPPLY_PER_ORDER_MARKET_CONFIRM_OPERATE";       //订单处理-市场调配确认读
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_PRODUCE_READ             = "ROLE_SUPPLY_PER_ORDER_PLAN_PRODUCE_READ";            //订单处理-计划生产读
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_PRODUCE_OPERATE          = "ROLE_SUPPLY_PER_ORDER_PLAN_PRODUCE_OPERATE";         //订单处理-计划生产操作
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_CONFIRM_READ             = "ROLE_SUPPLY_PER_ORDER_PLAN_CONFIRM_READ";            //订单处理-计划生产确认读
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_CONFIRM_OPERATE          = "ROLE_SUPPLY_PER_ORDER_PLAN_CONFIRM_OPERATE";         //订单处理-计划生产确认操作
    static final String ROLE_SUPPLY_PER_ORDER_CUSTOMER_CONFIRM_READ         = "ROLE_SUPPLY_PER_ORDER_CUSTOMER_CONFIRM_READ";        //订单处理-客户确认读
    static final String ROLE_SUPPLY_PER_ORDER_CUSTOMER_CONFIRM_OPERATE      = "ROLE_SUPPLY_PER_ORDER_CUSTOMER_CONFIRM_OPERATE";     //订单处理-客户确认操作
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_RECORD_READ              = "ROLE_SUPPLY_PER_ORDER_PLAN_RECORD_READ";             //订单处理-计划记录读
    static final String ROLE_SUPPLY_PER_ORDER_PLAN_RECORD_OPERATE           = "ROLE_SUPPLY_PER_ORDER_PLAN_RECORD_OPERATE";          //订单处理-计划记录操作
    static final String ROLE_SUPPLY_PER_PLAN_DEAL_READ                      = "ROLE_SUPPLY_PER_PLAN_DEAL_READ";                     //计划单-处理中读
    static final String ROLE_SUPPLY_PER_PLAN_DEAL_OPERATE                   = "ROLE_SUPPLY_PER_PLAN_DEAL_OPERATE";                  //计划单-处理中操作
    static final String ROLE_SUPPLY_PER_PLAN_COMPLETE_READ                  = "ROLE_SUPPLY_PER_PLAN_COMPLETE_READ";                 //计划单-已完成读
    static final String ROLE_SUPPLY_PER_PLAN_COMPLETE_OPERATE               = "ROLE_SUPPLY_PER_PLAN_COMPLETE_OPERATE";              //计划单-已完成操作
    static final String ROLE_SUPPLY_PER_PRODUCED_RECEIPT_READ               = "ROLE_SUPPLY_PER_PRODUCED_RECEIPT_READ";              //生产来货-新入库单读
    static final String ROLE_SUPPLY_PER_PRODUCED_RECEIPT_OPERATE            = "ROLE_SUPPLY_PER_PRODUCED_RECEIPT_OPERATE";           //生产来货-新入库单操作
    static final String ROLE_SUPPLY_PER_PRODUCED_ENTERING_READ              = "ROLE_SUPPLY_PER_PRODUCED_ENTERING_READ";             //生产来货-录入识别码读
    static final String ROLE_SUPPLY_PER_PRODUCED_ENTERING_OPERATE           = "ROLE_SUPPLY_PER_PRODUCED_ENTERING_OPERATE";          //生产来货-录入识别码操作
    static final String ROLE_SUPPLY_PER_PRODUCED_CONFIRM_READ               = "ROLE_SUPPLY_PER_PRODUCED_CONFIRM_READ";              //生产来货-确认入库读
    static final String ROLE_SUPPLY_PER_PRODUCED_CONFIRM_OPERATE            = "ROLE_SUPPLY_PER_PRODUCED_CONFIRM_OPERATE";           //生产来货-确认入库操作
    static final String ROLE_SUPPLY_PER_PRODUCED_COMPLETE_READ              = "ROLE_SUPPLY_PER_PRODUCED_COMPLETE_READ";             //生产来货-已完成读
    static final String ROLE_SUPPLY_PER_PRODUCED_COMPLETE_OPERATE           = "ROLE_SUPPLY_PER_PRODUCED_COMPLETE_OPERATE";          //生产来货-已完成操作
    static final String ROLE_SUPPLY_PER_SORTING_READ                        = "ROLE_SUPPLY_PER_SORTING_READ";                       //市场配货待配货读
    static final String ROLE_SUPPLY_PER_SORTING_OPERATE                     = "ROLE_SUPPLY_PER_SORTING_OPERATE";                    //市场配货待配货操作
    static final String ROLE_SUPPLY_PER_SORTING_COMPLETE_READ               = "ROLE_SUPPLY_PER_SORTING_COMPLETE_READ";              //市场配货已配完读
    static final String ROLE_SUPPLY_PER_SORTING_COMPLETE_OPERATE            = "ROLE_SUPPLY_PER_SORTING_COMPLETE_OPERATE";           //市场配货已配完操作
    static final String ROLE_SUPPLY_PER_RETURN_READ                         = "ROLE_SUPPLY_PER_RETURN_READ";                        //新退货单读
    static final String ROLE_SUPPLY_PER_RETURN_OPERATE                      = "ROLE_SUPPLY_PER_RETURN_OPERATE";                     //新退货单操作
    static final String ROLE_SUPPLY_PER_RETURN_COMPLETE_READ                = "ROLE_SUPPLY_PER_RETURN_COMPLETE_READ";               //市场退货已完成读
    static final String ROLE_SUPPLY_PER_RETURN_COMPLETE_OPERATE             = "ROLE_SUPPLY_PER_RETURN_COMPLETE_OPERATE";            //市场退货已完成操作

    //供应链（代理）
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_READ                 = "ROLE_SUPPLY_PER_PROXY_PURCHASE_READ";                //代理采购订单-新采购单读
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_OPERATE              = "ROLE_SUPPLY_PER_PROXY_PURCHASE_OPERATE";             //代理采购单-新采购单操作
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_CHECK_READ           = "ROLE_SUPPLY_PER_PROXY_PURCHASE_CHECK_READ";          //代理采购单-审核读
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_CHECK_OPERATE        = "ROLE_SUPPLY_PER_PROXY_PURCHASE_CHECK_OPERATE";       //代理采购单-审核操作
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_CONFIRM_READ         = "ROLE_SUPPLY_PER_PROXY_PURCHASE_CONFIRM_READ";        //代理采购单-供应确认读
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_CONFIRM_OPERATE      = "ROLE_SUPPLY_PER_PROXY_PURCHASE_CONFIRM_OPERATE";     //代理采购单-供应确认操作
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_SORTING_READ         = "ROLE_SUPPLY_PER_PROXY_PURCHASE_SORTING_READ";        //代理采购单-配货中读
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_SORTING_OPERATE      = "ROLE_SUPPLY_PER_PROXY_PURCHASE_SORTING_OPERATE";     //代理采购单-配货中操作
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_COMPLETE_READ        = "ROLE_SUPPLY_PER_PROXY_PURCHASE_COMPLETE_READ";       //代理采购单-已完成读
    static final String ROLE_SUPPLY_PER_PROXY_PURCHASE_COMPLETE_OPERATE     = "ROLE_SUPPLY_PER_PROXY_PURCHASE_COMPLETE_OPERATE";    //代理采购单-已完成操作
    static final String ROLE_SUPPLY_PER_PROXY_RECEIPT_SORTING_READ          = "ROLE_SUPPLY_PER_PROXY_RECEIPT_SORTING_READ";         //代理收货-新配货单读
    static final String ROLE_SUPPLY_PER_PROXY_RECEIPT_SORTING_OPERATE       = "ROLE_SUPPLY_PER_PROXY_RECEIPT_SORTING_OPERATE";      //代理收货-新配货单操作
    static final String ROLE_SUPPLY_PER_PROXY_RECEIPT_RECEIPTING_READ       = "ROLE_SUPPLY_PER_PROXY_RECEIPT_RECEIPTING_READ";      //代理收货-收货中读
    static final String ROLE_SUPPLY_PER_PROXY_RECEIPT_RECEIPTING_OPERATE    = "ROLE_SUPPLY_PER_PROXY_RECEIPT_RECEIPTING_OPERATE";   //代理收货-收货中操作
    static final String ROLE_SUPPLY_PER_PROXY_RECEIPT_COMPLETE_READ         = "ROLE_SUPPLY_PER_PROXY_RECEIPT_COMPLETE_READ";        //代理收货-已完成读
    static final String ROLE_SUPPLY_PER_PROXY_RECEIPT_COMPLETE_OPERATE      = "ROLE_SUPPLY_PER_PROXY_RECEIPT_COMPLETE_OPERATE";     //代理收货-已完成操作
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_READ                   = "ROLE_SUPPLY_PER_PROXY_RETURN_READ";                  //代理退货-新退货单读
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_OPERATE                = "ROLE_SUPPLY_PER_PROXY_RETURN_OPERATE";               //代理退货-新退货单操作
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_CHECK_READ             = "ROLE_SUPPLY_PER_PROXY_RETURN_CHECK_READ";            //代理退货-审核读
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_CHECK_OPERATE          = "ROLE_SUPPLY_PER_PROXY_RETURN_CHECK_OPERATE";         //代理退货-审核操作
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_CONFIRM_READ           = "ROLE_SUPPLY_PER_PROXY_RETURN_CONFIRM_READ";          //代理退货-供应确认读
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_CONFIRM_OPERATE        = "ROLE_SUPPLY_PER_PROXY_RETURN_CONFIRM_OPERATE";       //代理退货-供应确认操作
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_NOT_DELIVERY_READ      = "ROLE_SUPPLY_PER_PROXY_RETURN_NOT_DELIVERY_READ";     //代理退货-待出库读
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_NOT_DELIVERY_OPERATE   = "ROLE_SUPPLY_PER_PROXY_RETURN_NOT_DELIVERY_OPERATE";  //代理退货-待出库操作
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_RETURNING_READ         = "ROLE_SUPPLY_PER_PROXY_RETURN_RETURNING_READ";        //代理退货-退货中读
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_RETURNING_OPERATE      = "ROLE_SUPPLY_PER_PROXY_RETURN_RETURNING_OPERATE";     //代理退货-退货中操作
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_COMPLETE_READ          = "ROLE_SUPPLY_PER_PROXY_RETURN_COMPLETE_READ";         //代理退货-已完成读
    static final String ROLE_SUPPLY_PER_PROXY_RETURN_COMPLETE_OPERATE       = "ROLE_SUPPLY_PER_PROXY_RETURN_COMPLETE_OPERATE";      //代理退货-已完成操作
    static final String ROLE_SUPPLY_PER_PROXY_TURN_READ                     = "ROLE_SUPPLY_PER_PROXY_TURN_READ";                    //店铺调货-新调货单读
    static final String ROLE_SUPPLY_PER_PROXY_TURN_OPERATE                  = "ROLE_SUPPLY_PER_PROXY_TURN_OPERATE";                 //店铺调货-新调货单操作
    static final String ROLE_SUPPLY_PER_PROXY_TURN_CHECK_READ               = "ROLE_SUPPLY_PER_PROXY_TURN_CHECK_READ";              //店铺调货-审核读
    static final String ROLE_SUPPLY_PER_PROXY_TURN_CHECK_OPERATE            = "ROLE_SUPPLY_PER_PROXY_TURN_CHECK_OPERATE";           //店铺调货-审核操作
    static final String ROLE_SUPPLY_PER_PROXY_TURN_TURNNING_READ            = "ROLE_SUPPLY_PER_PROXY_TURN_TURNNING_READ";           //店铺调货-调货中读
    static final String ROLE_SUPPLY_PER_PROXY_TURN_TURNNING_OPERATE         = "ROLE_SUPPLY_PER_PROXY_TURN_TURNNING_OPERATE";        //店铺调货-调货中操作
    static final String ROLE_SUPPLY_PER_PROXY_TURN_COMPLETE_READ            = "ROLE_SUPPLY_PER_PROXY_TURN_COMPLETE_READ";           //店铺调货-已完成读
    static final String ROLE_SUPPLY_PER_PROXY_TURN_COMPLETE_OPERATE         = "ROLE_SUPPLY_PER_PROXY_TURN_COMPLETE_OPERATE";        //店铺调货-已完成操作
}
