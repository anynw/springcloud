package com.ceair.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceair.springcloud.entities.Dept;
import com.ceair.springcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(value = "/dept/list" )
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptService.list();
	}

	@GetMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return deptService.get(id);
	}

	@PostMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept) {
		// TODO Auto-generated method stub
		return deptService.add(dept);
	}
	
	
	/**
	 * 获取微服务信息测试
	 * @return
	 */
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = discoveryClient.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.discoveryClient;
	}

	
}
