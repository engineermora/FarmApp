package com.ChickenTest.FarmApp.DTO;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.ChickenTest.FarmApp.Models.Egg;

public class EggDTO {
	
	private long id;
	
	private Date creationDate= new Date();
	
	private long chickenId;
	
	public List<Egg> EggColor = new LinkedList<Egg>();
	
	//* Getters and Setters*//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public long getChickenId() {
		return chickenId;
	}

	public void setChickenId(long chickenId) {
		this.chickenId = chickenId;
	}

	public List<Egg> getEggColor() {
		return EggColor;
	}

	public void setEggColor(List<Egg> eggColor) {
		EggColor = eggColor;
	}

	
	
	
	
	
}
