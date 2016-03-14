package pl.spring.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.mapper.LibraryMapper;
import pl.spring.demo.repository.LibraryRepository;
import pl.spring.demo.service.LibraryService;
import pl.spring.demo.to.LibraryTo;

@Service
@Transactional(readOnly = true)
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public void deleteLibrary(String name) {
		libraryRepository.delete(libraryRepository.findLibraryByName(name));
	}

	@Override
	public List<LibraryTo> findLibrariesByName(String name) {
		return LibraryMapper.map2Entity(libraryRepository.findLibraryByName(name));
	}
	

}
