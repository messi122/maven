package cn.comico.repository;


import cn.comico.repository.custom.ManagerCustom;
import cn.comico.set.Manager;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 集合JPA基本操作与定制化实现
 */
public interface ManagerRepository extends JpaRepository<Manager, Long>, ManagerCustom {

    Manager
    findByUsername(String username);

    long countIdByNameLike(String keywords);

//    @Query(value = "select t1.id, t1.name, t1.username, t1.phone, t4.name groupName, t1.`level`, t2.name channelName, t3.name shopName, t1.create_date createDate, t1.status from t_manager t1 left join t_channel t2 on t1.channel_id = t2.id left join t_channel t3 on t1.shop_id = t3.id left join t_group t4 on t1.group = t4.id where t1.`level` = :type and t1.channel_id = :channelId and (t1.name like %:kw% or t1.username like %:kw% or t1.phone like %:kw%)", nativeQuery = true)
//    @Query(value = "select new cn.comico.erp.pojo.set.Manager(t1.id, t1.name, t1.username, t1.phone, t4.name, t1.`level`, t2.name, t3.name, t1.create_date, t1.status) from t_manager t1 left join t_channel t2 on t1.channel_id = t2.id left join t_channel t3 on t1.shop_id = t3.id left join t_group t4 on t1.group = t4.id where t1.`level` = :type and t1.channel_id = :channelId and (t1.name like %:kw% or t1.username like %:kw% or t1.phone like %:kw%)", nativeQuery = true)
//    @Query(value = "select new cn.comico.erp.pojo.set.Manager(t1.id, t1.name, t1.username, t1.phone, t4.name, t1.level, t2.name, t3.name, t1.createDate, t1.status) from Manager t1 left join Channel t2 on t1.channelId = t2.id left join Channel t3 on t1.shopId = t3.id left join Group t4 on t1.group = t4.id where t1.level = :type and t1.channelId = :channelId and (t1.name like %:kw% or t1.username like %:kw% or t1.phone like %:kw%)")
//    @Query(value = "select new cn.comico.erp.service.set.api.dto.ManagerDTO(t1.id, t1.name, t1.username, t1.phone, t4.name, t1.level, t2.name, t3.name, t1.createDate, t1.status) from Manager t1 left join Channel t2 on t1.channelId = t2.id left join Channel t3 on t1.shopId = t3.id left join Group t4 on t1.group = t4.id where t1.level = :type and t1.channelId = :channelId and (t1.name like %:kw% or t1.username like %:kw% or t1.phone like %:kw%)")
//    Page<ManagerDTO> findManagerList(@Param(value = "type") Integer type, @Param(value = "channelId") Long channelId, @Param(value = "kw") String keywords, Pageable pageable);
}
