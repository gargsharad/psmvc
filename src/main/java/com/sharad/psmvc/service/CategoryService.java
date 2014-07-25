package com.sharad.psmvc.service;

import java.util.List;

import com.sharad.psmvc.domain.Category;

/**
 * Contract for services that work with an {@link Category}.
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 * 
 */
public interface CategoryService {

	Category findById(long id);

	List<Category> findAll();

	void addCategory(Category category);

}
