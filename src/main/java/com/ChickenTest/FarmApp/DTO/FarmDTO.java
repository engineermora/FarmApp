package com.ChickenTest.FarmApp.DTO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ChickenTest.FarmApp.Models.Chicken;

public class FarmDTO { //implements Serializable {

	private long id;
	private String nameFarm;
	private Date creationDate= new Date();
	
	public List<Chicken> chickens = new LinkedList<Chicken>();
		
	////* Getters and Setters *////
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNameFarm() {
		return nameFarm;
	}
	public void setNameFarm(String nameFarm) {
		this.nameFarm = nameFarm;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	// Chicken List from Models.Chicken
	public List<Chicken> getChickens() {
		return chickens;
	}
	public void setChickens(List<Chicken> chickens) {
		this.chickens = chickens;
	}
	
}
