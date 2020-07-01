package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-29 16:45:48
 */
public class Weather3DO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Date date;
	//
	private Float temperature;
	//
	private Float temperature1;
	//
	private String local;
	//
	private String devices;
	//
	private Integer fire;
	//
	private Integer fire1;
	//
	private Float dianya;
	//
	private Integer shidu;
	//
	private Float speed;
	//
	private String yeya;
	//
	private Integer zhuansu;
	//
	private Integer zhuansu1;

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
	public void setTemperature1(Float temperature1) {
		this.temperature1 = temperature1;
	}
	/**
	 * 获取：
	 */
	public Float getTemperature1() {
		return temperature1;
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
	/**
	 * 设置：
	 */
	public void setFire1(Integer fire1) {
		this.fire1 = fire1;
	}
	/**
	 * 获取：
	 */
	public Integer getFire1() {
		return fire1;
	}
	/**
	 * 设置：
	 */
	public void setDianya(Float dianya) {
		this.dianya = dianya;
	}
	/**
	 * 获取：
	 */
	public Float getDianya() {
		return dianya;
	}
	/**
	 * 设置：
	 */
	public void setShidu(Integer shidu) {
		this.shidu = shidu;
	}
	/**
	 * 获取：
	 */
	public Integer getShidu() {
		return shidu;
	}
	/**
	 * 设置：
	 */
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
	/**
	 * 获取：
	 */
	public Float getSpeed() {
		return speed;
	}
	/**
	 * 设置：
	 */
	public void setYeya(String yeya) {
		this.yeya = yeya;
	}
	/**
	 * 获取：
	 */
	public String getYeya() {
		return yeya;
	}
	/**
	 * 设置：
	 */
	public void setZhuansu(Integer zhuansu) {
		this.zhuansu = zhuansu;
	}
	/**
	 * 获取：
	 */
	public Integer getZhuansu() {
		return zhuansu;
	}
	/**
	 * 设置：
	 */
	public void setZhuansu1(Integer zhuansu1) {
		this.zhuansu1 = zhuansu1;
	}
	/**
	 * 获取：
	 */
	public Integer getZhuansu1() {
		return zhuansu1;
	}
}
