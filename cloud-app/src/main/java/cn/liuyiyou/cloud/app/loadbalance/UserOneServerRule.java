//package cn.liuyiyou.cloud.app.loadbalance;
//
//import com.netflix.loadbalancer.ILoadBalancer;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.Server;
//import java.util.List;
//import lombok.extern.slf4j.Slf4j;
//
///**
// * 自定义负载均衡策略
// *
// * @author: liuyiyou.cn
// * @date: 2020/4/24
// * @version: V1.0
// */
//@Slf4j
//public class UserOneServerRule implements IRule {
//
//    private ILoadBalancer lb;
//
//    /**
//     * 通过某种方式选择一个服务
//     */
//    @Override
//    public Server choose(Object key) {
//        List<Server> allServers = lb.getAllServers();
//        if (allServers.isEmpty()) {
//            throw new RuntimeException("没有可用服务");
//        }
//        for (Server server : allServers) {
//            log.info(server.getHostPort());
//        }
//        return allServers.get(0);
//    }
//
//    @Override
//    public void setLoadBalancer(ILoadBalancer lb) {
//        this.lb = lb;
//    }
//
//    @Override
//    public ILoadBalancer getLoadBalancer() {
//        return lb;
//    }
//}
