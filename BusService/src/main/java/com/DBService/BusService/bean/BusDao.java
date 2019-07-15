package com.DBService.BusService.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="BusService")
public class BusDao {

	@Id
	
	int busId;
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	@JsonProperty
	 @Column(name = "RouteID")
	int busRouteID;
	@JsonProperty
	@Column(name = "BusName")
	String busName;
	@JsonProperty
	@Column(name = "Fare")
	int busFare;
	public BusDao() {
		super();
	}
	
	public int getBusRouteID() {
		return busRouteID;
	}
	public void setBusRouteID(int busRouteID) {
		this.busRouteID = busRouteID;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public int getBusFare() {
		return busFare;
	}
	public void setBusFare(int busFare) {
		this.busFare = busFare;
	}
	
	@Override
	public String toString()
	{
		return String.format("Avialble Buses [busId=%s, busRouteID=%s, busName=%s,busFare=%s]", busId, busRouteID, busName,busFare);
	}

}
