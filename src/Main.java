
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class Main {
    public static void main(String[] args) {

        Library library;


        String file_path = "library.ser";
        Path path = Paths.get(file_path);
        if(Files.exists(path))
        {
            try {
                // Create an ObjectInputStream to read the serialized object from a file
                FileInputStream fileIn = new FileInputStream(file_path);
                ObjectInputStream in = new ObjectInputStream(fileIn);

                // Deserialize the object
                library = (Library) in.readObject();

                // Close the input streams
                in.close();
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } catch (ClassNotFoundException c) {
                System.out.println("SaveData class not found");
                c.printStackTrace();
                return;
            }
        }
        else {
            // Code to execute if the file "library.ser" does not exist
            library = new Library();
            library.addabook(new Book("Book1", "Author1", 123456));
            library.addabook(new Book("Book2", "Author2", 789012));
            Student newStudent = new Student("S", "h", 2, "j", "s");
            Librarian lib = new Librarian("S", "h", 2, "j", "s");
            library.addStudent(newStudent);
            library.addLibrarian(lib);
        }

        SwingUtilities.invokeLater(() -> new Login(library));

      
    }
}