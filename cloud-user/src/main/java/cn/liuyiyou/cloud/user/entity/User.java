package cn.liuyiyou.cloud.user.entity;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
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
 * @date: 2020/12/7
 * @version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column(name = "create_time")
    private Instant createTime;
    @Column(name = "update_time")
    private Instant updateTime;
    @Column(name = "birth_day")
    private LocalDateTime birthDay;
    @Column(name = "register_time")
    private Date registerTime;
}
