package cn.liuyiyou.cloud.user.controller;

import cn.liuyiyou.cloud.user.dto.PayRequest;
import cn.liuyiyou.cloud.user.manage.UserPayAmountManage;
import cn.liuyiyou.cloud.user.service.UserPayAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2021/2/4
 * @version: V1.0
 */
@RestController
@RequestMapping("/users/pay")
@RequiredArgsConstructor
public class UserPayController {

    private final UserPayAmountService userPayAmountService;

    private final UserPayAmountManage userPayAmountManage;

    @PostMapping
    public Boolean userPay(@RequestBody PayRequest payRequest) {
        return userPayAmountManage.synchronizedPay(payRequest);
    }
}
