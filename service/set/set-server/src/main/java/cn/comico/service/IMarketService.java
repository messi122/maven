package cn.comico.service;


import cn.comico.dto.MarketSetDTO;
import cn.comico.dto.MarketSortDTO;
import cn.comico.dto.SetMarketSaleDTO;
import cn.comico.dto.SetMarketSortDTO;
import cn.comico.erp.commons.result.ResultResp;


import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName IMarketService
 * @Description TODO
 * @date 2018/7/3 19:29
 **/
public interface IMarketService {

    /**
    * 
    * @author      changhuanhu
    * @Description 查询货品热度设置
    * @Param []
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.SetMarketSaleDTO>>
    * @Date 2018/7/3 19:37
    **/
    ResultResp<List<SetMarketSaleDTO>> findMarketSaleList();

    /**
    * 
    * @author      changhuanhu
    * @Description 保存市场配货设置
    * @Param [marketSortDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/11 9:49
    **/
    ResultResp saveMarketSet(MarketSortDTO marketSortDTO);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存货品热度设置
    * @Param [setMarketSaleDTOList]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/11 9:43
    **/
    ResultResp saveSetMarketSale(List<SetMarketSaleDTO> setMarketSaleDTOList);

    /**
    * 
    * @author      changhuanhu
    * @Description 获取市场配货
    * @Param []
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.service.set.api.dto.MarketSetDTO>
    * @Date 2018/7/11 9:58
    **/
    ResultResp<MarketSetDTO> getMarketSort();

    /**
    * 
    * @author      changhuanhu
    * @Description 获取市场参数设置
    * @Param []
    * @exception   
    * @return      java.util.List<cn.comico.erp.service.set.api.dto.SetMarketSaleDTO>
    * @Date 2018/7/31 18:35
    **/
    List<SetMarketSaleDTO> findSetMarektSaleList();

    /**
    * 
    * @author      changhuanhu
    * @Description 查询补货色设置
    * @Param []
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.SetMarketSortDTO
    * @Date 2018/8/1 11:18
    **/
    SetMarketSortDTO getSetMarketSortAdd();
    
}
