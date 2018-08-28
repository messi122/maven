package cn.comico.repository.custom;


import cn.comico.dto.GroupDTO;
import cn.comico.supply.dto.GroupDTO;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName GroupCustom
 * @Description TODO
 * @date 2018/7/2 11:53
 **/
public interface GroupCustom {

    /**
    * 
    * @author      changhuanhu
    * @Description 批量保存权限组
    * @Param [id, idList]
    * @exception   
    * @return      void
    * @Date 2018/7/2 11:56
    **/
    void batchSaveGroup(Long id, List<Long> idList);

    /**
    * 
    * @author      changhuanhu
    * @Description 删除权限组权限
    * @Param [groupId]
    * @exception   
    * @return      void
    * @Date 2018/7/2 14:14
    **/
    void deleteGroupPermission(Long groupId);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询列表记录数
    * @Param [type]
    * @exception   
    * @return      long
    * @Date 2018/7/5 16:19
    **/
    long findGroupListCount(Integer type);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询组列表
    * @Param [type, offset, pageSize]
    * @exception   
    * @return      java.util.List<cn.comico.erp.service.set.api.dto.GroupDTO>
    * @Date 2018/7/5 16:22
    **/
    List<GroupDTO> findGroupList(Integer type, int offset, int pageSize);
}
