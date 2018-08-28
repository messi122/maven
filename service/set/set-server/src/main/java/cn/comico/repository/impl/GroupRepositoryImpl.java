package cn.comico.repository.impl;


import cn.comico.dto.GroupDTO;
import cn.comico.repository.custom.GroupCustom;
import cn.comico.supply.dto.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName GroupRepositoryImpl
 * @Description TODO
 * @date 2018/7/2 11:54
 **/
@Repository
public class GroupRepositoryImpl implements GroupCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void batchSaveGroup(Long groupId, List<Long> idList) {

        String sql = "insert into t_group_permission values(?, ?)";
        Query query = entityManager.createNativeQuery(sql);
        Optional.ofNullable(idList).orElse(new ArrayList<>())
                .forEach(permissionId -> {
                    query.setParameter(1, groupId);
                    query.setParameter(2, permissionId);
                    query.executeUpdate();
                });

    }

    @Override
    public void deleteGroupPermission(Long groupId) {
        String sql = "delete from t_group_permission where group_id = ?";
        entityManager.createNativeQuery(sql)
                .setParameter(1, groupId)
                .executeUpdate();

    }

    @Override
    public long findGroupListCount(Integer type) {
        StringBuilder hql = new StringBuilder();
        hql.append("select count(id) from Group where 1 = 1");
        if (null != type && type > -1) {
            hql.append(" and type = :type");
        }

        Query query = entityManager.createQuery(hql.toString());
        if (null != type && type > -1) {
            query.setParameter("type", type);
        }

        Object result = query.getSingleResult();

        return null != result ? ((Long)result).longValue() : 0;
    }

    @Override
    public List<GroupDTO> findGroupList(Integer type, int offset, int pageSize) {
        StringBuilder hql = new StringBuilder();
        hql.append("select g from Group g where 1 = 1");
        if (null != type && type > -1) {
            hql.append(" and type = :type");
        }

        Query query = entityManager.createQuery(hql.toString());
        if (null != type && type > -1) {
            query.setParameter("type", type);
        }
        return query.getResultList();
    }
}
