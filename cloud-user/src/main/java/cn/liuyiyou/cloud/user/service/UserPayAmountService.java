package cn.liuyiyou.cloud.user.service;

import cn.liuyiyou.cloud.user.UserService;
import cn.liuyiyou.cloud.user.dto.PayRequest;
import cn.liuyiyou.cloud.user.entity.User;
import cn.liuyiyou.cloud.user.entity.UserPayAmount;
import cn.liuyiyou.cloud.user.repository.UserPayAmountRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: liuyiyou.cn
 * @date: 2021/2/4
 * @version: V1.0
 */
@Service
//@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserPayAmountService {


    private final UserService userService;
    private final UserPayAmountRepository userPayAmountRepository;


    @Transactional
    public Boolean payInTx(PayRequest payRequest) {
        return pay(payRequest);
    }

    @Transactional
    public Boolean pay(PayRequest payRequest) {

        User dbUser = userService.findById(payRequest.getUserId());
        if (dbUser.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("余额不足");
        }
        UserPayAmount userPayAmount = new UserPayAmount();
        userPayAmount.setUserId(payRequest.getUserId());
        userPayAmount.setOrderId(payRequest.getOrderId());
        userPayAmount.setBeforeAmount(dbUser.getAmount());
        userPayAmount.setChangeAmount(payRequest.getPayAmount());
        BigDecimal afterChageAmount = dbUser.getAmount().subtract(payRequest.getPayAmount());
        userPayAmount.setAfterAmount(afterChageAmount);

        dbUser.setAmount(afterChageAmount);

//        User newUser = new User();
//        BeanUtils.copyProperties(dbUser, newUser);
//        newUser.setAmount(afterChageAmount);
//        userService.update(newUser);
        userPayAmountRepository.save(userPayAmount);
        return true;
    }
}
