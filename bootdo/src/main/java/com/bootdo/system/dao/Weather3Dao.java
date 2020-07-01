package com.bootdo.system.dao;

import com.bootdo.system.domain.Weather3DO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-29 16:45:48
 */
@Mapper
public interface Weather3Dao {

	Weather3DO get(Integer id);
	
	List<Weather3DO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(Weather3DO weather3);
	
	int update(Weather3DO weather3);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
