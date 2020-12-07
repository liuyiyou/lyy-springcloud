package cn.liuyiyou.cloud.user.controller;

import cn.liuyiyou.cloud.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/7
 * @version: V1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User user(@PathVariable Integer id) {
        final User user = new User();
        user.setId(1);
        user.setName("aa");
        return user;
    }
}
