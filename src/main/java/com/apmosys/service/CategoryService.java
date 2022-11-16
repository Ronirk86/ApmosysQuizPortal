package com.apmosys.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.apmosys.model.Category;

@Service
public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long categoryId);
	public void deleteCategory(Long categoryId);

}
