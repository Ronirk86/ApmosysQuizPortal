package com.apmosys.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apmosys.model.Question;
import com.apmosys.model.Quiz;
import com.apmosys.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public void deletQuestion(Long questionId) {
		Question question=new Question();
		question.setQuestId(questionId);
		this.questionRepository.delete(question);
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}

	int i=0;
    //get question one by one
	public Set<Question> getQuestionOneByOne(){
		System.out.println("i++"+i);
		Set<Question> s=new HashSet<>();
		List<Long> questId=this.questionRepository.getQId();
		
		s.add(this.questionRepository.findById(questId.get(i)).get());
		i++;
		
		if(i==3)
			i=0;
		
		
		//s.forEach(System.out::println);
		return s;
		
	}
}
