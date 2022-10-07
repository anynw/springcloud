package com.anynw.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceair.springcloud.entities.Dept;
import com.anynw.springcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
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
}
