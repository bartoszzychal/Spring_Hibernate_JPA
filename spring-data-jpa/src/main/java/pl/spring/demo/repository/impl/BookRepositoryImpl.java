package pl.spring.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JPQL;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.jpa.EclipseLinkTemplates;
import com.mysema.query.jpa.impl.JPAQuery;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.repository.BookSearchCriteriaRepositoryCustom;
import pl.spring.demo.repository.predicates.BookPredicate;

@Repository
@Transactional(readOnly = true)
public class BookRepositoryImpl implements BookSearchCriteriaRepositoryCustom{

	@PersistenceContext(name = "hsql")
	private EntityManager entityManager;
	
	@Autowired
	private JinqJPAStreamProvider jingJPAStreamProvider;

	@Override
	public List<BookEntity> findBookByCriteria(BookSearchCriteria bookSearchCriteria) {
		return new JPAQuery(entityManager, EclipseLinkTemplates.DEFAULT)
				.from(BookPredicate.bookEntity)
				.where(BookPredicate.preparePredicate(bookSearchCriteria))
				.list(BookPredicate.bookEntity);
	}

	@Override
	public List<BookEntity> findBookByCriteriaJinq(BookSearchCriteria bookSearchCriteria) {
		JPAJinqStream<BookEntity> stream = jingJPAStreamProvider.streamAll(entityManager, BookEntity.class);
		if(bookSearchCriteria.getTitle() != null){
			String title = bookSearchCriteria.getTitle().toLowerCase();
			stream = stream.where(book -> book.getTitle().toLowerCase().equals(title));
		}
		if(bookSearchCriteria.getAuthor() != null){
			String author = bookSearchCriteria.getAuthor().toLowerCase();
			stream = stream.where((book,authors) -> JPQL.isIn(author, authors.stream(AuthorEntity.class)
													.where((a) -> book.getAuthors().contains(a))
													.select((a) -> (a.getFirstName()+" "+a.getLastName()).toLowerCase())
													)
					);
					
		}
		if(bookSearchCriteria.getLibraryName() != null){
			String libraryName = bookSearchCriteria.getLibraryName().toLowerCase();
			stream = stream.where(book -> book.getLibrary().getName().toLowerCase().equals(libraryName));
		}
		return stream.toList();
	}
	
	
}
