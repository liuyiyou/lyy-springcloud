package cn.liuyiyou.cloud.user.controller;

import cn.liuyiyou.cloud.user.entity.User;
import cn.liuyiyou.cloud.user.repository.UserRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/7
 * @version: V1.0
 */
@RestController
@RequestMapping("/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    /**
     * { "name": "传入的时间格式为yyyy-MM-dd HH:mm:ss", "createTime": "2021-01-04 20:24:02", "updateTime": "2021-01-04 20:24:02", "registerTime": "2021-01-04 20:24:02" }
     *
     *
     * { "name": "传入的时间格式为yyyy-MM-ddTHH:mm:ss.sssZ", "createTime": "2021-01-04T12:58:44.000Z", "updateTime": "2021-01-04T12:58:44.000Z" }
     */
    @PutMapping()
    public User add(@RequestBody User user) {
//        User user = new User();
//        user.setName("aa");
//        user.setBirthDay(LocalDateTime.now());
//        user.setCreateTime(Instant.now());
//        user.setRegisterTime(new Date());
//        user.setUpdateTime(Instant.now());
        return userRepository.save(user);
    }

    @GetMapping("{id}")
    public User user(@PathVariable Integer id) {

        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("timeBetween")
    public List<User> timeBetween() {
        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return userRepository.findByCreateTimeBetween(startOfDay.atZone(ZoneId.of("Asia/Shanghai")).toInstant(), endOfDay.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
    }


    @GetMapping("timeBetween2")
    public List<User> timeBetween2() {
        LocalDateTime startOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MIN).minusHours(8);
        final LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).minusHours(8);
        return userRepository.findByCreateTimeBetween(startOfDay.atZone(ZoneId.systemDefault()).toInstant(), endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }


    @GetMapping("/time")
    public Map<String, Instant> time() {
        final LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).minusHours(8);
        Map<String, Instant> map = new HashMap<>();
        map.put("-8", endOfDay.atZone(ZoneId.of("Asia/Shanghai")).toInstant());
        final LocalDateTime endOfDay2 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        map.put("不-8", endOfDay2.atZone(ZoneId.of("Asia/Shanghai")).toInstant());

        final LocalDateTime endOfDay3 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).minusHours(8);
        map.put("-8-2", endOfDay3.atZone(ZoneId.systemDefault()).toInstant());

        final LocalDateTime endOfDay4 = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        map.put("不-8-2", endOfDay4.atZone(ZoneId.systemDefault()).toInstant());
        return map;
    }

}
