import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookGui {

    JFrame frame;
    JLabel enterBookTitleLabel;
    JLabel enterBookAuthorLabel;
    JLabel enterBookISBNLabel;
    JButton returnButton;
    Library library;
    Student student;
    JTextField bookTitleTextField;
    JTextField bookAuthorTextField;
    JTextField bookISBNTextField;

    ReturnBookGui(Library library, Student student) {
        frame = new JFrame("Return Book");
        enterBookTitleLabel = new JLabel("Enter the title of the book:");
        enterBookAuthorLabel = new JLabel("Enter the author of the book:");
        enterBookISBNLabel = new JLabel("Enter the ISBN of the book:");
        returnButton = new JButton("Return");
        bookTitleTextField = new JTextField(20);
        bookAuthorTextField = new JTextField(20);
        bookISBNTextField = new JTextField(20);
        this.library = library;
        this.student = student;
    }

    void setFrame() {
        frame.setLayout(new GridLayout(4, 2));
        frame.setSize(400, 200);
        frame.add(enterBookTitleLabel);
        frame.add(bookTitleTextField);
        frame.add(enterBookAuthorLabel);
        frame.add(bookAuthorTextField);
        frame.add(enterBookISBNLabel);
        frame.add(bookISBNTextField);
        frame.add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBook();
            }
        });

        frame.setVisible(true);
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private void returnBook() {
        try {
            if (student == null) {
                JOptionPane.showMessageDialog(frame, "Error: Student not set.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String title_ = bookTitleTextField.getText().trim();
            String author_ = bookAuthorTextField.getText().trim();
            int isbn_;
            try {
                isbn_ = Integer.parseInt(bookISBNTextField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Book bookToReturn = new Book(title_, author_, isbn_);

            student.Return_book(library, bookToReturn);
            JOptionPane.showMessageDialog(frame, "Book returned successfully!");
            frame.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "An unexpected error occurred. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
