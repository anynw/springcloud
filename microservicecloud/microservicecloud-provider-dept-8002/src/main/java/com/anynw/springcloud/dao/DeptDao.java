package com.anynw.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ceair.springcloud.entities.Dept;

@Mapper
public interface DeptDao {
	
	List<Dept> getAll();
	
	Dept getDeptById(Long id);
	
	boolean addDept(Dept dept);
}
