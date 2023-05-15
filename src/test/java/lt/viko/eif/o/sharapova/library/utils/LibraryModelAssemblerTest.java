package lt.viko.eif.o.sharapova.library.utils;

import lt.viko.eif.o.sharapova.library.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.EntityModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class LibraryModelAssemblerTest {

    private static Library library;

    @BeforeAll
    static void initLibrary() {
        // THE CANADIAN LIBRARY
        library = new Library();

        Author author1 = new Author("Cay", "Horstmann");
        Author author2 = new Author("James", "Clear");
        Author author3 = new Author("Daniel", "Kahneman");

        Book book1 = new Book(author1, "Java Core | Volume 1", 9, LocalDate.of(2016, 2, 10));
        Book book2 = new Book(author1, "Java Core | Volume 2", 9, LocalDate.of(2016, 5, 14));
        Book book3 = new Book(author2, "Atomic Habits", 3, LocalDate.of(2018, 4, 20));
        Book book4 = new Book(author3, "Thinking, Fast and Slow", 2, LocalDate.of(2017, 9, 28));

        Student student1 = new Student("John", "Doe", LocalDate.of(2000, 4, 13), "John's address", 3);
        Student student2 = new Student("Jeremy", "Klarkson", LocalDate.of(2002, 7, 24), "Jeremy's address", 1);

        Loan loan1 = new Loan(library, student1, book1, LocalDate.of(2023, 3, 3),
                LocalDate.of(2023, 3, 10));
        Loan loan2 = new Loan(library, student2, book3, LocalDate.of(2023, 3, 8),
                LocalDate.of(2023, 3, 15));
        Loan loan3 = new Loan(library, student1, book4, LocalDate.of(2023, 4, 15),
                LocalDate.of(2023, 4, 22));

        List<Book> books = new ArrayList<>(List.of(book1, book2, book3, book4));
        List<Loan> loans = new ArrayList<>(List.of(loan1, loan2, loan3));

        library.setName("The Canadian Library");
        library.setBooks(books);
        library.setLoans(loans);
    }

    @Test
    void convertToEntityModelModel() {
        LibraryModelAssembler modelAssembler = new LibraryModelAssembler();
        EntityModel<Library> model = modelAssembler.toModel(library);

        assertEquals(Objects.requireNonNull(model.getContent()).getName(), library.getName());
    }
}