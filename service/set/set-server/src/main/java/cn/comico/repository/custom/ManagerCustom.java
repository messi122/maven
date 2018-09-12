package cn.comico.repository.custom;



import cn.comico.dto.ManagerDTO;
import cn.comico.set.Manager;


import java.util.List;

/**
 * 仓库定制化接口
 */
public interface ManagerCustom {
    
    
    /**
    * 
    * @author      changhuanhu
    * @Description 根据关键词搜索
    * @Param [keywords, offset, pageSize]
    * @exception   
    * @return      java.util.List<cn.comico.erp.pojo.set.Manager>
    * @Date 2018/6/25 14:23
    **/
    List<Manager> search(String keywords, Long offset, Long pageSize);

    /**
    * 
    * @author      changhuanhu
    * @Description 保存管理员权限
    * @Param [id, idList]
    * @exception   
    * @return      void
    * @Date 2018/7/2 18:59
    **/
    void batchSaveManagerPermission(Long id, List<Long> idList);

    /**
    * 
    * @author      changhuanhu
    * @Description 删除
    * @Param [managerId]
    * @exception   
    * @return      void
    * @Date 2018/7/2 19:24
    **/
    void deleteManagerPermission(Long managerId);

    /**
    * 
    * @author      changhuanhu
    * @Description 条件查询记录数
    * @Param [type, channelId, keywords]
    * @exception   
    * @return      long
    * @Date 2018/7/3 14:37
    **/
    long findManagerListCount(Integer type, Long channelId, String keywords);

    /**
    * 
    * @author      changhuanhu
    * @Description 条件查询记录并分页
    * @Param [type, channelId, keywords, offset, pageSize]
    * @exception   
    * @return      java.util.List<cn.comico.erp.service.set.api.dto.ManagerDTO>
    * @Date 2018/7/3 14:38
    **/
    List<ManagerDTO> findManagerList(Integer type, Long channelId, String keywords, int offset, int pageSize);
}
