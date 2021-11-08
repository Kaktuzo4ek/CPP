package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Client {
    String Name;
    String Surname;
    String Email;
    public List<Book> books;

    public Client(String name, String surname, String email) {
        Name = name;
        Surname = surname;
        Email = email;
        books = new ArrayList<>();
    }

    void TakeBook(Book book) {
        System.out.println(Book.getInfo(book) + " was taken by " + Client.getInfo(this));
        Date date = new Date();
        Random random = new Random();
        int rand = random.nextInt(20) + 0;
        date.setDate(date.getDate() - rand);
        book.setDate(date);
        book.setReturnDate(date);
        System.out.println("The book was taken at "+ book.date + ".The book should be returned until "+book.ReturnDate+"\n");
        books.add(book);
        Library.library.remove(book);
        if (!Library.getClients().contains(this)) {
            Library.getClients().add(this);
        }
    }

    void ReturnBook(Book book) {
        System.out.println(Book.getInfo(book) + " was returned by " + Client.getInfo(this)+"\n");
        book.setDate(null);
        book.setReturnDate(null);
        books.remove(book);
        Library.library.add(book);
    }
    static String getInfo(Client c) {
        return c.Name + " " + c.Surname + " ";
    }
    public static Date returnDate(List<Book>book){
        var temp = book.stream().sorted(Comparator.comparing(Book::getReturnDate,Comparator.reverseOrder())).collect(Collectors.toList());
        return temp.get(0).ReturnDate;
    }
}
