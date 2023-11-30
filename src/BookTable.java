import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookTable {
    JTable book_table;
    JFrame book_frame;
    JPanel panel;
    JLabel Avilable_books ;
    private DefaultTableModel model;
    JButton Exit;

    BookTable()
    {
        book_table =new JTable();
        book_frame=new JFrame("Veiw books ");
        panel=new JPanel();
        model=new DefaultTableModel();
        Avilable_books=new JLabel("Books",SwingConstants.CENTER);
        Exit=new JButton("Exit");
    }
    public void book_table_fun(List<Book>books)
    {
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Isbn");
        book_table.setModel(model);
        book_table.getColumnModel().getColumn(0).setHeaderValue("Title");
        book_table.getColumnModel().getColumn(1).setHeaderValue("Author");
        book_table.getColumnModel().getColumn(2).setHeaderValue("Isbn");

       // Display(books);



    }
    public void Display(List<Book>books)
    {

        for(Book book:books)
        {
            Object[]row={book.getTitle(),book.getAuthor(),book.getIsbn()};
            model.addRow(row);
        }

    }
    public void showtable()
    {
        JScrollPane scrollPane = new JScrollPane(book_table);

        panel.setLayout(new FlowLayout());
        panel.add(Avilable_books);
        panel.add(Exit);
       // panel.add(book_table);

        book_frame.setLayout(new BorderLayout());
        book_frame.add(panel, BorderLayout.NORTH);
        book_frame.add(scrollPane, BorderLayout.CENTER);

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle exit button click
                book_frame.dispose(); // Close the frame
            }
        });
        book_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // book_frame.pack();
        book_frame.setSize(800,800);
        //book_frame.add(book_table);
        book_frame.setVisible(true);

    }
}
