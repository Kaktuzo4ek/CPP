package Lab;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

public class Library {
    public static List<Book> library = new ArrayList<>();
    public static List<Client> clients = new ArrayList<>();

    public Library() throws IOException {
        List<String> BookName = FileHelper.getBookName();
        List<Integer> BookDate = FileHelper.getDate();
        List<String> BookAuthor = FileHelper.getAuthor();
        for (int i = 0; i < BookName.size(); i++) {
            library.add(new Book(BookName.get(i), BookDate.get(i), BookAuthor.get(i)));
        }
        List<String> Names = FileHelper.getName();
        List<String> Surnames = FileHelper.getSurname();
        List<String> Emails = FileHelper.getEmail();
        for (int i = 0; i < Names.size(); i++) {
            clients.add(new Client(Names.get(i),Surnames.get(i),Emails.get(i)));
        }
    }

    public static List<Client> getClients() {
        return clients;
    }

    public List<Book> getLibrary() {
        return library;
    }

    //task1
    public List<Book> SortByDate() {
        List<Book> sorting = new ArrayList<>(library);
        sorting = sorting.stream().sorted(comparing(Book::getYear)).toList();
        for (Book b : sorting) {
            System.out.println(Book.getInfo(b));
        }
        return sorting;
    }

    //    task2
    public static List<String> SubscrubtionList() {
        List<Client> list = new ArrayList<>(clients);
        List<String> emails = new ArrayList<>();
        var subscriptions = list.stream().filter(x -> x.books.size() > 1).toList();
        for (Client c : subscriptions) {
            emails.add(c.Email);
        }
        return emails;
    }

    //    task3
    public static int Authors(String author) {
        List<Client> list = new ArrayList<>(getClients());
        List<Book> bookList = new ArrayList<>();
        for (Client c : list) {
            bookList.addAll(c.books);
        }
        var p = bookList.stream().filter(x -> x.Author.equals(author)).collect(Collectors.toList()).size();
        System.out.println("Amount of books authored by " + author + " is:" + p+"\n");
        return p;
    }
//task 4
    public static int MaxBook() {
        List<Client> list = new ArrayList<>(getClients());
        var p = list.stream().sorted((x,y)->x.books.size() < y.books.size()?1:-1).collect(Collectors.toList());
        System.out.println("Max amount of books that were taken is " + p.get(0).books.size() + ". Taken by " + Client.getInfo(p.get(0))+"\n");
        return p.get(0).books.size();
    }
//task 6
    public static List<List<Client>> GetNotoficationList() {
        List<List<Client>> Clients = new ArrayList<>();
        Clients.add(getClients().stream().filter(x -> x.books.size() < 2).collect(Collectors.toList()));
        Clients.add(getClients().stream().filter(x -> x.books.size() > 1).collect(Collectors.toList()));
        return Clients;
    }
    public static void StartNotification(){
        List<Client> users1 = new ArrayList<>(Library.GetNotoficationList().get(0));
        List<Client> users2 = new ArrayList<>(Library.GetNotoficationList().get(1));
        for (Client c : users1) {
            System.out.println("Hi "+ c.Name + "! We have a great news for you !\n" +
                    "Visit our library and be one of the first to recieve the book \"Murphy\" written by Samuel Beckett\n");}
        for (Client c : users2) {
            System.out.println("Dear "+ c.Name + "! We have to remind you of the need to return the books until "+ Client.returnDate(c.books) +
                    "\nThank you for understanding\n");}
    }
}
