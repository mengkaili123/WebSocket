package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.Weather1Dao;
import com.bootdo.system.domain.Weather1DO;
import com.bootdo.system.service.Weather1Service;



@Service
public class Weather1ServiceImpl implements Weather1Service {
	@Autowired
	private Weather1Dao weather1Dao;
	
	@Override
	public Weather1DO get(Integer id){
		return weather1Dao.get(id);
	}
	
	@Override
	public List<Weather1DO> list(Map<String, Object> map){
		return weather1Dao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weather1Dao.count(map);
	}
	
	@Override
	public int save(Weather1DO weather1){
		return weather1Dao.save(weather1);
	}
	
	@Override
	public int update(Weather1DO weather1){
		return weather1Dao.update(weather1);
	}
	
	@Override
	public int remove(Integer id){
		return weather1Dao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return weather1Dao.batchRemove(ids);
	}
	
}
