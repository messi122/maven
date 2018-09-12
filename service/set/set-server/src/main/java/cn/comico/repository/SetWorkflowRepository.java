package cn.comico.repository;


import cn.comico.repository.custom.SetWorkflowCustom;
import cn.comico.set.SetWorkflow;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetWorkflowRepository
 * @Description TODO
 * @date 2018/7/4 14:25
 **/
public interface SetWorkflowRepository extends JpaRepository<SetWorkflow, Long>, SetWorkflowCustom {

}
