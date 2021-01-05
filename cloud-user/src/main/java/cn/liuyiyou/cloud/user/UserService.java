package cn.liuyiyou.cloud.user;

import cn.liuyiyou.cloud.user.entity.User;
import cn.liuyiyou.cloud.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/5
 * @version: V1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    /**
     * 会更新一个值
     * @param id
     * @return
     */
    @Transactional//(propagation= Propagation.NOT_SUPPORTED)
    public User userTx(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        user.setName("bb");
        return user;
    }



}
