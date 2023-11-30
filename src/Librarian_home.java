import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Librarian_home {



        JFrame create_frame_librarian;
        JButton Add_book;
        JButton Remove_book;
        JButton Veiw_book;
        JButton Exit_;
        Library library;

        Librarian_home(Library library) {
            create_frame_librarian = new JFrame();
            Add_book = new JButton("Add Book");
            Remove_book = new JButton("Remove  Book ");
            Veiw_book= new JButton("Veiw Books");
            Exit_= new JButton("Exit");
            this.library=library;


        }

        public void setCreate_frame_librarian() {
            create_frame_librarian.setVisible(true);
            create_frame_librarian.setVisible(true);
            create_frame_librarian.setLayout(new GridLayout(5, 5));
            create_frame_librarian.setSize(400, 400);
            create_frame_librarian.add(Add_book);
            create_frame_librarian.add(Remove_book);
            create_frame_librarian.add(Veiw_book);
            create_frame_librarian.add(Exit_);

            Add_book.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddBookGui(library);

                }
             });

            Remove_book.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new RemoveBookGui(library);

                }
            });

            Veiw_book.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BookTable libraryTable = new BookTable();
                    System.out.println("Number of books in the library: " + library.getBooks().size());
                    // Display the books in the table
                    libraryTable.book_table_fun(library.getBooks());
                    libraryTable.Display(library.getBooks());


                    // Show the table
                    libraryTable.showtable();
                }
            });
            Exit_.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    // Logic for exit button
                    System.out.println("Exit button clicked");

                    // Add your code here
                    create_frame_librarian.dispose();
                }
            });

        }


    }



