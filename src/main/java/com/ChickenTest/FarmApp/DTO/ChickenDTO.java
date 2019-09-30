package com.ChickenTest.FarmApp.DTO;

import java.util.Date;


public class ChickenDTO {
	
	private long id;
	
	private String name;

	private boolean FarmStatusChicken;
	
	private Date joinDate = new Date();
	
	private long farmId;
	
	//* Getters and Setters *//
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public boolean isFarmStatusChicken() {
		return FarmStatusChicken;
	}

	public void setFarmStatusChicken(boolean farmStatusChicken) {
		FarmStatusChicken = farmStatusChicken;
	}

	public long getFarmId() {
		return farmId;
	}

	public void setFarmId(long farmId) {
		this.farmId = farmId;
	}
}