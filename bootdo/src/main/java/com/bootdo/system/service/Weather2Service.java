package com.bootdo.system.service;

import com.bootdo.system.domain.Weather2DO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-26 19:22:05
 */
public interface Weather2Service {
	
	Weather2DO get(Integer id);
	
	List<Weather2DO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Weather2DO weather2);
	
	int update(Weather2DO weather2);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
