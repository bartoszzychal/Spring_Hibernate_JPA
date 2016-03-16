package pl.spring.demo.repository.predicates;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.types.expr.BooleanExpression;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.entity.QAuthorEntity;
import pl.spring.demo.entity.QBookEntity;

public class BookPredicate {

	public static final QBookEntity bookEntity = QBookEntity.bookEntity;
	public static final QAuthorEntity authorEntity = QAuthorEntity.authorEntity;

	public static BooleanBuilder preparePredicate(BookSearchCriteria bookSearchCriteria){
		BooleanBuilder where = new BooleanBuilder();
		if(bookSearchCriteria.getTitle()!= null){
			String title = bookSearchCriteria.getTitle();
			where.and(bookHasTitleLike(title));
		}
		if(bookSearchCriteria.getAuthor()!= null){
			String author = bookSearchCriteria.getAuthor();
			where.and(bookHasAuthorLike(author));
		}
		if(bookSearchCriteria.getLibraryName()!= null){
			String libraryName = bookSearchCriteria.getLibraryName();
			where.and(bookInLibraryLike(libraryName));
		}
		return where;
	}

	public static BooleanExpression bookInLibraryLike(String libraryName) {
		return bookEntity.library().name.likeIgnoreCase(libraryName);
	}

	public static BooleanExpression bookHasAuthorLike(String author) {
		String[] author_ = author.split(" ",2);
		String firstName = author_[0];
		String lastName = author_[1];
		return bookEntity.authors.contains(
				new JPASubQuery()
				.from(authorEntity)
				.where(authorEntity.firstName.like(firstName).and(authorEntity.lastName.like(lastName)))
				.unique(authorEntity)
				);
	}
	
	public static BooleanExpression bookHasTitleLike(String title) {
		return bookEntity.title.likeIgnoreCase(title);
	}

}
