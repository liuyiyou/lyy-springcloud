package cn.liuyiyou.starter.exception;

import lombok.Getter;

/**
 * 该异常是需要前端弹出或者展示的
 *
 * @author: liuyiyou.cn
 * @date: 2020/7/20
 * @version: V1.0
 */
@Getter
public class AlertException extends RuntimeException {

    private static final long serialVersionUID = -994962710559017255L;

    private int code;

    public AlertException(String message) {
        super(message);
//        this.code = AlertCodeConstant.NORMAL;
    }

    /**
     * @param code 异常码
     */
    public AlertException(int code, String message) {
        super(message);
        this.code = code;
    }
}
