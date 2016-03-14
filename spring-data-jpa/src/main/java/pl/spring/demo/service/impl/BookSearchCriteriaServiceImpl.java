package pl.spring.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.repository.LibraryRepository;
import pl.spring.demo.service.BookSearchCriteriaService;
import pl.spring.demo.to.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class BookSearchCriteriaServiceImpl implements BookSearchCriteriaService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public List<BookTo> findBookByCriteria(BookSearchCriteria bookSearchCriteria) {
		return null;
	}
}
