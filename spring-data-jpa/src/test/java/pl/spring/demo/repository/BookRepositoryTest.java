package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.entity.BookEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void testShouldFindBookById() {
		// given
		final long bookId = 1;
		// when
		BookEntity bookEntity = bookRepository.findOne(bookId);
		// then
		assertNotNull(bookEntity);
		assertEquals("Pierwsza książka", bookEntity.getTitle());
	}

	@Test
	public void testShouldFindBooksByTitle() {
		// given
		final String bookTitle = "p";
		// when
		List<BookEntity> booksEntity = bookRepository.findBookByTitle(bookTitle);
		// then
		assertNotNull(booksEntity);
		assertFalse(booksEntity.isEmpty());
		assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksByAuthorFirstName() {
		// given
		final String author = "jan";
		// when
		List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
		// then
		assertNotNull(booksEntity);
		assertFalse(booksEntity.isEmpty());
		assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
	}

	@Test
	public void testShouldFindBooksByAuthorLastName() {
		// given
		final String author = "kowalski";
		// when
		List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
		// then
		assertNotNull(booksEntity);
		assertFalse(booksEntity.isEmpty());
		assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
	}

	@Test
	public void testShouldFindAllBookByCriteria() {
		String title = null;
		String author = null;
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(4, findBookByCriteria.size());
	}

	@Test

	public void testShouldFindBookByCriteriaTitle() {
		String title = "Pierwsza książka";
		String author = null;
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
	}

	@Test
	public void testShouldFindBookByCriteriaAuthor() {
		String title = null;
		String author = "Zbigniew Nowak";
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
	}

	@Test
	public void testShouldFindBookByCriteriaLibraryName() {
		String title = null;
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		for (BookEntity bookEntity : findBookByCriteria) {
			assertEquals(bookSearchCriteria.getLibraryName(), bookEntity.getLibrary().getName());
		}
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(3, findBookByCriteria.size());
	}

	@Test
	public void testShouldFindBookByCriteriaTitleAuthor() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
	}

	@Test
	public void testShouldFindBookByCriteriaTitleLibrary() {
		String title = "Pierwsza książka";
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getLibraryName(), findBookByCriteria.get(0).getLibrary().getName());
	}

	@Test
	public void testShouldFindBookByCriteriaAuthorLibrary() {
		String title = null;
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getLibraryName(), findBookByCriteria.get(0).getLibrary().getName());
	}

	@Test
	public void testShouldFindBookByCriteriaTitleAuthorLibrary() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookEntity> findBookByCriteria = bookRepository.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getLibraryName(), findBookByCriteria.get(0).getLibrary().getName());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
	}

}
