package com.sharad.psmvc.repository;

import java.util.List;

import com.sharad.psmvc.domain.Book;
import com.sharad.psmvc.domain.BookSearchCriteria;
import com.sharad.psmvc.domain.Category;

/**
 * Repository for working with {@link Book} domain objects
 * 
 * @author Marten Deinum
 * @author Koen Serneels
 *
 */
public interface BookRepository {

	Book findById(long id);

	List<Book> findByCategory(Category category);

	List<Book> findRandom(int count);

	List<Book> findBooks(BookSearchCriteria bookSearchCriteria);

	void storeBook(Book book);

}
