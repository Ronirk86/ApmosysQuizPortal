package com.apmosys.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="result")
public class QuizResult {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long qrId;
    private Integer marksGot;
    private Integer correctAnswer;
    private Integer attempted;
    private Integer uId;
    private Integer timeTakenByUser;
    @Column(name="is_latest")
    private Boolean is_latest;
    private Integer quest;
    
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JsonIgnore
    private User user;

	public Long getQrId() {
		return qrId;
	}

	public void setQrId(Long qrId) {
		this.qrId = qrId;
	}

	public Integer getMarksGot() {
		return marksGot;
	}

	public void setMarksGot(Integer marksGot) {
		this.marksGot = marksGot;
	}

	public Integer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Integer getAttempted() {
		return attempted;
	}

	public void setAttempted(Integer attempted) {
		this.attempted = attempted;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getTimeTakenByUser() {
		return timeTakenByUser;
	}

	public void setTimeTakenByUser(Integer timeTakenByUser) {
		this.timeTakenByUser = timeTakenByUser;
	}

	public Boolean getIs_latest() {
		return is_latest;
	}

	public void setIs_latest(Boolean is_latest) {
		this.is_latest = is_latest;
	}

	public Integer getQuest() {
		return quest;
	}

	public void setQuest(Integer quest) {
		this.quest = quest;
	}

	
	
	
	
    
    
    
}
