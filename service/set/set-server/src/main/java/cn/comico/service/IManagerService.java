package cn.comico.service;



import cn.comico.dto.ManagerDTO;
import cn.comico.dto.ManagerLoginDTO;
import cn.comico.dto.ManagerSaveDTO;
import cn.comico.dto.MenuDTO;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;

import java.util.List;

public interface IManagerService {

    List<ManagerDTO> findAll();

    ManagerDTO save(ManagerDTO managerDTO);

    ManagerLoginDTO login(String username, String password);

    ResultResp<ManagerSaveDTO> getOne(Long id);

    /**
     *
     * @param id
     * @return
     */
//    ResultResp<List<FirstMenuDTO>> listPermission(Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 根据关键字查询管理员
    * @Param [keywords, offset, pageSize]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.commons.result.DataGrid<cn.comico.erp.service.set.api.dto.ManagerDTO>>
    * @Date 2018/6/25 14:21
    **/
    ResultResp<DataGrid<ManagerDTO>> search(String keywords, Long offset, Long pageSize);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询菜单权限
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<java.util.List<cn.comico.erp.service.set.api.dto.MenuDTO>>
    * @Date 2018/6/25 16:27
    **/
    ResultResp<List<MenuDTO>> listPermission(Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 刷新access_token
    * @Param [refreshToken]
    * @exception   
    * @return      cn.comico.erp.service.set.api.dto.ManagerLoginDTO
    * @Date 2018/6/27 17:51
    **/
    ManagerLoginDTO refreshToken(String refreshToken);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询管理员列表
    * @Param [type, channelId, keywords, offset, pageSize]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.commons.result.DataGrid<java.util.List<cn.comico.erp.service.set.api.dto.ManagerDTO>>>
    * @Date 2018/7/2 14:36
    **/
    ResultResp<DataGrid<List<ManagerDTO>>> findManagerList(Integer type, Long channelId, String keywords, int offset, int pageSize);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存管理员信息
    * @Param [managerSaveDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 18:48
    **/
    ResultResp saveManager(ManagerSaveDTO managerSaveDTO);

    /**
    * 
    * @author      changhuanhu
    * @Description 更新管理员状态
    * @Param [id, status]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 19:04
    **/
    ResultResp updateStatus(Long id, Integer status);

    /**
    * 
    * @author      changhuanhu
    * @Description 删除管理员
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 19:04
    **/
    ResultResp deleteManager(Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 更新管理员
    * @Param [managerSaveDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 19:05
    **/
    ResultResp updateManager(ManagerSaveDTO managerSaveDTO);
}
