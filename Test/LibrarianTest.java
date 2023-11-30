import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibrarianTest {
    Library library = new Library();
    Student newStudent = new Student("S", "h", 2, "j", "s");
    Librarian lib = new Librarian("S", "h", 2, "j", "s");
    Book book = new Book("Book1", "Author1", 123456);

    LibrarianTest()
    {
        library.addabook(book);
        library.addabook(new Book("Book2", "Author2", 789012));
        library.addStudent(newStudent);
        library.addLibrarian(lib);
    }

    @Test
    void TestAddANewBook()
    {
        Book newBook = new Book("Book3", "Author3", 345678);

        //The newBook should not be in the library
        Assertions.assertFalse(library.getBooks().contains(newBook));

        //Adding the new book
        lib.add_a_new_Book(library, newBook);

        //The newBook should be in the library
        Assertions.assertTrue(library.getBooks().contains(newBook));
    }

    @Test
    void TestRemoveABook()
    {
        //The book should be be in the library
        Assertions.assertTrue(library.getBooks().contains(book));

        //Removing the book
        lib.remove_book(library, book);

        //The book should not be in the library
        Assertions.assertFalse(library.getBooks().contains(book));
    }
}