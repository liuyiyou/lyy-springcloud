package cn.liuyiyou.cloud.user.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: liuyiyou.cn
 * @date: 2021/2/4
 * @version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_pay_amount")
@Entity
public class UserPayAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "before_amount")
    private BigDecimal beforeAmount;
    @Column(name = "change_amount")
    private BigDecimal changeAmount;
    @Column(name = "after_amount")
    private BigDecimal afterAmount;

}
