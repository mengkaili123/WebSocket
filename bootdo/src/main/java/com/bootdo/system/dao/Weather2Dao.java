package com.bootdo.system.dao;

import com.bootdo.system.domain.Weather2DO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-26 19:22:05
 */
@Mapper
public interface Weather2Dao {

	Weather2DO get(Integer id);
	
	List<Weather2DO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(Weather2DO weather2);
	
	int update(Weather2DO weather2);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
