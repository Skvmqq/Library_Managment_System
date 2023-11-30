import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryTest {
    Library library = new Library();
    Student newStudent = new Student("S", "h", 2, "j", "s");
    Librarian lib = new Librarian("S", "h", 2, "j", "s");
    Book book = new Book("Book1", "Author1", 123456);

    LibraryTest()
    {
        library.addabook(book);
        library.addabook(new Book("Book2", "Author2", 789012));
        library.addStudent(newStudent);
        library.addLibrarian(lib);
    }

    /*@Test
    void TestAddBook()
    {
        Book newBook = new Book("Book3", "Author3", 345678);

        //Library does not have new book currently
        Assertions.assertFalse(library.getBooks().contains(newBook));

        //Adding the book
        library.addabook(newBook);

        //Library has the book now
        Assertions.assertTrue(library.getBooks().contains(newBook));
    }

    @Test
    void TestRemoveBook()
    {
        //Asserting that library has the book
        Assertions.assertTrue(library.getBooks().contains(book));

        //Removing the book
        library.remove_book(book);

        //Asserting that library does not have the book
        Assertions.assertFalse(library.getBooks().contains(book));
    }*/

    @Test
    void TestAddStudent()
    {
        Student newStudent2 = new Student("testStudent", "testStudent", 1234, "testStudent", "testStudent");

        //Asserting that the new student is not in the library system
        Assertions.assertFalse(library.getStudents().contains(newStudent2));

        //Adding the new student to the library system
        library.addStudent(newStudent2);

        //Asserting that the new student is in the library system
        Assertions.assertTrue(library.getStudents().contains(newStudent2));
    }

    @Test
    void TestAddLibrarian()
    {
        Librarian testLibrarian = new Librarian("testLibrarian", "testLibrarian", 1234, "testLibrarian", "testLibrarian");

        //Asserting that the new student is not in the library system
        Assertions.assertFalse(library.getLibrarians().contains(testLibrarian));

        //Adding the new student to the library system
        library.addLibrarian(testLibrarian);

        //Asserting that the new student is in the library system
        Assertions.assertTrue(library.getLibrarians().contains(testLibrarian));
    }

    @Test
    void TestFindBookByISBN()
    {
        //Getting book ISBN
        int bookIsbn = book.getIsbn();

        //Found book
        Book foundBook = library.findBookByISBN(bookIsbn);

        //Asserting not null
        Assertions.assertNotNull(foundBook);
    }

    @Test
    void TestFindBookByTitle()
    {
        //Getting book Title
        String bookTitle = book.getTitle();

        //Found book
        Book foundBook = library.findBookByTitle(bookTitle);

        //Asserting not null
        Assertions.assertNotNull(foundBook);
    }

    @Test
    void TestLibrarianLogin()
    {
        //Find librarian
        Librarian foundLibrarian = library.findLibrarianByUsernameAndPassword("j", "s");
        //Asserting that librarian is found
        Assertions.assertNotNull(foundLibrarian);
    }

    @Test
    void TestStudentLogin()
    {
        //Find student
        Student foundStudent = library.findStudentByUsernameAndPassword("j", "s");
        //Asserting that student is found
        Assertions.assertNotNull(foundStudent);
    }
}