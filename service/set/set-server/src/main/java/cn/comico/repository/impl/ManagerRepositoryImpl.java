package cn.comico.repository.impl;


import cn.comico.dto.ManagerDTO;
import cn.comico.repository.custom.ManagerCustom;
import cn.comico.set.Manager;
import cn.comico.supply.dto.ManagerDTO;
import cn.comico.supply.repository.custom.ManagerCustom;
import cn.comico.supply.set.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.*;

/**
 * 仓库定制化接口实现类
 */
@Repository
public class ManagerRepositoryImpl implements ManagerCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Manager> search(String keywords, Long offset, Long pageSize) {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        sql.append("select m from Manager m where 1 = 1");

        if (!StringUtils.isEmpty(keywords)) {
            sql.append(" and m.name like :name");
            params.put("name", "%" + keywords + "%");
        }

        Query query = entityManager.createQuery(sql.toString());
        for(Map.Entry<String, Object> entry: params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        query.setFirstResult(offset.intValue());
        query.setMaxResults(pageSize.intValue());

        return query.getResultList();
    }

    @Override
    public void batchSaveManagerPermission(Long id, List<Long> idList) {
        String sql = "insert into t_manager_permission values(?, ?)";
        Query query = entityManager.createNativeQuery(sql);
        Optional.ofNullable(idList).orElse(new ArrayList<>())
                .forEach(permissionId -> {
                    query.setParameter(1, id);
                    query.setParameter(2, permissionId);
                    query.executeUpdate();
                });
    }

    @Override
    public void deleteManagerPermission(Long managerId) {
        String sql = "delete from t_manager_permission where manager_id = ?";
        entityManager.createNativeQuery(sql)
                .setParameter(1, managerId)
                .executeUpdate();

    }

    @Override
    public long findManagerListCount(Integer type, Long channelId, String keywords) {
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        sql.append(" select count(id) from t_manager where 1 = 1");
        if (null != type && -1 != type) {
            sql.append(" and level = :type");
            params.put("type", type);
        }

        if (null != channelId && -1 != channelId) {
            sql.append(" and channel_id = :channelId");
            params.put("channelId", channelId);
        }

        if (!StringUtils.isEmpty(keywords)) {
            sql.append(" and (name like :kw or username like :kw or phone like :kw)");
            params.put("kw", "%" + keywords + "%");
        }

        Query query = entityManager.createNativeQuery(sql.toString());
        for (Map.Entry<String, Object> entity: params.entrySet()) {
            query.setParameter(entity.getKey(), entity.getValue());
        }
        Object result = query.getSingleResult();
        return null != result ? ((BigInteger)result).longValue() : 0;
    }

    @Override
    public List<ManagerDTO> findManagerList(Integer type, Long channelId, String keywords, int offset, int pageSize) {
        //select t1.id, t1.name, t1.username, t1.phone, t4.name groupName, t1.`level`, t2.name channelName, t3.name shopName, t1.create_date createDate, t1.status from t_manager t1 left join t_channel t2 on t1.channel_id = t2.id left join t_channel t3 on t1.shop_id = t3.id left join t_group t4 on t1.group = t4.id where t1.`level` = :type and t1.channel_id = :channelId and (t1.name like %:kw% or t1.username like %:kw% or t1.phone like %:kw%
        StringBuilder sql = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        sql.append(" select new cn.comico.erp.service.set.api.dto.ManagerDTO(t1.id, t1.name, t1.username, t1.phone, t1.sex, t1.email, t1.avator, t4.name, t1.level, t2.name, t3.name, t1.createDate, t1.status) from Manager t1");
        sql.append(" left join Channel t2 on t1.channelId = t2.id");
        sql.append(" left join Channel t3 on t1.shopId = t3.id");
        sql.append(" left join Group t4 on t1.group = t4.id");
        sql.append(" where 1 = 1");

        if (null != type && -1 != type) {
            sql.append(" and t1.level = :type");
            params.put("type", type);
        }

        if (null != channelId && -1 != channelId) {
            sql.append(" and t1.channelId = :channelId");
            params.put("channelId", channelId);
        }

        if (!StringUtils.isEmpty(keywords)) {
            sql.append(" and (t1.name like :kw or t1.username like :kw or t1.phone like :kw)");
            params.put("kw", "%" + keywords + "%");
        }

        Query query = entityManager.createQuery(sql.toString());
        for (Map.Entry<String, Object> entity: params.entrySet()) {
            query.setParameter(entity.getKey(), entity.getValue());
        }
//        query.addScalar("id", LongType.INSTANCE)
//                .addScalar("name", StringType.INSTANCE)
//                .addScalar("username", StringType.INSTANCE)
//                .addScalar("sex", IntegerType.INSTANCE)
//                .addScalar("avator", StringType.INSTANCE)
//                .addScalar("email", StringType.INSTANCE)
//                .addScalar("phone", StringType.INSTANCE)
//                .addScalar("groupName", StringType.INSTANCE)
//                .addScalar("level", IntegerType.INSTANCE)
//                .addScalar("channelName", StringType.INSTANCE)
//                .addScalar("shopName", StringType.INSTANCE)
//                .addScalar("createDate", DateType.INSTANCE)
//                .addScalar("status", IntegerType.INSTANCE);

        List resultList = query.getResultList();

        return resultList;
    }
}
