package cn.comico.repository.impl;


import cn.comico.dto.SetWorkflowDTO;
import cn.comico.dto.WorkflowDTO;
import cn.comico.repository.custom.SetWorkflowCustom;
import cn.comico.supply.dto.SetWorkflowDTO;
import cn.comico.supply.dto.WorkflowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetWorkflowRepositoryImpl
 * @Description TODO
 * @date 2018/7/4 15:53
 **/
@Repository
public class SetWorkflowRepositoryImpl implements SetWorkflowCustom {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SetWorkflowDTO> findWorkflowListByLevel(Integer level, Long channelId) {
        StringBuilder hql = new StringBuilder();
        hql.append(" select new cn.comico.erp.service.set.api.dto.SetWorkflowDTO(t1.id, t1.permissionId");
        hql.append( ", t2.name, t2.icon, t1.name, t1.level, t1.channelId, t1.code, t1.auditor, t1.status, t1.updateDate, m.name)");
        hql.append(" from SetWorkflow t1");
        hql.append(" inner join Permission t2");
        hql.append(" on t1.permissionId = t2.id");
        hql.append(" left join Manager m");
        hql.append(" on m.id = t1.auditor");
        hql.append(" where t1.level = :level");
        hql.append(" and t1.channelId = :channelId");
        hql.append(" order by code asc");

        Query query = entityManager.createQuery(hql.toString());
        query.setParameter("level", level);
        query.setParameter("channelId", channelId);

        return query.getResultList();
    }

    @Override
    public WorkflowDTO getSetWorkflow(Long channelId, String code) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select t1.id, t1.permission_id permissionId, t1.name name, t1.level level, t1.channel_id channelId, t1.code, t1.auditor, t1.status, t1.updateDate, t2.name auditorName, t3.fid");
        sql.append(" from t_set_workflow t1 left join t_manager t2");
        sql.append(" on t1.auditor = t2.id");
        sql.append(" left join t_channel t3");
        sql.append(" on t1.channel_id = t3.id");
        sql.append(" where t1.channel_id = ? and t1.code = ?");
        return jdbcTemplate.queryForObject(sql.toString(), BeanPropertyRowMapper.newInstance(WorkflowDTO.class), channelId, code);
    }
}
