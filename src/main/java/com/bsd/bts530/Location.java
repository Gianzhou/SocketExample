package com.bsd.bts530;

public class Location {
	private String longitude;
	private String latitude;

	//init the variable
	Location(){
		this.longitude = null;
		this.latitude = null;
	}
	
	// get the longitude
	public String getLongitude() {

		return this.longitude.toString();
	}
	
	// set the longitude, if the longitude is empty, throwing the exception
	public void setLongitude(String lon) throws Exception {

		if (!lon.isEmpty()) {
			
			this.longitude = lon;
			
		}else {
			
			throw new Exception("The Lagitude is empty!!");
		}

	}
	
	// get the latitude
	public String getLagitude() {
		
		return this.latitude.toString();
	}

	
	//set the latitude, if the lagitude is empty, throwing the exception
	public void setLagitude(String lat) throws Exception {
		
		if (!lat.isEmpty()) {
			
			this.latitude = lat;
			
		}else {
			
			throw new Exception("The latitude is empty!!!");
		}
	}
}
