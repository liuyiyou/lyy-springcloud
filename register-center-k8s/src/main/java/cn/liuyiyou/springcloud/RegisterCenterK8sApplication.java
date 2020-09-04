package cn.liuyiyou.springcloud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//-javaagent:D:\Soft\apache-skywalking-apm-bin\agent\skywalking-agent.jar -Dskywalking.agent.service_name=server-base-consumer
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class RegisterCenterK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterK8sApplication.class, args);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }

}
