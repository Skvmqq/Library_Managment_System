import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveBookGui {
    JFrame removeBookFrame;
    JTextField isbnField;
    JButton removeButton;
    Library library;

    RemoveBookGui(Library library) {
        this.library = library;
        removeBookFrame = new JFrame("Remove Book");
        isbnField = new JTextField(20);
        removeButton = new JButton("Remove Book");

        setGui_();
    }

    private void setGui_() {
        removeBookFrame.setLayout(new GridLayout(3, 1));
        removeBookFrame.setSize(300, 150);
        removeBookFrame.add(new JLabel("Enter ISBN of the book to remove:"));
        removeBookFrame.add(isbnField);
        removeBookFrame.add(removeButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBook();
            }
        });

        removeBookFrame.setVisible(true);
    }

    private void removeBook() {
        try {
            int isbn = Integer.parseInt(isbnField.getText());
            Book bookToRemove = library.findBookByISBN(isbn);

            if (bookToRemove != null) {
                library.remove_book(bookToRemove);
                JOptionPane.showMessageDialog(removeBookFrame, "Book removed successfully!");
            } else {
                JOptionPane.showMessageDialog(removeBookFrame, "Book with the given ISBN not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(removeBookFrame, "Invalid ISBN. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
