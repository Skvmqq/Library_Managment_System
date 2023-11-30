import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {

    Library library = new Library();
    Student newStudent = new Student("S", "h", 2, "j", "s");
    Librarian lib = new Librarian("S", "h", 2, "j", "s");
    Book book = new Book("Book1", "Author1", 123456);

    StudentTest()
    {
        library.addabook(book);
        library.addabook(new Book("Book2", "Author2", 789012));
        library.addStudent(newStudent);
        library.addLibrarian(lib);
    }

    @Test
    void TestBorrowBook() {
        //Asserting that the library contains the book
        Assertions.assertTrue(library.getBooks().contains(book));

        //Asserting that the student does not have the book
        Assertions.assertFalse(newStudent.getBorrowed_books().contains(book));

        //Borrowing the book
        newStudent.Borrow_book(library, book);

        //Asserting that the library does not have the book now
        Assertions.assertFalse(library.getBooks().contains(book));

        //Asserting that the student has the book now
        Assertions.assertTrue(newStudent.getBorrowed_books().contains(book));
    }

    @Test
    void TestBorrowAndReturnBook() {
        newStudent.Borrow_book(library, book);
        //The library no longer has the book, and the student does
        //This has been established in the previous test

        //Student returns the book
        newStudent.Return_book(library, book);

        //Asserting that the library has the book now
        Assertions.assertTrue(library.getBooks().contains(book));

        //Asserting that the student does not have the book now
        Assertions.assertFalse(newStudent.getBorrowed_books().contains(book));
    }
}