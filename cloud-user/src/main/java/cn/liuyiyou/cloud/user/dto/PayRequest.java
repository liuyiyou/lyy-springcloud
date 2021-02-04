package cn.liuyiyou.cloud.user.dto;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author: liuyiyou.cn
 * @date: 2021/2/4
 * @version: V1.0
 */
@Data
public class PayRequest {

    private Integer userId;
    private BigDecimal payAmount;
    private Integer orderId;

}
