package lt.viko.eif.o.sharapova.library.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "loan")
public class Loan {

    @Id
    @GeneratedValue
    @Column(name = "loan_id")
    private Integer loanID;

    @ManyToOne
    private Library library;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loaned_book_id", referencedColumnName = "book_id")
    private Book book;

    @Column(name = "loan_from")
    private LocalDate loanFrom;

    @Column(name = "loan_to")
    private LocalDate loanTo;

    /**
     * Class constructor that creates a new {@link Loan} instance.
     *
     * @param student student ID
     * @param book book ID
     * @param loanFrom starting date
     * @param loanTo ending date
     */
    public Loan(Library library, Student student, Book book, LocalDate loanFrom, LocalDate loanTo) {
        this.library = library;
        this.student = student;
        this.book = book;
        this.loanFrom = loanFrom;
        this.loanTo = loanTo;
    }

    /**
     * No-arg default constructor.
     */
    public Loan() {
    }

    /**
     * Returns an ID for this loan.
     *
     * @return loan ID
     */
    public int getLoanID() {
        return loanID;
    }

    /**
     * Sets a new ID for this loan.
     *
     * @param id loan ID
     */
    public void setLoanID(int id) {
        this.loanID = id;
    }

    /**
     * Returns the starting date of this loan.
     *
     * @return starting date of the loan
     */
    public LocalDate getLoanFrom() {
        return loanFrom;
    }

    /**
     * Sets a new starting date for this loan.
     *
     * @param loanFrom a new starting date
     */
    public void setLoanFrom(LocalDate loanFrom) {
        this.loanFrom = loanFrom;
    }

    /**
     * Returns the ending date of this loan.
     *
     * @return ending date of the loan
     */
    public LocalDate getLoanTo() {
        return loanTo;
    }

    /**
     * Sets a new ending date for this loan.
     *
     * @param loanTo a new ending date
     */
    public void setLoanTo(LocalDate loanTo) {
        this.loanTo = loanTo;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return "\n\t\tLoan \n" +
                "\t\t\tid=" + loanID +
                ",\n\t\t\tstudent=" + student +
                ",\n\t\t\tbook=" + book +
                ",\n\t\t\tloanFrom=" + loanFrom +
                ",\n\t\t\tloanTo=" + loanTo +
                "\n";
    }
}
