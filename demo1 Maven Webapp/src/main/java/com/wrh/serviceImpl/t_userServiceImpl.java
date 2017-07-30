package com.wrh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrh.dao.t_userDao;
import com.wrh.model.t_user;
import com.wrh.service.t_userService;
@Service
public class t_userServiceImpl implements t_userService{
@Autowired 
private t_userDao dao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(t_user record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}

	@Override
	public int insertSelective(t_user record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}

	@Override
	public t_user selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(t_user record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(t_user record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}

}
