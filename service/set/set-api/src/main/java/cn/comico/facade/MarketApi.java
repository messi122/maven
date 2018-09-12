package cn.comico.facade;


import cn.comico.dto.MarketSetDTO;
import cn.comico.dto.MarketSortDTO;
import cn.comico.dto.SetMarketSaleDTO;
import cn.comico.dto.SetMarketSortDTO;
import cn.comico.erp.commons.result.ResultResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName MarketApi
 * @Description TODO
 * @date 2018/7/3 18:12
 **/
@Api(tags = "市场参数")
@RequestMapping(value = "/market")
public interface MarketApi {

    /**
    *
    * @author      changhuanhu
    * @Description 查询货品热度状态
    * @Param []
    * @exception
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.SetMarketSaleDTO>>
    * @Date 2018/7/3 18:40
    **/
    @ApiOperation(value = "查询货品状态")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MARKET_GOODS_READ)")
    @GetMapping(value = "/sale")
    ResultResp<List<SetMarketSaleDTO>> findMarektSaleList();

    /**
    * 
    * @author      changhuanhu
    * @Description 保存货品热度状态
    * @Param [setMarketSaleDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/11 9:20
    **/
    @ApiOperation(value = "保存货品状态")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MARKET_GOODS_OPERATE)")
    @PostMapping(value = "/sale")
    ResultResp saveProductStatus(List<SetMarketSaleDTO> setMarketSaleDTOList);

    /**
    *
    * @author      changhuanhu
    * @Description 查询配货设置
    * @Param []
    * @exception
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.service.set.api.dto.SetMarketSortDTO>
    * @Date 2018/7/3 18:57
    **/
    @ApiOperation(value = "查询配货设置")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MARKET_SORT_READ)")
    @GetMapping(value = "/sort")
    ResultResp<MarketSetDTO> getSorting();

    /**
    *
    * @author      changhuanhu
    * @Description 保存市场参数设置
    * @Param [marketSetSaveDTO]
    * @exception
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/3 19:26
    **/
    @ApiOperation(value = "保存市场设置")
    @PreAuthorize("hasAuthority(T(cn.comico.erp.commons.constant.PermissionConstant).ROLE_SET_PER_MARKET_SORT_OPERATE)")
    @PostMapping(value = "/sort")
    ResultResp saveMarketSet(MarketSortDTO marketSetSaveDTO);


    /**
    * 
    * @author      changhuanhu
    * @Description 获取市场参数设置
    * @Param []
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.SetMarketSaleDTO>>
    * @Date 2018/7/31 18:33
    **/
    @ApiIgnore
    @GetMapping(value = "/setMarketSales")
    List<SetMarketSaleDTO> findSetMarektSaleList();

    /**
    * 
    * @author      changhuanhu
    * @Description 查询货品补货色设置
    * @Param []
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.SetMarketSortDTO
    * @Date 2018/8/1 11:16
    **/
    @ApiIgnore
    @GetMapping(value = "/sort/sortAdd")
    SetMarketSortDTO getSetMarketSortAdd();
}
