package com.test;

public class Address {
	
	private int doorno;
	private String streetAddress;
	private String cityName;
	private String pincode;
	
	
	public Address() {
		super();
	}
	
	
	public Address(int doorno, String streetAddress, String cityName, String pincode) {
		super();
		this.doorno = doorno;
		this.streetAddress = streetAddress;
		this.cityName = cityName;
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [doorno=" + doorno + ", streetAddress=" + streetAddress + ", cityName=" + cityName
				+ ", pincode=" + pincode + "]";
	}
	public int getDoorno() {
		return doorno;
	}
	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
