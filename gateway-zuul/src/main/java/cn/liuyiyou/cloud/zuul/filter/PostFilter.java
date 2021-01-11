package cn.liuyiyou.cloud.zuul.filter;

import cn.hutool.json.JSONObject;
import com.netflix.util.Pair;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.StreamUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/5
 * @version: V1.0
 */
@Slf4j
public class PostFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //写缓存。
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getMethod().equals("GET")) {
            String gatewayCache = request.getHeader("Gateway-Cache");
            boolean cache = StringUtils.isNotBlank(gatewayCache) && gatewayCache.equals("false") ? false : true;
            log.info("是否缓存:"+cache);
        }
        return null;
    }


    public static byte[] compress(String str, String encoding) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch (IOException e) {

        }
        return out.toByteArray();
    }
}

class StringConst {
    public static final String IsResponseByCache = "IsResponseByCache";

    public static final String HttpResponseHeaders = "Headers";

    public static final String HttpResponseBody = "Body";

    public static final String RequestRecord = "RequestRecord";

    public static final String IsOverloadDiscard = "IsOverloadDiscard";

    public static final String HandleEndpoint = "HandleEndpoint";

    public static final String IsNonRouted = "IsNonRouted";
}