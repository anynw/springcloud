package com.anynw.springcloud.service.impl;

import java.util.List;

import com.anynw.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anynw.springcloud.dao.DeptDao;
import com.ceair.springcloud.entities.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> list() {
		// TODO Auto-generated method stub
		return deptDao.getAll();
	}

	@Override
	public Dept get(Long id) {
		// TODO Auto-generated method stub
		return deptDao.getDeptById(id);
	}

	@Override
	public boolean add(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.addDept(dept);
	}

}
