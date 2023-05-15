package lt.viko.eif.o.sharapova.library.repository;

import lt.viko.eif.o.sharapova.library.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * {@link Library} JPA repository that provides custom queries besides default ones provided out-of-the-box.
 */
@Repository
public interface LibraryJpaRepository extends JpaRepository<Library, Integer> {

    @Query(value = "SELECT * FROM LIBRARY lbr WHERE lbr.name=?1", nativeQuery = true)
    Optional<Library> findLibraryByName(String name);

    @Query(value = "SELECT * FROM LIBRARY lbr " +
            "JOIN LIBRARY_BOOKS lbr_bks ON lbr.LIBRARY_ID = lbr_bks.LIBRARIES_THAT_OWN_THIS_BOOK_LIBRARY_ID " +
            "JOIN BOOK bk ON lbr_bks.BOOKS_BOOK_ID = bk.BOOK_ID " +
            "WHERE bk.TITLE=?1", nativeQuery = true)
    List<Library> findLibrariesByBookTitle(String bookName);

}
