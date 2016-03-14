package pl.spring.demo.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LibraryRepositoryTest {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	@Transactional
	@Rollback(true)
	public void testShouldDeleteLibraryWithAllBooks() {
		//given
		long libraryId = 14L;
		int numberOfBooks = bookRepository.findAll().size();
		//when
		libraryRepository.delete(libraryId);
		//then
		assertNotEquals(numberOfBooks,0);
		assertNull(libraryRepository.findOne(libraryId));
		assertNotEquals(numberOfBooks, bookRepository.findAll().size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testShoulFindAllLibrariesByName() {
		//given
		String name = "bibl";
		//expected 
		String expected = "Biblioteka Miejska";
		//when
		List<LibraryEntity> findLibraryByName = libraryRepository.findLibraryByName(name);
		//then
		assertTrue(findLibraryByName.size()>0);
		assertEquals(expected, findLibraryByName.get(0).getName());
	}

}
