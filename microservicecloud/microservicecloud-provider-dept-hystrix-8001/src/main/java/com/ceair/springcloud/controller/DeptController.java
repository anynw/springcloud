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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@GetMapping(value = "/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable Long id) {
		// TODO Auto-generated method stub
		Dept dept = deptService.get(id);
		if (dept == null) {
			throw new RuntimeException("该ID：" + id + "没有对应的信息");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable Long id) {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,null--@HystrixCommand")
				.setDb_source("no data in this database");
	}

}
