import java.io.Serializable;

public class Librarian extends User implements Serializable {
    public Librarian(String user_id, String password )
    {
        super(user_id,password);
    }
    Librarian(String User_name,String email_id,int phone_number,String user_id,String password)
    {
        //this.user_id=user_id;
        super(User_name,email_id,phone_number,user_id,password);
    }
    //add a book in library by liberian
    public void add_a_new_Book(Library library,Book b)
    {
    library.addabook(b);
    }
    public void remove_book(Library library, Book b)
    {
        library.remove_book(b);
    }
    public String getUsername()
    {
        return getUser_name();
    }

}
