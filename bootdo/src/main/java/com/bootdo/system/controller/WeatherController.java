package com.bootdo.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.system.domain.Weather1DO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.WeatherDO;
import com.bootdo.system.service.WeatherService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-29 16:45:47
 */
 
@Controller
@RequestMapping("/system/weather")
public class WeatherController {
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping()
	@RequiresPermissions("system:weather:weather")
	String Weather(){
	    return "system/weather/weather";
	}
	
//	@ResponseBody
//	@GetMapping("/list")
//	@RequiresPermissions("system:weather:weather")
//	public PageUtils list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//		List<WeatherDO> weatherList = weatherService.list(query);
//		int total = weatherService.count(query);
//		PageUtils pageUtils = new PageUtils(weatherList, total);
//		return pageUtils;
//	}

	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("system:weather:weather")
	public PageUtils list(){
		//查询列表数据
		Map<String,Object> params = new HashMap<>(16);
		params.put("offset",0);
		params.put("limit",1);
		Query query = new Query(params);
		List<WeatherDO> weatherList = weatherService.list(query);
		int total = weatherService.count(query);
		PageUtils pageUtils = new PageUtils(weatherList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:weather:add")
	String add(){
	    return "system/weather/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:weather:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WeatherDO weather = weatherService.get(id);
		model.addAttribute("weather", weather);
	    return "system/weather/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:weather:add")
	public R save( WeatherDO weather){
		if(weatherService.save(weather)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:weather:edit")
	public R update( WeatherDO weather){
		weatherService.update(weather);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:weather:remove")
	public R remove( Integer id){
		if(weatherService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:weather:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		weatherService.batchRemove(ids);
		return R.ok();
	}
	
}
