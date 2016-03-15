package pl.spring.demo.service;

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
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceTest {

	@Autowired
	private BookService bookService;

	@Test
	public void testShouldFindAllBookByCriteria() {
		String title = null;
		String author = null;
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
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
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
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
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
	}

	@Test
	public void testShouldFindBookByCriteriaLibraryName() {
		String title = null;
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(3, findBookByCriteria.size());
		for (BookTo bookTo : findBookByCriteria) {
			assertEquals(bookSearchCriteria.getLibraryName(), bookTo.getLibraryName());
		}
	}

	@Test
	public void testShouldFindBookByCriteriaTitleAuthor() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
	}

	@Test
	public void testShouldFindBookByCriteriaTitleLibrary() {
		String title = "Pierwsza książka";
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());

	}

	@Test
	public void testShouldFindBookByCriteriaAuthorLibrary() {
		String title = null;
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());

	}

	@Test
	public void testShouldFindBookByCriteriaTitleAuthorLibrary() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteria(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());

	}
	
	@Test
	public void testShouldFindAllBookByCriteriaRepo() {
		String title = null;
		String author = null;
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(4, findBookByCriteria.size());
	}

	@Test

	public void testShouldFindBookByCriteriaRepoTitle() {
		String title = "Pierwsza książka";
		String author = null;
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
	}

	@Test
	public void testShouldFindBookByCriteriaRepoAuthor() {
		String title = null;
		String author = "Zbigniew Nowak";
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
	}

	@Test
	public void testShouldFindBookByCriteriaRepoLibraryName() {
		String title = null;
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(3, findBookByCriteria.size());
		for (BookTo bookTo : findBookByCriteria) {
			assertEquals(bookSearchCriteria.getLibraryName(), bookTo.getLibraryName());
		}
	}

	@Test
	public void testShouldFindBookByCriteriaRepoTitleAuthor() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
	}

	@Test
	public void testShouldFindBookByCriteriaRepoTitleLibrary() {
		String title = "Pierwsza książka";
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());
	}

	@Test
	public void testShouldFindBookByCriteriaRepoAuthorLibrary() {
		String title = null;
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());
	}

	@Test
	public void testShouldFindBookByCriteriaRepoTitleAuthorLibrary() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaRepo(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());

	}


}
