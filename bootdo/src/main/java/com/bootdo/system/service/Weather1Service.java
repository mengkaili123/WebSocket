package com.bootdo.system.service;

import com.bootdo.system.domain.Weather1DO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-26 19:22:05
 */
public interface Weather1Service {
	
	Weather1DO get(Integer id);
	
	List<Weather1DO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(Weather1DO weather1);
	
	int update(Weather1DO weather1);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
