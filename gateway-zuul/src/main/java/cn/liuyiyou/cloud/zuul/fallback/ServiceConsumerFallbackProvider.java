package cn.liuyiyou.cloud.zuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.context.RequestContext;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 自定义回退机制
 *
 * @author: liuyiyou.cn
 * @date: 2020/4/22
 * @version: V1.0
 */
@Component
@Slf4j
public class ServiceConsumerFallbackProvider implements FallbackProvider {

  /**
   * 对所有服务进行回退操作，如果只对指定的服务进行回退，只返回指定服务注册在eureka中的服务名
   * @return
   */
  @Override
  public String getRoute() {
    return "*";
  }

  @Override
  public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
    return new ClientHttpResponse() {
      @Override
      public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.OK;
      }

      @Override
      public int getRawStatusCode() throws IOException {
        return this.getStatusCode().value();
      }

      @Override
      public String getStatusText() throws IOException {
        return this.getStatusCode().getReasonPhrase();
      }

      @Override
      public void close() {

      }

      @Override
      public InputStream getBody() throws IOException {
        if (cause != null) {
          log.error("", cause.getCause());
        }
        RequestContext currentContext = RequestContext.getCurrentContext();
        log.info(currentContext.getResponseBody());
        return new ByteArrayInputStream(new String("服务器错误".getBytes(), StandardCharsets.UTF_8).getBytes());
      }

      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType( new MediaType("application","json",StandardCharsets.UTF_8));
        return httpHeaders;
      }
    };

  }
}
