package cn.comico.repository;

import cn.comico.set.SetMarketSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author changhuanhu
 * @version 1.0
 * @ClassName SetMarketSortRepository
 * @Description TODO
 * @date 2018/7/3 19:32
 **/
public interface SetMarketSortRepository extends JpaRepository<SetMarketSort, Long> {

    @Query(value = "select t from SetMarketSort t where type = :type")
    SetMarketSort getSetMarketSortByType(@Param(value = "type") int type);
}
