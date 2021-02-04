package cn.liuyiyou.cloud.user.repository;

import cn.liuyiyou.cloud.user.entity.UserPayAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/4
 * @version: V1.0
 */
@Repository
public interface UserPayAmountRepository extends JpaRepository<UserPayAmount, Integer> {


}
