package cn.liuyiyou.cloud.server.base.consumer.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: liuyiyou.cn
 * @date: 2020/8/13
 * @version: V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> implements Serializable {

    private Integer status;
    private T result;
}
