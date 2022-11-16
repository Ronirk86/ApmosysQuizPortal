package com.apmosys.service;


import org.springframework.stereotype.Service;

import com.apmosys.model.QuizResult;

@Service
public interface QuizResultServiceI {
	
    public void submitResult(Long qr_id,Integer attempted,Integer correct_answer,Integer marks_got,Integer user_id, Integer timeTakenByUser,Integer quest);
    
    public QuizResult getQuizResult(Integer user_id);

	

	

    
}
