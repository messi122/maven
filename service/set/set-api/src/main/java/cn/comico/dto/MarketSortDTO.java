package cn.comico.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName MarketSetSaveDTO
 * @Description TODO
 * @date 2018/7/3 19:18
 **/
public class MarketSortDTO implements Serializable {

    private SetAdjustionDTO setAdjustionDTO;

    private List<SetMarketSortDTO> setMarketSortDTOList;

    public SetAdjustionDTO getSetAdjustionDTO() {
        return setAdjustionDTO;
    }

    public void setSetAdjustionDTO(SetAdjustionDTO setAdjustionDTO) {
        this.setAdjustionDTO = setAdjustionDTO;
    }

    public List<SetMarketSortDTO> getSetMarketSortDTOList() {
        return setMarketSortDTOList;
    }

    public void setSetMarketSortDTOList(List<SetMarketSortDTO> setMarketSortDTOList) {
        this.setMarketSortDTOList = setMarketSortDTOList;
    }
}
