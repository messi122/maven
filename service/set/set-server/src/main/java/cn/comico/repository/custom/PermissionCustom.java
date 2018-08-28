package cn.comico.repository.custom;



import cn.comico.dto.PermissionDTO;
import cn.comico.supply.dto.PermissionDTO;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionCustom
 * @Description TODO
 * @date 2018/6/25 14:46
 **/
public interface PermissionCustom {

    /**
     *
     * @author      changhuanhu
     * @Description
     * @Param [type, level, menuLevl]
     * @exception
     * @return      java.util.List<cn.comico.erp.service.set.api.dto.PermissionDTO>
     * @Date 2018/6/25 18:44
     **/
    List<PermissionDTO> findPermission(int type, int level, int menuLevl);

    /**
    * 
    * @author      changhuanhu
    * @Description
    * @Param [id, type, level, menuLevel]
    * @exception   
    * @return      java.util.List<java.lang.Object[]>
    * @Date 2018/6/26 14:44
    **/
    List<Object[]> getPermissionDetail(Long id, int type, int level, int menuLevel);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询权限
    * @Param [fid]
    * @exception   
    * @return      java.util.List<java.lang.Object[]>
    * @Date 2018/6/26 17:21
    **/
    List<Object[]> getPermission(Long fid);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存或者更新
    * @Param [permissionId, userId]
    * @exception   
    * @return      void
    * @Date 2018/6/26 19:21
    **/
    void saveOrUpdateManagerPermission(Long permissionId, Long userId);

    /**
    * 
    * @author      changhuanhu
    * @Description 删除
    * @Param [permissionId, userId]
    * @exception   
    * @return      void
    * @Date 2018/6/26 19:22
    **/
    void deleteManagerPermission(Long permissionId, Long userId);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询记录数
    * @Param [userId, fid]
    * @exception   
    * @return      java.lang.Long
    * @Date 2018/6/29 18:22
    **/
    Long countManagerPermissionByFid(Long userId, long fid);

    /**
    * 
    * @author      changhuanhu
    * @Description 查询记录数
    * @Param [permissionId, userId]
    * @exception   
    * @return      java.lang.Long
    * @Date 2018/7/11 19:19
    **/
    Long findManagerPermissionListCount(Long permissionId, Long userId);
}
