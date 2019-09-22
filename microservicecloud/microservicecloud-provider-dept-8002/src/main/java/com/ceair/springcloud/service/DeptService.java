package com.ceair.springcloud.service;

import java.util.List;


import com.ceair.springcloud.entities.Dept;


public interface DeptService {

	List<Dept> list();
	
	Dept get(Long id);
	
	boolean add(Dept dept);
	
}
