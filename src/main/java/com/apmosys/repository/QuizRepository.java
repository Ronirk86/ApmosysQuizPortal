package com.apmosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apmosys.model.Category;
import com.apmosys.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	public List<Quiz> findByCategory(Category category);

	public List<Quiz> findByActive(Boolean b);
    public List<Quiz> findByCategoryAndActive(Category c,Boolean b);
}
