package cn.liuyiyou.cloud.user.repository;

import cn.liuyiyou.cloud.user.entity.User;
import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/4
 * @version: V1.0
 */
@Repository
//    @NoRepositoryBean
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByCreateTimeBetween(Instant createTimeStart,Instant createTimeEnd);
}
