package com.apmosys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apmosys.model.Category;
import com.apmosys.model.Quiz;
import com.apmosys.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz
	
	@PutMapping("/")
	public ResponseEntity<Quiz> upadteQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//get all quizes
	@GetMapping("/")
	public ResponseEntity<?> getAllQuizes(){
		return ResponseEntity.ok(this.quizService.getQuizes());
	}
	
	//get quize
		@GetMapping("/{qid}")
		public Quiz getQuiz(@PathVariable("qid") Long qid){
			return this.quizService.getQuiz(qid);
		}
		
		@DeleteMapping("/{qid}")
		public void deleteQuiz(@PathVariable("qid") Long qid) {
			this.quizService.deletQuiz(qid);
		}
	
		@GetMapping("/category/{cid}")
		public List<Quiz> getQuizesOfCategory(@PathVariable("cid") Long cid){
		    Category category=new Category();
		    category.setCid(cid);
			return this.quizService.getQuizesOfCategory(category);
		}
		
		//get active quizes
		@GetMapping("/active")
		public List<Quiz> getActiveQuizes(){
			return this.quizService.getActiveQuizes();
		}
		
		@GetMapping("/category/active/{cid}")
		public List<Quiz> getActiveQuizesOfCategory(@PathVariable("cid") Long cid){
			Category category =new Category();
			category.setCid(cid);
			return this.quizService.getActiveQuizesOfCategory(category);
		}
}
