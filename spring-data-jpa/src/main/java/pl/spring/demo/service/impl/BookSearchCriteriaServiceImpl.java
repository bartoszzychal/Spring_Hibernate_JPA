package pl.spring.demo.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.repository.predicates.BookPredicate;
import pl.spring.demo.service.BookSearchCriteriaService;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class BookSearchCriteriaServiceImpl implements BookSearchCriteriaService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookTo> findBookByCriteria(BookSearchCriteria bookSearchCriteria) {
		return BookMapper.map2To(
				StreamSupport.stream(
					bookRepository
					.findAll(BookPredicate.preparePredicate(bookSearchCriteria))
					.spliterator(), false)
					.collect(Collectors.toList())
				);
	}

	@Override
	public List<BookTo> findBookByCriteriaRepo(BookSearchCriteria bookSearchCriteria) {
		return BookMapper.map2To(bookRepository.findBookByCriteria(bookSearchCriteria));
	}
	
}
