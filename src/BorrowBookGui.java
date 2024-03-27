import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowBookGui {

    JFrame frame;
    JLabel enterBookTitleLabel;
    JButton borrowButton;
    Library library;
    Student student;
    JTextField bookTitleTextField;
    JTextArea bookListArea;
    JScrollPane scrollPane;

    BorrowBookGui(Library library, Student student) {
        frame = new JFrame("Borrow Book");
        enterBookTitleLabel = new JLabel("Enter the title of the book:");
        borrowButton = new JButton("Borrow");
        bookTitleTextField = new JTextField(20);
        bookListArea = new JTextArea("Available Books:\n");
        scrollPane = new JScrollPane(bookListArea);
        this.library = library;
        this.student = student;
    }

     void setFrame() {
        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(400, 200);
         scrollPane.setPreferredSize(new Dimension(400, 100)); // Set preferred size for the scroll pane

        frame.add(enterBookTitleLabel);
        frame.add(bookTitleTextField);
        frame.add(borrowButton);
        frame.add(scrollPane);

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowBook();
            }
        });

        frame.setVisible(true);
         JTextArea bookListArea = new JTextArea("Available Books:\n");
         for (Book book : library.getBooks()) {
             System.out.println("Book Title: " + book.getTitle());
             bookListArea.append(book.getTitle() + "\n");
         }

         updateBookList();

         borrowButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 borrowBook();
             }
         });
    }
     void setStudent(Student student) {
        this.student = student;

    }

    private void borrowBook() {
        try {
            if (student == null) {
                JOptionPane.showMessageDialog(frame, "Error: Student not set.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String title_ = bookTitleTextField.getText().trim();

            if (title_.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a book title.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book bookToBorrow = library.findBookByTitle(title_);

            if (bookToBorrow != null) {
                student.Borrow_book(library, bookToBorrow);
                System.out.println("Printing " + bookToBorrow);
                JOptionPane.showMessageDialog(frame, "Book borrowed successfully!");
                updateBookList();
                frame.dispose();
            }
            // No else block, no message for book not found
        } catch (NumberFormatException ex) {
            // Handle specific exception related to invalid input (if needed)
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid title.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // Handle any other unexpected exceptions
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "An unexpected error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBookList() {
        bookListArea.setText("Available Books:\n");
        for (Book book : library.getBooks()) {
            System.out.println("Book Title: " + book.getTitle());
            bookListArea.append(book.getTitle() + "\n");
        }
    }

}
