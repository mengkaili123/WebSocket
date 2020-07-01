package com.bootdo.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.system.domain.WeatherDO;
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

import com.bootdo.system.domain.Weather2DO;
import com.bootdo.system.service.Weather2Service;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-26 19:22:05
 */
 
@Controller
@RequestMapping("/system/weather2")
public class Weather2Controller {
	@Autowired
	private Weather2Service weather2Service;
	
	@GetMapping()
	@RequiresPermissions("system:weather2:weather2")
	String Weather2(){
	    return "system/weather2/weather2";
	}

	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("system:weather:weather")
	public PageUtils list(){
		//查询列表数据
		Map<String,Object> params = new HashMap<>(16);
		params.put("offset",0);
		params.put("limit",1);
		Query query = new Query(params);
		List<Weather2DO> weatherList = weather2Service.list(query);
		int total = weather2Service.count(query);
		PageUtils pageUtils = new PageUtils(weatherList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:weather2:add")
	String add(){
	    return "system/weather2/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:weather2:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		Weather2DO weather2 = weather2Service.get(id);
		model.addAttribute("weather2", weather2);
	    return "system/weather2/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:weather2:add")
	public R save( Weather2DO weather2){
		if(weather2Service.save(weather2)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:weather2:edit")
	public R update( Weather2DO weather2){
		weather2Service.update(weather2);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:weather2:remove")
	public R remove( Integer id){
		if(weather2Service.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:weather2:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		weather2Service.batchRemove(ids);
		return R.ok();
	}
	
}
