package lt.viko.eif.o.sharapova.library.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Integer studentID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "course_number")
    private Integer course;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Loan> scheduleRecords = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String address, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.course = course;
    }

    /**
     * Returns the ID of this student.
     *
     * @return student ID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Returns the first name of this student.
     *
     * @return student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a new first name for this student.
     *
     * @param firstName a new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the first name of this student.
     *
     * @return student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a new last name for this student.
     *
     * @param lastName a new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the date of birth of this student.
     *
     * @return student's date of birth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets a date of birth for this student.
     *
     * @param dateOfBirth date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the address of this student.
     *
     * @return student's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets a new address for this student.
     *
     * @param address a new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns a course number of this student.
     *
     * @return course number
     */
    public int getCourse() {
        return course;
    }

    /**
     * Sets a new course number for this student.
     *
     * @param course a new course number
     */
    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", course=" + course +
                '}';
    }
}
