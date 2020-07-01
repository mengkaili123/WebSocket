package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.Weather2Dao;
import com.bootdo.system.domain.Weather2DO;
import com.bootdo.system.service.Weather2Service;



@Service
public class Weather2ServiceImpl implements Weather2Service {
	@Autowired
	private Weather2Dao weather2Dao;
	
	@Override
	public Weather2DO get(Integer id){
		return weather2Dao.get(id);
	}
	
	@Override
	public List<Weather2DO> list(Map<String, Object> map){
		return weather2Dao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weather2Dao.count(map);
	}
	
	@Override
	public int save(Weather2DO weather2){
		return weather2Dao.save(weather2);
	}
	
	@Override
	public int update(Weather2DO weather2){
		return weather2Dao.update(weather2);
	}
	
	@Override
	public int remove(Integer id){
		return weather2Dao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return weather2Dao.batchRemove(ids);
	}
	
}
