
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

     class AddBookGui {
        private JFrame book_add_frame;
        private JTextField titleField;
        private JTextField authorField;
        private JTextField isbnField;
        private Library library;

         AddBookGui(Library library) {
            this.library = library;
            book_add_frame = new JFrame("Add Book");
            titleField = new JTextField(20);
            authorField = new JTextField(20);
            isbnField = new JTextField();
            JButton addButton = new JButton("Add Book");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String title = titleField.getText();
                    String author = authorField.getText();
                    //int  isbn = isbnField.getText();
                    try {
                        // Attempt to parse the text from isbnField to an integer
                        int isbn = Integer.parseInt(isbnField.getText());

                        // Create a new book and add it to the library
                        Book newBook = new Book(title, author, isbn);
                        library.addabook(newBook);

                        // Optionally, you can display a message or perform other actions
                        JOptionPane.showMessageDialog(book_add_frame, "Book added successfully!");

                        // Clear the input fields
                        titleField.setText("");
                        authorField.setText("");
                        isbnField.setText("");
                    } catch (NumberFormatException ex) {
                        // Handle the case where the text in isbnField is not a valid integer
                        JOptionPane.showMessageDialog(book_add_frame, "Invalid ISBN. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    }


                    // Create a new book and add it to the library

                }
            });

            JPanel panel = new JPanel(new GridLayout(4, 2));
            panel.add(new JLabel("Title:"));
            panel.add(titleField);
            panel.add(new JLabel("Author:"));
            panel.add(authorField);
            panel.add(new JLabel("ISBN:"));
            panel.add(isbnField);
            panel.add(new JLabel(""));
            panel.add(addButton);

            book_add_frame.add(panel);
            book_add_frame.setSize(300, 200);
            book_add_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            book_add_frame.setVisible(true);
        }
    }


