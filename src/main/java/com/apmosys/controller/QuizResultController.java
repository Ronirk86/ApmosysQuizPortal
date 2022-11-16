package com.apmosys.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apmosys.model.QuizResult;
import com.apmosys.model.Rank;
import com.apmosys.service.QuizResultServiceImpl;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class QuizResultController {
	
	
	
	Long count=(long) Math.random();
	@Autowired
	private QuizResultServiceImpl quizResultServiceImpl;

	@PostMapping("/create")
	public void submitResult(@RequestBody QuizResult result) {
		System.out.println("=========="+result);
		
		Long qr_id=++count;
		Integer attempted=result.getAttempted();
		Integer correct_answer=result.getCorrectAnswer();
		Integer marks_got=result.getMarksGot();
		Integer user_id=result.getuId();
		Integer timeTakenByUser=result.getTimeTakenByUser();
		Integer quest=result.getQuest();
		this.quizResultServiceImpl.submitResult(qr_id,attempted, correct_answer, marks_got, user_id,timeTakenByUser,quest);
	    
	}
	
	@GetMapping("/get/{user_id}")
	public QuizResult getResult(@PathVariable Integer user_id) {
		return this.quizResultServiceImpl.getQuizResult(user_id);
	}	
	
	@GetMapping("/getAll")
	public List<Rank> getAllQuizResult() throws SQLException{
		return this.quizResultServiceImpl.getAllQuizResult();
	}
	
	@GetMapping("/getOne")
	public List<Rank> getAllQuizResultOfFirstQuestion() throws SQLException{
		return this.quizResultServiceImpl.getAllQuizResultOfFirstQuestion();
	}
	
	@GetMapping("/getTwo")
	public List<Rank> getAllQuizResultOfSecondQuestion() throws SQLException{
		return this.quizResultServiceImpl.getAllQuizResultOfSecondQuestion();
	}
	
}
