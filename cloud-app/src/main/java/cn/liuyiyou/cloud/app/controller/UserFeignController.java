package cn.liuyiyou.cloud.app.controller;

import cn.liuyiyou.cloud.app.dto.user.User;
import cn.liuyiyou.cloud.app.feigh.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/7
 * @version: V1.0
 */
@RestController
@RequiredArgsConstructor
public class UserFeignController {

    private final UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public User user(@PathVariable Integer id) {
        return userFeignClient.findById(id);
    }

}
