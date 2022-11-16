package com.apmosys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apmosys.model.SetTime;
import com.apmosys.repository.SetTimeService;

@RestController
@RequestMapping("/timer")
@CrossOrigin("*")
public class SetTimerController {
     
	@Autowired
	private SetTimeService setTimeService;
	
	@PostMapping("/set")
	public SetTime setTimer(@RequestBody SetTime timer) {
		return this.setTimeService.setTimer(timer);
	} 
	
	@GetMapping("/get")
    public SetTime getTimer(){
			return this.setTimeService.getTimer().get(0);
	}
	
}
