package cn.comico.service;


import cn.comico.dto.GroupDTO;
import cn.comico.erp.commons.result.DataGrid;
import cn.comico.erp.commons.result.ResultResp;
import cn.comico.supply.dto.GroupDTO;
import cn.comico.supply.erp.commons.result.ResultResp;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName IGroupService
 * @Description TODO
 * @date 2018/6/28 17:52
 **/
public interface IGroupService {
    
    /**
    * 
    * @author      changhuanhu
    * @Description 查询权限组列表
    * @Param [type, offset, pageSize]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.commons.result.DataGrid<cn.comico.erp.service.set.api.dto.GroupDTO>>
    * @Date 2018/6/28 17:58
    **/
    ResultResp<DataGrid<GroupDTO>> findGroupList(Integer type, int offset, int pageSize);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存权限组信息
    * @Param [groupDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 10:13
    **/
    ResultResp saveGroup(GroupDTO groupDTO);

    /**
    * 
    * @author      changhuanhu
    * @Description 根据ID查询权限组信息
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp<cn.comico.erp.service.set.api.dto.GroupDTO>
    * @Date 2018/7/2 13:42
    **/
    ResultResp<GroupDTO> getGroup(Long id);

    /**
    * 
    * @author      changhuanhu
    * @Description 更新权限组
    * @Param [groupDTO]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 13:57
    **/
    ResultResp updateGroup(GroupDTO groupDTO);

    /**
    * 
    * @author      changhuanhu
    * @Description 更新状态
    * @Param [id, status]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 13:57
    **/
    ResultResp updateStatus(Long id, Integer status);

    /**
    * 
    * @author      changhuanhu
    * @Description 删除权限组
    * @Param [id]
    * @exception   
    * @return      cn.comico.erp.commons.result.ResultResp
    * @Date 2018/7/2 13:58
    **/
    ResultResp deleteGroup(Long id);
}
