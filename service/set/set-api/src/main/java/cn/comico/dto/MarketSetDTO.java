package cn.comico.dto;

import java.io.Serializable;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName MarketSetDTO
 * @Description TODO
 * @date 2018/7/11 9:12
 **/
public class MarketSetDTO implements Serializable {

    /*可配货货品*/
    private SetAdjustionDTO setAdjustionDTO;

    /*补货建议设置*/
    private SetMarketSortDTO setMarketAdd;

    /*配货设置*/
    private SetMarketSortDTO setMarketSortDTO;

    public SetAdjustionDTO getSetAdjustionDTO() {
        return setAdjustionDTO;
    }

    public void setSetAdjustionDTO(SetAdjustionDTO setAdjustionDTO) {
        this.setAdjustionDTO = setAdjustionDTO;
    }

    public SetMarketSortDTO getSetMarketAdd() {
        return setMarketAdd;
    }

    public void setSetMarketAdd(SetMarketSortDTO setMarketAdd) {
        this.setMarketAdd = setMarketAdd;
    }

    public SetMarketSortDTO getSetMarketSortDTO() {
        return setMarketSortDTO;
    }

    public void setSetMarketSortDTO(SetMarketSortDTO setMarketSortDTO) {
        this.setMarketSortDTO = setMarketSortDTO;
    }
}
