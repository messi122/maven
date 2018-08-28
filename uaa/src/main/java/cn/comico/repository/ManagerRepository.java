package cn.comico.repository;

import cn.comico.set.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findByUsername(String username);

}
