package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

public interface BookSearchCriteriaService {
	List<BookTo> findBookByCriteria(BookSearchCriteria bookSearchCriteria);
}
