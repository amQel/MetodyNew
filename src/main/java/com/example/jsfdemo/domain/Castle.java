package com.example.jsfdemo.domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;



public class Castle {


	private String castleName = "noname";
	private String castleId;
	private Date builtDate = new Date();
	private String castleType = "";
	private String condition = "semi destroyed castle";
	private String material = "brick";
	
	@Size(min=2, max=20)
	public String getCastleName() {
		return castleName;
	}
	
	
	public void setCastleName(String castleName) {
		this.castleName = castleName;
	}
	
	@Past
	public Date getBuiltDate() {
		return builtDate;
	}

	public void setBuiltDate(Date builtDate) {
		this.builtDate = builtDate;
	}


	public String getCastleType() {
		return castleType;
	}
	
	
	public void setCastleType(String castleType) {
		this.castleType = castleType;
	}
	
	
	public String getCondition() {
		return condition;
	}
	
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	
	public String getMaterial() {
		return material;
	}
	
	
	public void setMaterial(String material) {
		this.material = material;
	}


	public String getCastleId() {
		return castleId;
	}


	public void setCastleId(String castleId) {
		this.castleId = castleId;
	}
	
	
	
}
