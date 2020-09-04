package cn.liuyiyou.starter.response;

import java.io.Serializable;
import lombok.Data;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/4
 * @version: V1.0
 */
@Data
public class Result<T> implements Serializable {

    private String msg;
    private Integer code;
    private T data;

    public static <T> Result<T> alertSuccess(String msg) {
        Result<T> result = new Result<>();
        result.setMsg(msg);
        return result;
    }
}
