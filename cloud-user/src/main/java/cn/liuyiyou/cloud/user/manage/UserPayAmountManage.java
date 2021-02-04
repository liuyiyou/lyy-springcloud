package cn.liuyiyou.cloud.user.manage;

import cn.liuyiyou.cloud.user.dto.PayRequest;
import cn.liuyiyou.cloud.user.service.UserPayAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2021/2/4
 * @version: V1.0
 */
@Service
@RequiredArgsConstructor
public class UserPayAmountManage {

    private final UserPayAmountService userPayAmountService;

    public synchronized Boolean synchronizedPay(PayRequest payRequest) {
        return userPayAmountService.pay(payRequest);
    }
}
