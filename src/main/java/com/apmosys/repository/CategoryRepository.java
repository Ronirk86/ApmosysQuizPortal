package com.apmosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apmosys.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
