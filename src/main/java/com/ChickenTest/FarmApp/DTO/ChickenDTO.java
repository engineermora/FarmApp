package com.ChickenTest.FarmApp.DTO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ChickenTest.FarmApp.Models.Chicken;

public class ChickenDTO {
	
	private long id;
	private Date joinDate;
	private boolean FarmStatusChicken;
	
	public List<Chicken> chickensType = new LinkedList<Chicken>();

	
	//* Getters and Setters *//
	
	public long getId() {
		return id;
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

	public List<Chicken> getChickensType() {
		return chickensType;
	}

	public void setChickensType(List<Chicken> chickensType) {
		this.chickensType = chickensType;
	}
	

	
	

}
