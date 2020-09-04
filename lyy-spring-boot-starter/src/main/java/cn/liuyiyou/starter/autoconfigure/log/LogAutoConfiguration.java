package cn.liuyiyou.starter.autoconfigure.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/4
 * @version: V1.0
 */
@Slf4j
@Aspect
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@Configuration
@ConditionalOnProperty(prefix = "lyy.config.log", name = "enable",
    havingValue = "true", matchIfMissing = true)
public class LogAutoConfiguration implements PriorityOrdered {

    @Around("@annotation(cn.liuyiyou.starter.log.Log)")
    public Object isOpen(ProceedingJoinPoint thisJoinPoint)
        throws Throwable {
        String taskName = thisJoinPoint.getSignature()
            .toString().substring(
                thisJoinPoint.getSignature()
                    .toString().indexOf(" "),
                thisJoinPoint.getSignature().toString().indexOf("("));
        taskName = taskName.trim();
        long time = System.currentTimeMillis();
        Object result = thisJoinPoint.proceed();
        log.info("method:{} run :{} ms", taskName,
            (System.currentTimeMillis() - time));
        return result;
    }

    @Override
    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }
}
