package cn.comico.workflow;


import cn.comico.dto.SetWorkflowDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName WorkflowContent
 * @Description TODO 流程设置内容枚举
 * @date 2018/8/8 10:24
 **/
public enum WorkflowContent {

    //公司本体部分
    COMPANY_PRODUCT_CHECK               (0, WorkflowCode.COMPANY_PRODUCT_CHECK_CODE,            "货品资料审核", WorkflowModule.INFO),
    COMPANY_PRODUCT_PRICE_CHECK         (0, WorkflowCode.COMPANY_PRODUCT_PRICE_CHECK_CODE,      "货品价格审核", WorkflowModule.INFO),
    COMPANY_CHANNEL_CHECK               (0, WorkflowCode.COMPANY_CHANNEL_CHECK_CODE,            "渠道资料审核", WorkflowModule.INFO),
    COMPANY_PURCHASE_CHECK              (0, WorkflowCode.COMPANY_PURCHASE_CHECK_CODE,           "本级采购单审核", WorkflowModule.SUPPLY),
    COMPANY_PPURCHASE_CHILD_CHECK       (0, WorkflowCode.COMPANY_PURCHASE_CHILD_CHECK_CODE,     "下级采购单审核", WorkflowModule.SUPPLY),
    COMPANY_SUPPLY_CONFIRM_CHECK        (0, WorkflowCode.COMPANY_SUPPLY_CONFIRM_CHECK_CODE,     "供应改动待确认", WorkflowModule.SUPPLY),
    COMPANY_RETURN_CHECK                (0, WorkflowCode.COMPANY_RETURN_CHECK_CODE,             "退货单审核", WorkflowModule.SUPPLY),
    COMPANY_RETURN_VIRTUAL_CHECK        (0, WorkflowCode.COMPANY_RETURN_VIRTUAL_CHECK_CODE,     "虚拟退货审核", WorkflowModule.SUPPLY),
    COMPANY_TURN_CONFIRM_CHECK          (0, WorkflowCode.COMPANY_TURN_CONFIRM_CHECK_CODE,       "转仓确认", WorkflowModule.STORE),

    //代理部分
    PROXY_PURCHASE_CHECK                (1, WorkflowCode.PROXY_PURCHASE_CHECK_CODE,              "本级采购单审核", WorkflowModule.SUPPLY),
    PROXY_PURCHASE_CHILD_CHECK          (1, WorkflowCode.PROXY_PURCHASE_CHILD_CHECK_CODE,       "下级采购单审核", WorkflowModule.SUPPLY),
    PROXY_SUPPLY_CONFIRM_CHECK          (1, WorkflowCode.PROXY_SUPPLY_CONFIRM_CHECK_CODE,       "供应改动待确认", WorkflowModule.SUPPLY),
    PROXY_SORTING_CONFIRM_CHECK         (1, WorkflowCode.PROXY_SORTING_CONFIRM_CHECK_CODE,      "新配货单确认", WorkflowModule.SUPPLY),
    PROXY_RETURN_CHECK                  (1, WorkflowCode.PROXY_RETURN_CHECK_CODE,               "本级退货单审核", WorkflowModule.SUPPLY),
    PROXY_RETURN_VIRTUAL_CHECK          (1, WorkflowCode.PROXY_RETURN_VIRTUAL_CHECK_CODE,       "虚拟退货单审核", WorkflowModule.SUPPLY),
    PROXY_SHOP_OUT_CHECK                (1, WorkflowCode.PROXY_SHOP_OUT_CHECK_CODE,             "店铺调货审核", WorkflowModule.SUPPLY);

    private int type;

    private String code;

    private String content;

    private WorkflowModule workflowModule;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WorkflowModule getWorkflowModule() {
        return workflowModule;
    }

    public void setWorkflowModule(WorkflowModule workflowModule) {
        this.workflowModule = workflowModule;
    }

    WorkflowContent(int type, String code, String content, WorkflowModule workflowModule) {
        this.type = type;
        this.code = code;
        this.content = content;
        this.workflowModule = workflowModule;
    }

    public static List<SetWorkflowDTO> get(int type, Long channelId, int level) {
        List<SetWorkflowDTO> setWorkflowDTOList = new ArrayList<>();
        WorkflowContent[] values = values();
        for(WorkflowContent workflowContent : values) {
            if (workflowContent.type == type) {
                SetWorkflowDTO setWorkflowDTO = new SetWorkflowDTO();
                setWorkflowDTO.setChannelId(channelId);
                setWorkflowDTO.setCode(workflowContent.getCode());
                setWorkflowDTO.setLevel(level);
                setWorkflowDTO.setName(workflowContent.getContent());
                setWorkflowDTO.setPermissionId(workflowContent.getWorkflowModule().getId());
                setWorkflowDTO.setPermissionName(workflowContent.getWorkflowModule().getName());
                setWorkflowDTO.setStatus(0);
                Collections.addAll(setWorkflowDTOList, setWorkflowDTO);
            }
        }
        return setWorkflowDTOList;
    }
}
