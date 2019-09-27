package com.ceair.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceair.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

/**
 * 熔断机制：一般是某个服务故障或异常引起，类似保险丝，当某个服务条件被触发，直接熔断整个服务，而不是一直等到此服务超时。
 * 服务降级：一般是从整体负荷考虑，就是当某个服务熔断之后，服务器将不再调用，此时客户端可以自己准备一个本地的fallback回调，返回一个缺省值。
 * 这样做，虽然服务水平下降，但是服务仍然可用，比直接服务挂掉要强。
 * 
 * @author Administrator
 * @date 2019年9月27日 下午9:42:16
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {

			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
						.setDb_source("no data in this database");
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
