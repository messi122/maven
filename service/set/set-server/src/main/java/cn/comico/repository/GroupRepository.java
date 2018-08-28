package cn.comico.repository;


import cn.comico.repository.custom.GroupCustom;
import cn.comico.set.Group;
import cn.comico.supply.set.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName GroupRepository
 * @Description TODO
 * @date 2018/6/28 17:54
 **/
public interface GroupRepository extends JpaRepository<Group, Long>, GroupCustom {


}
