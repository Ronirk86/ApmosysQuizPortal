package com.apmosys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Rank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rId;
	private String firsName;
	private String marksGot;
	@Transient
	private Integer timeTakenByUser;
	
	public Long getrId() {
		return rId;
	}
	public void setrId(Long rId) {
		this.rId = rId;
	}
	public String getFirsName() {
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	public String getMarksGot() {
		return marksGot;
	}
	public void setMarksGot(String marksGot) {
		this.marksGot = marksGot;
	}
	
	public Integer getTimeTakenByUser() {
		return timeTakenByUser;
	}
	public void setTimeTakenByUser(Integer timeTakenByUser) {
		this.timeTakenByUser = timeTakenByUser;
	}
	
	
	
	
}
