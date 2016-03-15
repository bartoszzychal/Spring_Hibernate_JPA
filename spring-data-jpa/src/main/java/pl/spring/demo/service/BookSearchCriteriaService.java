package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

public interface BookSearchCriteriaService {
	List<BookTo> findBookByCriteria(BookSearchCriteria bookSearchCriteria);
	List<BookTo> findBookByCriteriaRepo(BookSearchCriteria bookSearchCriteria);
}
