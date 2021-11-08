package Lab;

import java.util.Date;

public class Book {
    public String Name;
    public Integer Year;
    public String Author;
    public Date date;
    public Date ReturnDate;

    protected static int count;
    public Book(String name,Integer year, String author){
        Name = name;
        setYear(year);
        Author = author;
        setDate(null);
        setReturnDate(null);
        count++;
    }
    public static String getInfo(Book book){
        return "Book name : "+ book.Name +" Posted at : "+ book.getYear() +" by "+book.Author;
    }
    public static int getCount(){
        return count;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date d) {
        if(d==null) this.ReturnDate= null;
        else this.ReturnDate= Administrator.SetReturnDate(d);
    }
}
