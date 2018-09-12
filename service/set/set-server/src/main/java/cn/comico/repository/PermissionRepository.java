package cn.comico.repository;


import cn.comico.repository.custom.PermissionCustom;
import cn.comico.set.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName PermissionRepository
 * @Description TODO
 * @date 2018/6/25 14:45
 **/
public interface PermissionRepository extends JpaRepository<Permission, Long>, PermissionCustom {


    @Query(value = "select t.* from t_permission t where (t.level = -1 or t.level = :level or type = 1)", nativeQuery = true)
    List<Permission> findPermissionByLevel(@Param(value = "level") Integer level);
}
