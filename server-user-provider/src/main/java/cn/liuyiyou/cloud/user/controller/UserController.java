package cn.liuyiyou.cloud.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/22
 * @version: V1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping
  public String user() {
    return "user";
  }
}
