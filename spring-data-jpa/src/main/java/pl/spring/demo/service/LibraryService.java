package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.LibraryTo;

public interface LibraryService {
	void deleteLibrary(String name);
	List<LibraryTo> findLibrariesByName(String name);
}
