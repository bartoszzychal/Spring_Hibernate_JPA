package pl.spring.demo.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {

	@Autowired
	private LibraryDao libraryDao;
	
	@Test
	public void test() {
		//given
		String name = "bibl";
		//expected 
		String expected = "Biblioteka Miejska";
		//when
		List<LibraryEntity> findLibraryByName = libraryDao.findLibraryByName(name);
		//then
		assertTrue(findLibraryByName.size()>0);
		assertEquals(expected, findLibraryByName.get(0).getName());
	}

}
