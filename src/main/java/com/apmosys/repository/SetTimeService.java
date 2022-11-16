package com.apmosys.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apmosys.model.SetTime;

@Service
public class SetTimeService {
     
	@Autowired
	private SetTimeRepository setTimeRepository;
	
	public SetTime setTimer(SetTime timer) {
		this.setTimeRepository.deleteAll();
		return this.setTimeRepository.save(timer);
	}

	public List<SetTime> getTimer() {
		
		return this.setTimeRepository.findAll();
	}
	
}
