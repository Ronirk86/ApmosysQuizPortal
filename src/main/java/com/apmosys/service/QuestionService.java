package com.apmosys.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.apmosys.model.Question;
import com.apmosys.model.Quiz;

@Service
public interface QuestionService {

    public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long questionId);
	
	public void deletQuestion(Long questionId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
}
