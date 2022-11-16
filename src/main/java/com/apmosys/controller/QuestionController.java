package com.apmosys.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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

import com.apmosys.model.Question;
import com.apmosys.model.Quiz;
import com.apmosys.service.QuestionService;
import com.apmosys.service.QuestionServiceImpl;
import com.apmosys.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionServiceImpl questionServiceImpl;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
		
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	//get all ques of any quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
//		Quiz quiz=new Quiz();
//		quiz.setQid(qid);
//		Set<Question> questionOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
//        return ResponseEntity.ok(questionOfQuiz);	
	
		Quiz quiz=this.quizService.getQuiz(qid);
	    Set<Question> questions = quiz.getQuestions();
	    List<Question> list=new ArrayList<Question>(questions);
	    System.out.println("No of question::"+list.size());
	    if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
	    	list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
	    }
	    
	    Collections.shuffle(list);
	    return ResponseEntity.ok(list);
	}
	
	//changes for kbc
	//get all ques of any quiz
		@GetMapping("/get")
		public Set<Question> getQuestionOneByOne(){
//			Quiz quiz=new Quiz();
//			quiz.setQid(qid);
//			Set<Question> questionOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
//	        return ResponseEntity.ok(questionOfQuiz);	
		    return this.questionServiceImpl.getQuestionOneByOne();
			
	     	    
		}
	//end of changes of kbc
	
	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("qid") Long qid){
		Quiz quiz=new Quiz();
		quiz.setQid(qid);
		Set<Question> questionOfQuiz=this.questionService.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionOfQuiz);	
	
		
	    //return ResponseEntity.ok(list);
	}
	
	//get sigle ques
	@GetMapping("/{quesId}")
		public Question getQues(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}
	
	@DeleteMapping("/{quesId}")
	public void deleteQues(@PathVariable("quesId") Long quesId) {
		this.questionService.deletQuestion(quesId);
	}
	
	
}
