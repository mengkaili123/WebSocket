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

import com.bootdo.system.domain.Weather1DO;
import com.bootdo.system.service.Weather1Service;
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
@RequestMapping("/system/weather1")
public class Weather1Controller {
	@Autowired
	private Weather1Service weather1Service;
	
	@GetMapping()
	@RequiresPermissions("system:weather1:weather1")
	String Weather1(){
	    return "system/weather1/weather1";
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
		List<Weather1DO> weatherList = weather1Service.list(query);
		int total = weather1Service.count(query);
		PageUtils pageUtils = new PageUtils(weatherList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:weather1:add")
	String add(){
	    return "system/weather1/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:weather1:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		Weather1DO weather1 = weather1Service.get(id);
		model.addAttribute("weather1", weather1);
	    return "system/weather1/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:weather1:add")
	public R save( Weather1DO weather1){
		if(weather1Service.save(weather1)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:weather1:edit")
	public R update( Weather1DO weather1){
		weather1Service.update(weather1);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:weather1:remove")
	public R remove( Integer id){
		if(weather1Service.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:weather1:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		weather1Service.batchRemove(ids);
		return R.ok();
	}
	
}
