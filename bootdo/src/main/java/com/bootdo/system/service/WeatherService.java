package com.bootdo.system.service;

import com.bootdo.system.domain.WeatherDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-29 16:45:47
 */
public interface WeatherService {
	
	WeatherDO get(Integer id);
	
	List<WeatherDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WeatherDO weather);
	
	int update(WeatherDO weather);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
