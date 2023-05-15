package lt.viko.eif.o.sharapova.library.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "library")
public class Library {

    @Id
    @GeneratedValue
    @Column(name = "library_id")
    private Integer libraryID;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loan> loans = new ArrayList<>();

//    From Hibernate documentation:
//    To preserve synchronicity between both sides (library and loans, library and books),
//    it’s good practice to provide helper methods for adding or removing child entities.

    public void addBook(Book book) {
        books.add(book);
        book.getLibrariesThatOwnThisBook().add(this);
    }

    public void removeBook(Book book) {
        books.remove(book);
        book.getLibrariesThatOwnThisBook().remove(this);
    }

    public void addLoan(Loan loan) {
        loans.add(loan);
        loan.setLibrary(this);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan);
        loan.setLibrary(null);
    }

    /**
     * Class constructor that creates a new {@link Library} entity.
     *
     * @param name the name of the library
     * @param books the list of books present in the library
     * @param loans the list of loans
     */
    public Library(String name, List<Book> books, List<Loan> loans) {
        this.name = name;
        this.books = books;
        this.loans = loans;
    }

    /**
     * Default no-arg constructor.
     */
    public Library() {
    }

    /**
     * Returns a name of the library.
     *
     * @return the name of the library
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a name of the library.
     *
     * @param name a new name of the library
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a list of books present in the library.
     *
     * @return a list of {@link Book}
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Sets a new list of books for this library.
     *
     * @param books a new list of books
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /**
     * Returns a list of loans.
     *
     * @return a list of loans
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * Sets a new list of loans for this library.
     *
     * @param loans a new list of loans
     */
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Library\n")
                .append("\tname='" + name + '\'')
                .append("\n\tbooks:");
        for (Book book : books) {
            builder.append(book);
        }
        builder.append("\tloans:");
        for (Loan loan : loans) {
            builder.append(loan);
        }
        builder.append("\n");

        return builder.toString();
    }
}
