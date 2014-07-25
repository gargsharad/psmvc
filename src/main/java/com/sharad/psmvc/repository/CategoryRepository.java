package com.sharad.psmvc.repository;

import java.util.List;

import com.sharad.psmvc.domain.Category;

/**
 * Repository for working with {@link Category} domain objects
 *  
 * @author Marten Deinum
 * @author Koen Serneels
 *
 */
public interface CategoryRepository {

	List<Category> findAll();

	Category findById(long id);

	void storeCategory(Category category);
}
