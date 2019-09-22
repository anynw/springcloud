package com.ceair.springcloud.config;

import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.Configuration;

import com.ceair.springcloud.annotation.ExcludeFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * 
 * @author Administrator
 * @date 2019年9月22日 下午4:06:55
 */
public class IRule_Wuhp extends AbstractLoadBalancerRule{

	private int total = 0;//每个微服务调用五次然后切换下一个微服务
	private int currentIndex = 0;//当前微服务下标，改造随机算法
    /**
     * Randomly choose from all living servers
     */
    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            
//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);
            
            if(total < 5) {//0,1,2,3,4
            	//currentIndex不变
            	total++;
            }else {
            	currentIndex++;
            	if(currentIndex >= serverCount) {
            		currentIndex = 0;
            	}
            	total = 0;
            }
            
            server = upList.get(currentIndex);

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
	
}
