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

import com.bootdo.system.domain.Weather3DO;
import com.bootdo.system.service.Weather3Service;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-29 16:45:48
 */
 
@Controller
@RequestMapping("/system/weather3")
public class Weather3Controller {
	@Autowired
	private Weather3Service weather3Service;
	
	@GetMapping()
	@RequiresPermissions("system:weather3:weather3")
	String Weather3(){
	    return "system/weather3/weather3";
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
		List<Weather3DO> weatherList = weather3Service.list(query);
		int total = weather3Service.count(query);
		PageUtils pageUtils = new PageUtils(weatherList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:weather3:add")
	String add(){
	    return "system/weather3/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:weather3:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		Weather3DO weather3 = weather3Service.get(id);
		model.addAttribute("weather3", weather3);
	    return "system/weather3/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:weather3:add")
	public R save( Weather3DO weather3){
		if(weather3Service.save(weather3)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:weather3:edit")
	public R update( Weather3DO weather3){
		weather3Service.update(weather3);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:weather3:remove")
	public R remove( Integer id){
		if(weather3Service.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:weather3:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		weather3Service.batchRemove(ids);
		return R.ok();
	}
	
}
