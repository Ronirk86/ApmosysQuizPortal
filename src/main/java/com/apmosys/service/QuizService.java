package com.apmosys.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.apmosys.model.Category;
import com.apmosys.model.Quiz;

@Service 
public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizes();
	
	public Quiz getQuiz(Long quizId);
	
	public void deletQuiz(Long quizId);

	public List<Quiz> getQuizesOfCategory(Category category);

	public List<Quiz> getActiveQuizes();
	
	public List<Quiz> getActiveQuizesOfCategory(Category c);
}
