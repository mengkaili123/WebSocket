package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-26 19:22:05
 */
public class Weather2DO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Date date;
	//
	private Float temperature;
	//
	private String local;
	//
	private String devices;
	//
	private Integer fire;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * 设置：
	 */
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	/**
	 * 获取：
	 */
	public Float getTemperature() {
		return temperature;
	}
	/**
	 * 设置：
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	/**
	 * 获取：
	 */
	public String getLocal() {
		return local;
	}
	/**
	 * 设置：
	 */
	public void setDevices(String devices) {
		this.devices = devices;
	}
	/**
	 * 获取：
	 */
	public String getDevices() {
		return devices;
	}
	/**
	 * 设置：
	 */
	public void setFire(Integer fire) {
		this.fire = fire;
	}
	/**
	 * 获取：
	 */
	public Integer getFire() {
		return fire;
	}
}
