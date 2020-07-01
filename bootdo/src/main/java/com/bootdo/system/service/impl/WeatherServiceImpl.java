package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.WeatherDao;
import com.bootdo.system.domain.WeatherDO;
import com.bootdo.system.service.WeatherService;



@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	private WeatherDao weatherDao;
	
	@Override
	public WeatherDO get(Integer id){
		return weatherDao.get(id);
	}
	
	@Override
	public List<WeatherDO> list(Map<String, Object> map){
		return weatherDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return weatherDao.count(map);
	}
	
	@Override
	public int save(WeatherDO weather){
		return weatherDao.save(weather);
	}
	
	@Override
	public int update(WeatherDO weather){
		return weatherDao.update(weather);
	}
	
	@Override
	public int remove(Integer id){
		return weatherDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return weatherDao.batchRemove(ids);
	}
	
}
