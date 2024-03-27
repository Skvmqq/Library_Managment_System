import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Login {
    JFrame frame;
    Library library;
    JLabel Student_name;
    JLabel Librarian_name;
    JLabel Student_password;
    JLabel Librarian_password;
    JTextField Student_nameTF;
    JPasswordField Student_passwordTF;
    JTextField Librarian_nameTF;
    JPasswordField Librarian_passwordTF;
    JButton Student_Login;
    JButton Librarian_login;
    JLabel Student ;
    JLabel Librarian;
    JButton Exit_the_frame;
    JLabel loginStatusLabel;
    Student_home studentHomeFrame;
    Librarian_home librarianHome;
    JButton Student_sign_up;
    //Librarian ludo;



    Login(Library library) {

        frame = new JFrame("Login Table");
        Librarian_name = new JLabel("User Id");
        Librarian_password = new JLabel("Password");
        Librarian_nameTF = new JTextField(30);
        Librarian_passwordTF = new JPasswordField(30);
        Librarian_login = new JButton("Login");
        Student_name = new JLabel("User Id");
        Student_password = new JLabel("Password");
        Student_nameTF = new JTextField(20);
        Student_passwordTF = new JPasswordField(20);
        Student_Login = new JButton("Login");
        Student=new JLabel("Student Login");
        Librarian=new JLabel("Librarian Login");
        Student_sign_up=new JButton("Sign Up");
        Exit_the_frame=new JButton("Exit");


        this.library = library;
        loginStatusLabel = new JLabel();
        studentHomeFrame = new Student_home(library);// Initialize the Student_home instance
        librarianHome = new Librarian_home(library);
        setgui();

    }

    public void setgui() {
        frame.setVisible(true);
        frame.setLayout(new GridLayout(20,30));
        frame.setSize(800,800);
        frame.add(Librarian);
        frame.add(Librarian_name);
        frame.add(Librarian_nameTF);
        frame.add(Librarian_password);

        frame.add(Librarian_passwordTF);
        frame.add(Librarian_login);
        frame.add(Student);
        frame.add(Student_name);
        frame.add(Student_nameTF);
        frame.add(Student_password);
        frame.add(Student_passwordTF);
        frame.add(Student_Login);
        frame.add(Exit_the_frame);
        frame.add(Student_sign_up);

        frame.add(loginStatusLabel);
        frame.add(Box.createRigidArea(new Dimension(20, 20)));


        Librarian_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for librarian login
                System.out.println("Librarian login clicked");

                String enteredUserid = Librarian_nameTF.getText();
                String enteredPass = new String(Librarian_passwordTF.getPassword());
                Librarian foundLibrarain = library.findLibrarianByUsernameAndPassword(enteredUserid, enteredPass);
                if (foundLibrarain != null) {

                    System.out.println("Librarian login successful");
                    loginStatusLabel.setText("Librarian login successful");

                    librarianHome.setCreate_frame_librarian();
                    librarianHome.create_frame_librarian.setVisible(true);


                } else {
                    System.out.println("Librarian login failed");

                }
            }

        });

        Student_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for student login

                System.out.println("Student login clicked");
                String enteredUsername = Student_nameTF.getText();
                String enteredPassword = new String(Student_passwordTF.getPassword());
                System.out.println("Entered Username: " + enteredUsername);
                System.out.println("Entered Password: " + enteredPassword);

                // Check if the student exists in the library
                Student foundStudent = library.findStudentByUsernameAndPassword(enteredUsername, enteredPassword);
                System.out.println("Found Student: " + foundStudent);
                if (foundStudent != null) {
                    loginStatusLabel.setText("Student login successful");

                    // Pass the foundStudent instance when initializing Student_home
                    studentHomeFrame = new Student_home(library);
                    studentHomeFrame.setStudent(foundStudent);
                    studentHomeFrame.guibuild();
                    studentHomeFrame.create_frame.setVisible(true);

                    // Refresh the main frame
                    frame.revalidate();
                    frame.repaint();

                } else {
                    loginStatusLabel.setText("Student login unsuccessful");


                }

                }


        });
        Student_sign_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentSignUpGUI(library);
            }
        });
        Exit_the_frame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for exit button
                System.out.println("Exit button clicked");

                try {
                    FileOutputStream fileOut = new FileOutputStream("library.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(library);
                    out.close();
                    fileOut.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    System.err.println("Error writing to file during serialization: " + i.getMessage());
                }


                System.exit(0);
            }
        });
    }
}
