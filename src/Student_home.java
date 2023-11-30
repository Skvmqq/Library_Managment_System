import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class Student_home {
    JFrame create_frame;
    JButton Borrow_books;
    JButton Return_books;
    JButton Veiw_books;
    JButton Exit;
    Library library;
    BorrowBookGui borrowBookGui;
    Student student;
ReturnBookGui returnBookGui;
    Student_home(Library library) {
        create_frame = new JFrame();
        Borrow_books = new JButton("Borrow Books ");
        Return_books = new JButton("Return Books ");
        Veiw_books = new JButton("Veiw Books");
        Exit = new JButton("Exit");
        this.library=library;
         borrowBookGui = new BorrowBookGui(library,student);
         returnBookGui=new ReturnBookGui(library,student);

    }
    public void setStudent(Student student) {
        this.student = student;
        borrowBookGui.setStudent(student);  // Set the student in BorrowBookGui
    }

    public void guibuild() {
        create_frame.setVisible(true);
        create_frame.setVisible(true);
        create_frame.setLayout(new GridLayout(5, 5));
        create_frame.setSize(400, 400);
        create_frame.add(Borrow_books);
        create_frame.add(Return_books);
        create_frame.add(Veiw_books);
        create_frame.add(Exit);

        Borrow_books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BorrowBookGui borrowBookGui = new BorrowBookGui(library, student);
                borrowBookGui.setFrame();
            }
        });
        Return_books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReturnBookGui returnBookGui = new ReturnBookGui(library, student);
             returnBookGui.setFrame();
            }
        });


         Veiw_books.addActionListener(new ActionListener() {
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
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                // Logic for exit button
                System.out.println("Exit button clicked");

                // Add your code here
                create_frame.dispose();
            }
        });

    }



}

