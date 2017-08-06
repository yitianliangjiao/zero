package com.wrh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

import com.wrh.core.MyMapper;

public abstract class BaseImpl<T>{
	
@Autowired MyMapper<T> mapper;

public Mapper<T> getMapper() {
	return mapper;
}

public T getModel(Object key) {
	return mapper.selectByPrimaryKey(key);
}

public int saveNull(T entity) {

	return mapper.insert(entity);
}

public int Add(T entity) {

	return mapper.insertSelective(entity);
}

public int delete(Object key) {
	return mapper.deleteByPrimaryKey(key);
}

public int updateNull(T entity) {
	return mapper.updateByPrimaryKey(entity);
}

public int update(T entity) {
	return mapper.updateByPrimaryKeySelective(entity);
}

public List<T> getListByExample(Object example) {

	return mapper.selectByExample(example);
}

public List<T> getListAll() {
	return mapper.selectAll();
}

public List<T> getList(T entity) {

	return mapper.select(entity);
}
}
