package com.apmosys.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SetTime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stId;
	private Integer timer;
	public Long getStId() {
		return stId;
	}
	public void setStId(Long stId) {
		this.stId = stId;
	}
	public Integer getTimer() {
		return timer;
	}
	public void setTimer(Integer timer) {
		this.timer = timer;
	}
    
	
	
}
