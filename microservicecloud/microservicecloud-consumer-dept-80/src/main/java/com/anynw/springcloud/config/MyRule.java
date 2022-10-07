package com.anynw.springcloud.config;


import com.anynw.springcloud.annotation.ExcludeFromComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
/**
 * 7种负载均衡策略:
 *	BestAvailableRule
 *	AvailabilityFilteringRule
 *	WeightedResponseTimeRule
 *	RetryRule
 *	RoundRobinRule
 *	RandomRule
 *	ZoneAvoidanceRule
 * @author Wuhp
 * @date 2019年9月22日 下午2:48:21
 */
@Configuration
@ExcludeFromComponentScan
public class MyRule{

	/**
	 * 自定义负载均衡算法：随机分配
	 * @return
	 */
//	@Bean
//	public IRule randomRule() {
//		return new RandomRule();
//	}
	/**
	 * 默认算法：轮询机制
	 */
//	@Bean
//	public IRule roundRobinRule() {
//		return new RoundRobinRule();
//	}
	/**
	 * 选择一个请求并发最小的server
	 * @return
	 */
//	@Bean
//	public IRule bestAvailableRule() {
//		return new BestAvailableRule();
//	}
	
	@Bean
	public IRule mRule() {
		return new IRule_Wuhp();
	}
	
}
