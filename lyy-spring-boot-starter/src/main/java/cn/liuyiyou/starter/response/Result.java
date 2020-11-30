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

    public Result(final String msg, final Integer code) {
        this.msg = msg;
        this.code = code;
    }



    public static <T> Result<T> alert(final String msg) {
        Result<T> result = new Result<T>();
        result.setMsg(msg);
        result.setCode(-1);
        return result;
    }

    public static <T> Result<T> fail(final String msg) {
        Result<T> result = new Result<>();
        result.setMsg(msg);
        result.setCode(400);
        return result;
    }

    public static <T> Result<T> result(final String msg, final int code, T data) {
        Result<T> result = new Result<>();
        result.setMsg(msg);
        result.setData(data);
        result.setCode(code);
        return result;
    }
}
