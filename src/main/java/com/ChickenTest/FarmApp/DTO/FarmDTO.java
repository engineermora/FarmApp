package com.ChickenTest.FarmApp.DTO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ChickenTest.FarmApp.Models.Chicken;

public class FarmDTO { //implements Serializable {

	private long id;
	
	private String farmName;
	
	private Date creationDate= new Date();
		
	int ChickensAmount;
	
	int eggsAmount;
	
	public List<Chicken> chickens = new LinkedList<Chicken>();
		
	////* Getters and Setters *////
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFarmName() {
		return farmName;
	}
	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public List<Chicken> getChickens() {
		return chickens;
	}
	public void setChickens(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
	
	public int getChickensAmount() {
		return ChickensAmount;
	}

	public void setChickensAmount(int chickensAmount) {
		ChickensAmount = chickensAmount;
	}

	public int getEggsAmount() {
		return eggsAmount;
	}

	public void setEggsAmount(int eggsAmount) {
		this.eggsAmount = eggsAmount;
	}
}