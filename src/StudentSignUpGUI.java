import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSignUpGUI {
    private JFrame frame;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private Library library;

    public StudentSignUpGUI(Library library) {
        this.library = library;

        frame = new JFrame("Student Sign Up");
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        signUpButton = new JButton("Sign Up");

        frame.setLayout(new GridLayout(6, 2));
        frame.add(new JLabel("Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Email:"));
        frame.add(emailField);
        frame.add(new JLabel("Phone Number:"));
        frame.add(phoneField);
        frame.add(new JLabel("User Id :"));
        frame.add(usernameField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpStudent();
            }
        });

        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void signUpStudent() {
        try {


            String name = nameField.getText();
            String email = emailField.getText();
            int phone = Integer.parseInt(phoneField.getText());
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Create a new student and add it to the library
            Student newStudent = new Student(name, email, phone, username, password);
            library.addStudent(newStudent);

            // Display a message indicating successful sign-up
            JOptionPane.showMessageDialog(frame, "Student Sign-Up Successful!");

            // Close the sign-up window
            frame.dispose();
            Student_home studentHomeFrame = new Student_home(library);
            studentHomeFrame.setStudent(newStudent);
            studentHomeFrame.guibuild();
        }catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(frame, "Invalid phone number. Please enter a valid integer.");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(frame, "An error occurred during sign-up.");
            e.printStackTrace();
        }
    }
}
