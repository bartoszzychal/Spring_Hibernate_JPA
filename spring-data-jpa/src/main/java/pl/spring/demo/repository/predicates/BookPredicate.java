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
			where.and(bookHasTitleLike(bookSearchCriteria.getTitle()));
		}
		if(bookSearchCriteria.getAuthor()!= null){
			where.and(bookHasAuthorLike(bookSearchCriteria.getAuthor()));
		}
		if(bookSearchCriteria.getLibraryName()!= null){
			where.and(bookInLibraryLike(bookSearchCriteria.getLibraryName()));
		}
		return where;
	}

	public static BooleanExpression bookInLibraryLike(String libraryName) {
		return bookEntity.library().name.likeIgnoreCase(libraryName);
	}

	public static BooleanExpression bookHasAuthorLike(String author) {
		String[] author_ = author.split(" ",2);
		return bookEntity.authors.contains(
				new JPASubQuery()
				.from(authorEntity)
				.where(authorEntity.firstName.like(author_[0]).and(authorEntity.lastName.like(author_[1])))
				.unique(authorEntity)
				);
	}
	
	public static BooleanExpression bookHasTitleLike(String title) {
		return bookEntity.title.likeIgnoreCase(title);
	}

}
