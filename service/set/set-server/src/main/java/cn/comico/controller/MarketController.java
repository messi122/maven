package cn.comico.controller;


import cn.comico.dto.MarketSetDTO;
import cn.comico.dto.MarketSortDTO;
import cn.comico.dto.SetMarketSaleDTO;
import cn.comico.dto.SetMarketSortDTO;
import cn.comico.facade.MarketApi;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.service.IMarketService;
import cn.comico.supply.dto.MarketSetDTO;
import cn.comico.supply.dto.MarketSortDTO;
import cn.comico.supply.dto.SetMarketSaleDTO;
import cn.comico.supply.dto.SetMarketSortDTO;
import cn.comico.supply.erp.commons.result.ResultResp;
import cn.comico.supply.facade.MarketApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName MarketController
 * @Description TODO
 * @date 2018/7/3 19:26
 **/
@RestController
public class MarketController implements MarketApi {

    @Autowired
    private IMarketService marketService;

    @Override
    public ResultResp<List<SetMarketSaleDTO>> findMarektSaleList() {
        return marketService.findMarketSaleList();
    }

    @Override
    public ResultResp saveProductStatus(@RequestBody List<SetMarketSaleDTO> setMarketSaleDTOList) {

        return marketService.saveSetMarketSale(setMarketSaleDTOList);
    }

    @Override
    public ResultResp<MarketSetDTO> getSorting() {
        return marketService.getMarketSort();
    }

    @Override
    public ResultResp saveMarketSet(@RequestBody MarketSortDTO marketSortDTO) {
        return marketService.saveMarketSet(marketSortDTO);
    }

    @Override
    public List<SetMarketSaleDTO> findSetMarektSaleList() {
        return marketService.findSetMarektSaleList();
    }

    @Override
    public SetMarketSortDTO getSetMarketSortAdd() {
        return marketService.getSetMarketSortAdd();
    }


}
