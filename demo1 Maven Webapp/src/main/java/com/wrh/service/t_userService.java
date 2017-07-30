package com.wrh.service;

import com.wrh.model.t_user;

public interface t_userService {
	 	int deleteByPrimaryKey(Integer id);

	    int insert(t_user record);

	    int insertSelective(t_user record);

	    t_user selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(t_user record);

	    int updateByPrimaryKey(t_user record);
}
