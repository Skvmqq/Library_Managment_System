import java.io.Serializable;
import java.util.*;

public  class Library implements Serializable {



    List<Book> books ;// declare Array that can hold object of book class
    List<Student>Students;
    List<User>user;
    List<Librarian> librarians;

    private static final long serialVersionUID = 8936736939340561802L;


    Library()
{
    books=new ArrayList<>();
    Students=new ArrayList<>();
    librarians = new ArrayList<>();
    user =new ArrayList<>();

}
     public void  addabook(Book book)    //this method take book object as a parameter
    {
      books.add(book);
    }
   public void remove_book(Book book)
   {
       books.remove(book);
   }


    public void addStudent(Student student) {
        Students.add(student);
    }
    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }
    public List<Book> getBooks() {
        return books;
    }

    public List<Student> getStudents() {
        return Students;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }
     Student findStudentByUsernameAndPassword(String username, String password) {
        for (Student student : Students) {
            System.out.println("Checking Student: " + student.getUser_id() + ", " + student.getPassword());
            if (student.getUser_id() != null && student.getPassword() != null &&student.getUser_id().trim().equals(username) && student.getPassword().trim().equals(password)) {
                return student;
            }
        }
        return null; // Student not found
    }
    Librarian findLibrarianByUsernameAndPassword(String username, String password) {
        for (Librarian librarian : librarians) {
            System.out.println("Checking Student: " + librarian.getUser_id() + ", " + librarian.getPassword());
            if (librarian.getUser_id() != null && librarian.getPassword() != null &&librarian.getUser_id().trim().equals(username) && librarian.getPassword().trim().equals(password)) {
                return librarian;
            }
        }
        return null; // Student not found
    }
    public Book findBookByISBN(int isbn) {
        for (Book book : books) {
            if (book.getIsbn() == isbn) {
                return book;
            }
        }
        return null; // Book not found
    }
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            //System.out.println("Book Title: " + book.getTitle());
            System.out.println("Book Title (Library): " + book.getTitle() + ", Length: " + book.getTitle().length());
            if (book.getTitle().equals(title)) {
                return book;
            }
            System.out.println("Entered Title: " + title+ ", Length: " + title.length());
        }
        return null; // Book not found
    }

    public void display()
{
    for(Book book:books)
    {
       System.out.println("BookTitle: "+book.getTitle()+
               ",Author:"+book.getAuthor()+
               ",Isbn :"+ book.getIsbn());
    }
}
    public void displayStudents() {
        for (Student student : Students) {
            System.out.println("Student ID: " + student.getUser_id() +
                    ", Name: " + student.getUser_name() +
                    ", Email: " + student.getEmail_id() +
                    ", Phone: " + student.getPhone_number());
        }
    }

    public void displayLibrarians() {
        for (Librarian librarian : librarians) {
            System.out.println("Librarian ID: " + librarian.getUser_id() +
                    ", Name: " + librarian.getUser_name() +
                    ", Email: " + librarian.getEmail_id() +
                    ", Phone: " + librarian.getPhone_number());
        }
    }


}