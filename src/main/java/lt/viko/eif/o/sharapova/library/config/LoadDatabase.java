package lt.viko.eif.o.sharapova.library.config;

import lt.viko.eif.o.sharapova.library.model.*;
import lt.viko.eif.o.sharapova.library.repository.LibraryJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A configuration class that preloads data to the embedded H2 database upon
 * the start of an application.
 */
@Configuration
public class LoadDatabase {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LibraryJpaRepository libraryJpaRepository) {

        // THE CANADIAN LIBRARY
        Library library1 = new Library();

        Author author1 = new Author("Cay", "Horstmann");
        Author author2 = new Author("James", "Clear");
        Author author3 = new Author("Daniel", "Kahneman");

        Book book1 = new Book(author1, "Java Core | Volume 1", 9, LocalDate.of(2016, 2, 10));
        Book book2 = new Book(author1, "Java Core | Volume 2", 9, LocalDate.of(2016, 5, 14));
        Book book3 = new Book(author2, "Atomic Habits", 3, LocalDate.of(2018, 4, 20));
        Book book4 = new Book(author3, "Thinking, Fast and Slow", 2, LocalDate.of(2017, 9, 28));

        Student student1 = new Student("John", "Doe", LocalDate.of(2000, 4, 13), "John's address", 3);
        Student student2 = new Student("Jeremy", "Klarkson", LocalDate.of(2002, 7, 24), "Jeremy's address", 1);

        Loan loan1 = new Loan(library1, student1, book1, LocalDate.of(2023, 3, 3),
                                               LocalDate.of(2023, 3, 10));
        Loan loan2 = new Loan(library1, student2, book3, LocalDate.of(2023, 3, 8),
                LocalDate.of(2023, 3, 15));
        Loan loan3 = new Loan(library1, student1, book4, LocalDate.of(2023, 4, 15),
                                               LocalDate.of(2023, 4, 22));

        List<Book> books = new ArrayList<>(List.of(book1, book2, book3, book4));
        List<Loan> loans = new ArrayList<>(List.of(loan1, loan2, loan3));

        library1.setName("The Canadian Library");
        library1.setBooks(books);
        library1.setLoans(loans);

        // THE BRITISH LIBRARY
        Library library2 = new Library();

        Author author1_2 = new Author("Awesome", "Author");
        Author author2_2 = new Author("Cool", "Author");
        Author author3_2 = new Author("Super", "Author");

        Book book1_2 = new Book(author1_2, "Some awesome book", 9, LocalDate.of(2016, 2, 10));
        Book book2_2 = new Book(author1_2, "Atomic Habits", 3, LocalDate.of(2018, 4, 20));
        Book book3_2 = new Book(author2_2, "Cracking the Coding Interview", 3, LocalDate.of(2018, 4, 20));
        Book book4_2 = new Book(author3_2, "Clean Code", 2, LocalDate.of(2017, 9, 28));

        Student student1_2 = new Student("Alex", "Smith", LocalDate.of(2000, 4, 13), "Alex's address", 3);
        Student student2_2 = new Student("Karl", "Johnson", LocalDate.of(2002, 7, 24), "Karl's address", 1);

        Loan loan1_2 = new Loan(library2, student1_2, book1_2, LocalDate.of(2022, 3, 3),
                LocalDate.of(2023, 3, 10));
        Loan loan2_2 = new Loan(library2, student2_2, book3_2, LocalDate.of(2021, 3, 8),
                LocalDate.of(2023, 3, 15));
        Loan loan3_2 = new Loan(library2, student1_2, book4_2, LocalDate.of(2020, 4, 15),
                LocalDate.of(2023, 4, 22));

        List<Book> books_2 = new ArrayList<>(List.of(book1_2, book2_2, book3_2, book4_2));
        List<Loan> loans_2 = new ArrayList<>(List.of(loan1_2, loan2_2, loan3_2));

        library2.setName("The British Library");
        library2.setBooks(books_2);
        library2.setLoans(loans_2);

        return args -> {
            LOGGER.info("Preloading The Canadian Library " + libraryJpaRepository.save(library1));
            LOGGER.info("Preloading The British Library " + libraryJpaRepository.save(library2));
        };
    }
}
