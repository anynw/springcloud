package com.anynw.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ceair.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//public static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list" )
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable Long id) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept, boolean.class);
	}
}
