package com.bootdo.system.dao;

import com.bootdo.system.domain.WeatherDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-29 16:45:47
 */
@Mapper
public interface WeatherDao {

	WeatherDO get(Integer id);
	
	List<WeatherDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WeatherDO weather);
	
	int update(WeatherDO weather);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
