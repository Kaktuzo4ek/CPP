package Lab;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        Library libr = new Library();
        List<Book> library = libr.getLibrary();
        List<Client> clientList= Library.getClients();
        Client a = new Client("Oleg", "Tarasovich", "taroleg@gmail.com");
        System.out.println("\nSorted by date books in library:\n");
        List<Book> q = libr.SortByDate();
        System.out.println("\nNumber of books in the library: " + libr.getLibrary().size());

        a.TakeBook(library.get(0));
        a.TakeBook(library.get(0));
        a.TakeBook(library.get(0));
        clientList.get(2).TakeBook(library.get(0));
        clientList.get(2).ReturnBook(clientList.get(2).books.get(0));
        a.ReturnBook(a.books.get(0));

        System.out.println();

        System.out.println("Email list of people who took 2 or more books:" + Library.SubscrubtionList() + "\n");

        Library.Authors("Bram Stoker");

        Library.MaxBook();

        new Administrator().GetList();

        System.out.println("\nNotification for users:\n");
        Library.StartNotification();

    }
}
