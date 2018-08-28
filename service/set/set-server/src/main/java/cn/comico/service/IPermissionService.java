package cn.comico.service;


import cn.comico.dto.ManagerPermissionDTO;
import cn.comico.dto.PermissionDTO;
import cn.comico.dto.PermissionDetailDTO;
import cn.comico.dto.PermissionFirstDTO;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.supply.dto.ManagerPermissionDTO;
import cn.comico.supply.dto.PermissionDetailDTO;
import cn.comico.supply.dto.PermissionFirstDTO;
import cn.comico.supply.erp.commons.result.ResultResp;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName IPermissionService
 * @Description TODO
 * @date 2018/6/25 14:43
 **/
public interface IPermissionService {


   /**
   * 
   * @author      changhuanhu
   * @Description 查询菜单级别
   * @Param [type, level, menuLevl]
   * @exception   
   * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDTO>>
   * @Date 2018/6/25 18:42
   **/
    ResultResp<List<PermissionDTO>> findPermission(int type, int level, int menuLevl);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询权限详情
    * @Param [id, type, level, menuLevel]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionDetailDTO>>
    * @Date 2018/6/26 14:37
    **/
    ResultResp<List<PermissionDetailDTO>> getPermissionDetail(Long id, int type, int level, int menuLevel);

 
    /**
    * 
    * @author      changhuanhu
    * @Description 更新权限
    * @Param [list]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/6/26 19:10
    **/
    ResultResp updatePermission(List<ManagerPermissionDTO> list);

    /**
    * 
    * @author      changhuanhu
    * @Description 根据类型查询一级菜单、二级菜单、三级菜单
    * @Param [type]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.PermissionFirstDTO>>
    * @Date 2018/7/2 9:14
    **/
    ResultResp<List<PermissionFirstDTO>> findPermissionByType(Integer type);
}
