package cn.liuyiyou.cloud.app.feigh;

import cn.liuyiyou.cloud.app.dto.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/7
 * @version: V1.0
 */
@FeignClient(value = "cloud-user", path = "/users")
public interface UserFeignClient {

    @GetMapping("/{id}")
    User findById(@PathVariable("id") Integer id);
}
