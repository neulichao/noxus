package com.netease.springbootDemo.vo;

public class CityVo {
	private int cityId;
	private String cityName;
	private int provinceId;
	private int cityCode;

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public int getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String toString() {
		return "CityVo [cityId=" + this.cityId + ", cityName=" + this.cityName + ", provinceId=" + this.provinceId
				+ ", cityCode=" + this.cityCode + "]";
	}
}