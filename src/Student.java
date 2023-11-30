
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





public class Student extends User implements Serializable {
    List<Book> borrowed_books;

    public Student(String user_id, String password) {
        super(user_id, password);
        this.borrowed_books = new ArrayList<>();
    }

    public List<Book> getBorrowed_books()
    {
        return borrowed_books;
    }

    public Student(String User_name, String email_id, int phone_number, String user_id, String password) {
        super(User_name, email_id, phone_number, user_id, password);
        this.borrowed_books = new ArrayList<>();
    }

    public void Borrow_book(Library library, Book b) {
        if (library != null && b != null) {
            if (library.getBooks().contains(b)) {
                borrowed_books.add(b);
                library.getBooks().remove(b);
            }
        }
    }

    public void Return_book(Library library, Book b) {
        if (b != null) {
            if (borrowed_books.contains(b)) {
                borrowed_books.remove(b);
                library.addabook(b);
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Error: Book was not borrowed.");
            }
        } else {
            System.out.println("Error: Book is null.");
        }
    }

    public void Display_Borrowed_Books() {
        System.out.println("Borrowed Books");
        if (borrowed_books.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            for (Book book : borrowed_books) {
                System.out.println("Book Title: " + book.getTitle());
            }
        }
    }

}