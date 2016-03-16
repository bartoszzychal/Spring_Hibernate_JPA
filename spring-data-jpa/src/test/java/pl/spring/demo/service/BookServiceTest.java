package pl.spring.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.criteria.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
	public void testShouldFindAllBookByCriteria_Repo() {
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

	public void testShouldFindBookByCriteriaTitle_Repo() {
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
	public void testShouldFindBookByCriteriaAuthor_Repo() {
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
	public void testShouldFindBookByCriteriaLibraryName_Repo() {
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
	public void testShouldFindBookByCriteriaTitleAuthor_Repo() {
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
	public void testShouldFindBookByCriteriaTitleLibrary_Repo() {
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
	public void testShouldFindBookByCriteriaAuthorLibrary_Repo() {
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
	public void testShouldFindBookByCriteriaTitleAuthorLibrary_Repo() {
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
	@Test
	public void testShouldFindAllBookByCriteria_Jinq() {
		String title = null;
		String author = null;
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(4, findBookByCriteria.size());
	}
	
	@Test
	
	public void testShouldFindBookByCriteriaTitle_Jinq() {
		String title = "Pierwsza książka";
		String author = null;
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
	}
	
	@Test
	public void testShouldFindBookByCriteriaAuthor_Jinq() {
		String title = null;
		String author = "Zbigniew Nowak";
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaLibraryName_Jinq() {
		String title = null;
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(3, findBookByCriteria.size());
		for (BookTo bookTo : findBookByCriteria) {
			assertEquals(bookSearchCriteria.getLibraryName(), bookTo.getLibraryName());
		}
	}
	
	@Test
	public void testShouldFindBookByCriteriaTitleAuthor_Jinq() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = null;
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaTitleLibrary_Jinq() {
		String title = "Pierwsza książka";
		String author = null;
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());
	}
	
	@Test
	public void testShouldFindBookByCriteriaAuthorLibrary_Jinq() {
		String title = null;
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());
	}
	
	@Test
	public void testShouldFindBookByCriteriaTitleAuthorLibrary_Jinq() {
		String title = "Pierwsza książka";
		String author = "Jan Kowalski";
		String libraryName = "Biblioteka Miejska";
		BookSearchCriteria bookSearchCriteria = new BookSearchCriteria(title, author, libraryName);
		List<BookTo> findBookByCriteria = bookService.findBookByCriteriaJinq(bookSearchCriteria);
		assertNotNull(findBookByCriteria);
		assertFalse(findBookByCriteria.isEmpty());
		assertEquals(1, findBookByCriteria.size());
		assertEquals(bookSearchCriteria.getTitle(), findBookByCriteria.get(0).getTitle());
		assertEquals(bookSearchCriteria.getAuthor(), findBookByCriteria.get(0).getAuthors());
		assertEquals(bookSearchCriteria.getLibraryName(),findBookByCriteria.get(0).getLibraryName());
		
	}


}
