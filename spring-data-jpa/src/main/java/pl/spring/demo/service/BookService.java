package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);
    List<BookTo> findBookByCriteria(BookSearchCriteria bookSearchCriteria);
	List<BookTo> findBookByCriteriaRepo(BookSearchCriteria bookSearchCriteria);
	
    BookTo saveBook(BookTo book);
}
