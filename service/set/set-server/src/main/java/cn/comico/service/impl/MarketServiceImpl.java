package cn.comico.service.impl;


import cn.comico.dto.*;
import cn.comico.erp.commons.result.ResultCode;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.erp.commons.spring.BeanUtils;
import cn.comico.repository.SetAdjustionRepository;
import cn.comico.repository.SetMarketSaleRepository;
import cn.comico.repository.SetMarketSortRepository;
import cn.comico.service.IMarketService;
import cn.comico.set.SetAdjustion;
import cn.comico.set.SetMarketSale;
import cn.comico.set.SetMarketSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName MarketServiceImpl
 * @Description TODO
 * @date 2018/7/3 19:29
 **/
@Service
public class MarketServiceImpl implements IMarketService {

    @Autowired
    private SetMarketSaleRepository setMarketSaleRepository;

    @Autowired
    private SetAdjustionRepository setAdjustionRepository;

    @Autowired
    private SetMarketSortRepository setMarketSortRepository;


    @Override
    public ResultResp<List<SetMarketSaleDTO>> findMarketSaleList() {
        List<SetMarketSale> marketSaleList = setMarketSaleRepository.findAll();
        List<SetMarketSaleDTO> setMarketSaleDTOList = BeanUtils.copyList(marketSaleList, SetMarketSaleDTO.class);
        return ResultResp.code(ResultCode.SUCCESS).data(setMarketSaleDTOList).build();
    }

    @Transactional
    @Override
    public ResultResp saveMarketSet(MarketSortDTO marketSortDTO) {
        saveSetAdjust(marketSortDTO.getSetAdjustionDTO());
        saveSetMarketSort(marketSortDTO.getSetMarketSortDTOList());
        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    private void saveSetAdjust(SetAdjustionDTO setAdjustionDTO) {
        SetAdjustion setAdjustion = BeanUtils.copyObject(setAdjustionDTO, SetAdjustion.class);
        setAdjustion.setUpdateDate(new Date());
        setAdjustionRepository.saveAndFlush(setAdjustion);
    }

    private void saveSetMarketSort(List<SetMarketSortDTO> setMarketSortDTOList) {
        Optional.ofNullable(setMarketSortDTOList).orElse(new ArrayList<>())
                .forEach(setMarketSortDTO -> {
                    SetMarketSort setMarketSort = BeanUtils.copyObject(setMarketSortDTO, SetMarketSort.class);
                    setMarketSortRepository.saveAndFlush(setMarketSort);
                });
    }

    @Override
    public ResultResp saveSetMarketSale(List<SetMarketSaleDTO> setMarketSaleDTOList) {
        Optional.ofNullable(setMarketSaleDTOList).orElse(new ArrayList<>())
                .forEach(setMarketSaleDTO -> {
                    SetMarketSale setMarketSale = BeanUtils.copyObject(setMarketSaleDTO, SetMarketSale.class);
                    setMarketSale.setUpdateDate(new Date());
                    setMarketSaleRepository.saveAndFlush(setMarketSale);
                });
        return ResultResp.code(ResultCode.SUCCESS).build();
    }

    @Override
    public ResultResp<MarketSetDTO> getMarketSort() {
        MarketSetDTO marketSetDTO = new MarketSetDTO();
        SetMarketSort bh = setMarketSortRepository.getSetMarketSortByType(SetMarketSort.TYPE_BH);
        if (null != bh) {
            SetMarketSortDTO setMarketSortDTO = BeanUtils.copyObject(bh, SetMarketSortDTO.class);
            marketSetDTO.setSetMarketAdd(setMarketSortDTO);
        }

        SetMarketSort ph  = setMarketSortRepository.getSetMarketSortByType(SetMarketSort.TYPE_PH);
        if (null != ph) {
            SetMarketSortDTO setMarketSortDTO = BeanUtils.copyObject(ph, SetMarketSortDTO.class);
            marketSetDTO.setSetMarketSortDTO(setMarketSortDTO);
        }

        List<SetAdjustion> adjustionList = setAdjustionRepository.findAll();
        if (null != adjustionList && !adjustionList.isEmpty()) {
            SetAdjustionDTO setAdjustionDTO = BeanUtils.copyObject(adjustionList.get(0), SetAdjustionDTO.class);
            marketSetDTO.setSetAdjustionDTO(setAdjustionDTO);
        }
        return ResultResp.code(ResultCode.SUCCESS).data(marketSetDTO).build();
    }

    @Override
    public List<SetMarketSaleDTO> findSetMarektSaleList() {
        List<SetMarketSale> marketSaleList = setMarketSaleRepository.findAll();
        return BeanUtils.copyList(marketSaleList, SetMarketSaleDTO.class);
    }

    @Override
    public SetMarketSortDTO getSetMarketSortAdd() {
        SetMarketSort bh = setMarketSortRepository.getSetMarketSortByType(SetMarketSort.TYPE_BH);
        return BeanUtils.copyObject(bh, SetMarketSortDTO.class);
    }
}
