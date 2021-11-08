package Lab;

import java.util.*;
import java.util.stream.Collectors;

import static Lab.Library.clients;

public class Administrator {
    public static Date SetReturnDate(Date d) {

        Date date = new Date();
        Random random = new Random();
        int rand = random.nextInt(20) + 5;
        date.setMonth(d.getMonth());
        date.setDate(d.getDate() + rand);
        return date;
    }

    public static Map<Client, Map<Book, Integer>> GetList() {
        List<Client> list = new ArrayList<>(clients);
        Map<Client, Map<Book, Integer>> clientListMap = new HashMap<>();
        boolean isEmpty = true;
        for (Client c : list) {
            var temp = c.books.stream().filter(x -> x.ReturnDate.before(new Date())).collect(Collectors.toList());
            if (temp.size()!=0) isEmpty=false;
            Map<Book, Integer> deadline = new HashMap<>();
            for (Book b : temp) {
                deadline.put(b, - b.ReturnDate.getDate() + new Date().getDate());
            }
            clientListMap.put(c, deadline);
        }
        if(!isEmpty) System.out.println("List of debtors : \n");
        else System.out.println("Everything is okay . List of debtors is empty:)\n");

        for (Map.Entry<Client, Map<Book, Integer>> entry : clientListMap.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                String str = "[";
                for (Map.Entry<Book, Integer> entry1 : entry.getValue().entrySet()) {
                    str += Book.getInfo(entry1.getKey()) + ": Return of the book is expired for " + entry1.getValue() + " days , ";
                }
                System.out.println(Client.getInfo(entry.getKey()) + " : " + str + "]");
            }
        }
        return clientListMap;
    }

}



