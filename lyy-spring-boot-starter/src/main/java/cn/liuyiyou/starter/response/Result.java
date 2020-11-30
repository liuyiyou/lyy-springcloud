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

    public Result(final String msg, final Integer code, final T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    private Result(final String msg, final Integer code) {
        this.msg = msg;
        this.code = code;
    }


    public static <T> Result<T> alert(final String msg) {
        return new Result<>(msg, -1);
    }

    public static <T> Result<T> fail(final String msg) {
        return new Result<>(msg, -1);
    }

    public static <T> Result<T> success(final String msg) {
        return new Result<>(msg, 200);
    }

    public static <T> Result<T> success(final String msg, T data) {
        return new Result<>(msg, 200, data);
    }

    public static <T> Result<T> result(final String msg, final int code, T data) {
        return new Result<>(msg, code, data);
    }
}
