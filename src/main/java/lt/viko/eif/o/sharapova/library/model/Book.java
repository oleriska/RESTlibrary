package lt.viko.eif.o.sharapova.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "book")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Integer bookID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @Column(name = "title")
    private String title;

    @Column(name = "edition")
    private int edition;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private List<Library> librariesThatOwnThisBook = new ArrayList<>();

    /**
     * Class constructor that creates a new {@link Book} entity.
     *
     * @param author the author ID
     * @param title the title of the book
     * @param edition the edition of the book
     * @param releaseDate the date when the book was released
     */
    public Book(Author author, String title, int edition, LocalDate releaseDate) {
        this.author = author;
        this.title = title;
        this.edition = edition;
        this.releaseDate = releaseDate;
    }

    /**
     * No-arg default constructor.
     */
    public Book() {
    }

    /**
     * Returns an ID of this book.
     *
     * @return book ID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * Sets a new ID for this book.
     *
     * @param id a new book ID
     */
    public void setBookID(int id) {
        this.bookID = id;
    }

    /**
     * Returns a title of this book.
     *
     * @return the book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets a new title for this book.
     *
     * @param title a new book title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns an edition of this book.
     *
     * @return the book edition
     */
    public int getEdition() {
        return edition;
    }

    /**
     * Sets a new edition for this book.
     *
     * @param edition a new edition number
     */
    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     * Returns a release date for this book.
     *
     * @return the book release date
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets a new release date for this book.
     *
     * @param releaseDate a new release date
     */
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Library> getLibrariesThatOwnThisBook() {
        return librariesThatOwnThisBook;
    }

    @Override
    public String toString() {
        return "\n\t\t\tBook \n" +
                "\t\t\t\tid=" + bookID +
                ",\n\t\t\t\tauthor=" + author +
                ",\n\t\t\t\ttitle='" + title + '\'' +
                ",\n\t\t\t\tedition='" + edition + '\'' +
                ",\n\t\t\t\treleaseDate=" + releaseDate +
                "\n";
    }
}
