package lt.viko.eif.o.sharapova.library.exception;

/**
 * Exception that arises when no library was found.
 *
 * EmployeeNotFoundException is an exception used to indicate when an employee is looked up but not found.
 */
public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException() {
        super();
    }

    public LibraryNotFoundException(String message) {
        super(message);
    }

    public LibraryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
