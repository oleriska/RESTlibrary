package lt.viko.eif.o.sharapova.library.service;

import lt.viko.eif.o.sharapova.library.exception.LibraryNotFoundException;
import lt.viko.eif.o.sharapova.library.model.Library;
import lt.viko.eif.o.sharapova.library.repository.LibraryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * {@link Library} service that handles the business logic of working with resources and serves as a
 * bridge between {@link lt.viko.eif.o.sharapova.library.controller.LibraryRestController} and
 * {@link LibraryJpaRepository}
 */
@Service
public class LibraryService {

    private final LibraryJpaRepository libraryJpaRepository;

    @Autowired
    public LibraryService(LibraryJpaRepository libraryJpaRepository) {
        this.libraryJpaRepository = libraryJpaRepository;
    }
    /**
     * Returns all the libraries.
     *
     * @return list of {@link Library}
     */
    public List<Library> getAllLibraries() {
        return libraryJpaRepository.findAll();
    }

    /**
     * Returns a library with specified name.
     *
     * @param name name of the library to search for
     * @return {@link Library}
     */
    public Library getLibraryByName(String name) {
        Optional<Library> library = libraryJpaRepository.findLibraryByName(name);

        if (library.isPresent()) return library.get();

        throw new LibraryNotFoundException("Library with the name '" + name + "' not found!");
    }

    /**
     * Returns all the libraries that have the specified book in stock.
     *
     * @param bookTitle book title to search by
     * @return list of {@link Library}
     */
    public List<Library> getLibrariesByBook(String bookTitle) {
        List<Library> libraries = libraryJpaRepository.findLibrariesByBookTitle(bookTitle);

        if (libraries.size() > 0) return libraries;

        throw new LibraryNotFoundException("There's no libraries that has the book '" + bookTitle + "' in stock!");
    }

}
