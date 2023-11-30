// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.Serializable;
import java.util.Scanner;
public class Book implements Serializable {
String title;
String author;
int isbn;
public Book(String title, String author, int isbn)
{
    this.title=title;
    this.author=author;
    this.isbn=isbn;
}
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int  getIsbn() {
        return isbn;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book otherBook = (Book) obj;
        return isbn == otherBook.isbn &&
                title.equals(otherBook.title) &&
                author.equals(otherBook.author);
    }

}








