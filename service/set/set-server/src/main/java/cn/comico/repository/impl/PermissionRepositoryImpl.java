package cn.comico.repository.impl;


import cn.comico.dto.PermissionDTO;
import cn.comico.repository.custom.PermissionCustom;
import cn.comico.supply.dto.PermissionDTO;
import cn.comico.supply.repository.custom.PermissionCustom;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionRepositoryImpl
 * @Description TODO
 * @date 2018/6/25 14:48
 **/
@Repository
public class PermissionRepositoryImpl implements PermissionCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<PermissionDTO> findPermission(int type, int level, int menuLevel) {
        /**
         * select t.id, t.name, t.icon, GROUP_CONCAT(t.name2 order by id2 asc) children from
         * (SELECT t1.id, t1.name, t1.icon, t2.id id2, t2.name name2 FROM t_permission t1 left join t_permission t2
         * on t1.id = t2.fid and t1.type = t2.type
         * where t1.type = 0 and t1.menu_level = 1 and t1.`level` < 1
         * and (t1.level = -1 or t1.`level` = 0)) t
         * group by t.id
         */
        StringBuilder sql = new StringBuilder();

        sql.append(" select t.id, t.name, t.icon, GROUP_CONCAT(t.name2 order by id2 asc) children from");
        sql.append(" (SELECT t1.id, t1.name, t1.icon, t2.id id2, t2.name name2 FROM t_permission t1 left join t_permission t2");
        sql.append(" on t1.id = t2.fid and t1.type = t2.type and t2.level = :level");
        sql.append(" where t1.type = :type and t1.menu_level = :menuLevel");
        sql.append(" and (t1.level = -1 or t1.level = :level)) t");
        sql.append(" group by t.id");

        List<Object[]> resultList = entityManager.createNativeQuery(sql.toString())
                .setParameter("type", type)
                .setParameter("level", level)
                .setParameter("menuLevel", menuLevel)
                .unwrap(NativeQuery.class)
                .addScalar("id", LongType.INSTANCE)
                .addScalar("name", StringType.INSTANCE)
                .addScalar("icon", StringType.INSTANCE)
                .addScalar("children", StringType.INSTANCE)
                .getResultList();

        List<PermissionDTO> list = Optional.ofNullable(resultList).orElse(new ArrayList<>())
                .stream()
                .map(obj -> {
                    Long id = (Long) obj[0];
                    String name = (String) obj[1];
                    String icon = (String) obj[2];
                    String children = (String) obj[3];

                    PermissionDTO permissionDTO = new PermissionDTO();
                    permissionDTO.setId(id);
                    permissionDTO.setNmae(name);
                    permissionDTO.setIcon(icon);
                    permissionDTO.setChildren(children);
                    return permissionDTO;
                })
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public List<Object[]> getPermissionDetail(Long id, int type, int level, int menuLevel) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select t1.id fid, t1.name fname, t2.id, t2.name name from t_permission t1 left join t_permission t2");
        sql.append(" on t1.id = t2.fid and t2.`level` = :level");
        sql.append(" where t1.menu_level = :menuLevel and t1.type = :type and (t1.`level` = -1 or t1.`level` = :level)");
        sql.append(" and t1.fid = :id");

        return entityManager.createNativeQuery(sql.toString())
                .setParameter("id", id)
                .setParameter("type", type)
                .setParameter("level", level)
                .setParameter("menuLevel", menuLevel)
                .unwrap(NativeQuery.class)
                .addScalar("fid", LongType.INSTANCE)
                .addScalar("fname", StringType.INSTANCE)
                .addScalar("id", LongType.INSTANCE)
                .addScalar("name", StringType.INSTANCE)
                .getResultList();

    }

    @Override
    public List<Object[]> getPermission(Long fid) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select t1.id, t1.key, t2.manager_id managerId, t2.name name from t_permission t1 left join");
        sql.append(" (select mp.permission_id, mp.manager_id, m.name from t_manager_permission mp inner join t_manager m on mp.manager_id = m.id)t2");
        sql.append(" on t1.id = t2.permission_id");
        sql.append(" where t1.fid = :fid");

        return entityManager.createNativeQuery(sql.toString())
                .setParameter("fid", fid)
                .unwrap(NativeQuery.class)
                .addScalar("id", LongType.INSTANCE)
                .addScalar("key", StringType.INSTANCE)
                .addScalar("managerId", LongType.INSTANCE)
                .addScalar("name", StringType.INSTANCE)
                .getResultList();
    }

    @Override
    public void saveOrUpdateManagerPermission(Long permissionId, Long userId) {
        String sql = "insert into t_manager_permission value(:managerId, :permissionId)";
        entityManager.createNativeQuery(sql)
            .setParameter("managerId", userId)
            .setParameter("permissionId", permissionId)
            .executeUpdate();

    }

    @Override
    public void deleteManagerPermission(Long permissionId, Long userId) {
        String sql = "delete from t_manager_permission where manager_id = ? and permission_id = ?";
        entityManager.createNativeQuery(sql)
            .setParameter(1, userId)
            .setParameter(2, permissionId)
            .executeUpdate();
    }

    @Override
    public Long countManagerPermissionByFid(Long userId, long fid) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(t1.id) from t_permission t1 left join t_manager_permission t2 on t1.id = t2.permission_id");
        sql.append(" where t2.manager_id = :managerId and t1.fid = :fid");
        Object result = entityManager.createNativeQuery(sql.toString())
                .setParameter("managerId", userId)
                .setParameter("fid", fid)
                .getSingleResult();
        return null != result ? ((BigInteger)result).longValue() : 0;
    }

    @Override
    public Long findManagerPermissionListCount(Long permissionId, Long userId) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(t1.permission_id) from t_manager_permission t1 where t1.permission_id = :permissionId and t1.manager_id = :managerId");
        Object result = entityManager.createNativeQuery(sql.toString())
                .setParameter("managerId", userId)
                .setParameter("permissionId", permissionId)
                .getSingleResult();
        return null != result ? ((BigInteger)result).longValue() : 0;
    }
}
