package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.Weather3Dao;
import com.bootdo.system.domain.Weather3DO;
import com.bootdo.system.service.Weather3Service;



@Service
public class Weather3ServiceImpl implements Weather3Service {
	@Autowired
	private Weather3Dao weather3Dao;
	
	@Override
	public Weather3DO get(Integer id){
		return weather3Dao.get(id);
	}
	
	@Override
	public List<Weather3DO> list(Map<String, Object> map){
		return weather3Dao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weather3Dao.count(map);
	}
	
	@Override
	public int save(Weather3DO weather3){
		return weather3Dao.save(weather3);
	}
	
	@Override
	public int update(Weather3DO weather3){
		return weather3Dao.update(weather3);
	}
	
	@Override
	public int remove(Integer id){
		return weather3Dao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return weather3Dao.batchRemove(ids);
	}
	
}
