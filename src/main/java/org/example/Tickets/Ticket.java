package org.example.Tickets;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ticket implements Serializable {

	@SerializedName("arrival_time")
	private String arrivalTime;

	@SerializedName("departure_date")
	private String departureDate;

	@SerializedName("destination_name")
	private String destinationName;

	@SerializedName("departure_time")
	private String departureTime;

	@SerializedName("arrival_date")
	private String arrivalDate;

	@SerializedName("origin_name")
	private String originName;

	public void setArrivalTime(String arrivalTime){
		this.arrivalTime = arrivalTime;
	}

	public String getArrivalTime(){
		return arrivalTime;
	}

	public void setDepartureDate(String departureDate){
		this.departureDate = departureDate;
	}

	public String getDepartureDate(){
		return departureDate;
	}

	public void setDestinationName(String destinationName){
		this.destinationName = destinationName;
	}

	public String getDestinationName(){
		return destinationName;
	}

	public void setDepartureTime(String departureTime){
		this.departureTime = departureTime;
	}

	public String getDepartureTime(){
		return departureTime;
	}

	public void setArrivalDate(String arrivalDate){
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalDate(){
		return arrivalDate;
	}

	public void setOriginName(String originName){
		this.originName = originName;
	}

	public String getOriginName(){
		return originName;
	}

	@Override
 	public String toString(){
		return 
			"Ticket{" + 
			"arrival_time = '" + arrivalTime + '\'' + 
			",departure_date = '" + departureDate + '\'' + 
			",destination_name = '" + destinationName + '\'' + 
			",departure_time = '" + departureTime + '\'' + 
			",arrival_date = '" + arrivalDate + '\'' + 
			",origin_name = '" + originName + '\'' + 
			"}";
		}
}