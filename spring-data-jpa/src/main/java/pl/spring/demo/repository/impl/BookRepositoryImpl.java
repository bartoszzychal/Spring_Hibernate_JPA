package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.EclipseLinkTemplates;
import com.mysema.query.jpa.impl.JPAQuery;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.repository.BookSearchCriteriaRepositoryCustom;
import pl.spring.demo.repository.predicates.BookPredicate;

@Repository
@Transactional(readOnly = true)
public class BookRepositoryImpl implements BookSearchCriteriaRepositoryCustom{

	@PersistenceContext(name = "hsql")
	private EntityManager entityManager;

	@Override
	public List<BookEntity> findBookByCriteria(BookSearchCriteria bookSearchCriteria) {
		return new JPAQuery(entityManager, EclipseLinkTemplates.DEFAULT)
				.from(BookPredicate.bookEntity)
				.where(BookPredicate.preparePredicate(bookSearchCriteria))
				.list(BookPredicate.bookEntity);
	}
}
