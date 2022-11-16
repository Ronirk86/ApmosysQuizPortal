package com.apmosys.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apmosys.model.Question;
import com.apmosys.model.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);
	
	@Query(value="select quest_id from question",nativeQuery = true)
	public List<Long> getQId();
	
	

}
