package cn.liuyiyou.cloud.user;

import java.time.Instant;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2021/1/4
 * @version: V1.0
 */
public class InstantTest {


    @Test
    @DisplayName("时间测试")
    void testA(){
        //先把电脑的时区调整为标准时区
        //2021-01-04T09:38:27.643Z
        System.out.println(Instant.now());
        //2021-01-04T09:38:27.654Z[UTC]
        System.out.println(Instant.now().atZone(ZoneId.systemDefault()));
        //2021-01-04T17:38:27.660Z
        System.out.println(Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8)));
    }
}
