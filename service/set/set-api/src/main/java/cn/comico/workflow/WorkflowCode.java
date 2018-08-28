package cn.comico.workflow;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName WorkflowCode
 * @Description TODO
 * @date 2018/8/8 13:31
 **/
public interface WorkflowCode {

    //本体部分
    static final String COMPANY_PRODUCT_CHECK_CODE                      = "0000";    //货品资料审核
    static final String COMPANY_PRODUCT_PRICE_CHECK_CODE                = "0001";    //货品价格审核
    static final String COMPANY_CHANNEL_CHECK_CODE                      = "0002";    //渠道资料审核
    static final String COMPANY_PURCHASE_CHECK_CODE                     = "0003";    //本级采购单审核
    static final String COMPANY_PURCHASE_CHILD_CHECK_CODE              = "0004";    //下级采购单审核
    static final String COMPANY_SUPPLY_CONFIRM_CHECK_CODE               = "0005";    //供应改动待确认审核
    static final String COMPANY_RETURN_CHECK_CODE                       = "0006";    //退货单审核
    static final String COMPANY_RETURN_VIRTUAL_CHECK_CODE               = "0007";    //虚拟退货单审核
    static final String COMPANY_TURN_CONFIRM_CHECK_CODE                 = "0008";    //转仓确认

    //代理部分
    static final String PROXY_PURCHASE_CHECK_CODE                       = "1000";   //本级采购单审核
    static final String PROXY_PURCHASE_CHILD_CHECK_CODE                 = "1001";   //下级采购单审核
    static final String PROXY_SUPPLY_CONFIRM_CHECK_CODE                 = "1002";   //供应改动待确认
    static final String PROXY_SORTING_CONFIRM_CHECK_CODE                = "1003";   //新配货单确认
    static final String PROXY_RETURN_CHECK_CODE                         = "1004";   //本级退货单审核
    static final String PROXY_RETURN_VIRTUAL_CHECK_CODE                 = "1005";   //虚拟退货单审核
    static final String PROXY_SHOP_OUT_CHECK_CODE                       = "1006";   //店铺调货审核

}
