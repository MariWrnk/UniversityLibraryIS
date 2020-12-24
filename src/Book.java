import java.util.Scanner;

public class Book {
    private int invNumber;
    private String name;
    private String author;
    private int yearOfIssue;
    private String bookDescription;
    private double price;
    private String asString;
    private StatusTypes status;
    private Reader reader;
    Scanner sc = new Scanner(System.in);

    Book(){
        this.status = StatusTypes.InStock;
        this.reader = null;
    }

    Book(Book copy, int invNumber){
        this.status = StatusTypes.InStock;
        this.reader = null;
        this.name = copy.name;
        this.author = copy.author;
        this.yearOfIssue = copy.yearOfIssue;
        this.bookDescription = copy.bookDescription;
        this.price = copy.price;
        this.invNumber = invNumber;
        turnToString();
    }

    public void setInStock(){
        this.status = StatusTypes.InStock;
        turnToString();
    }

    public void setTaken(){
        this.status = StatusTypes.Taken;
        turnToString();
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Reader getReader() { return reader;}

    public void deleteReader() {
        this.reader = null;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable(){
        if(this.status == StatusTypes.InStock){
            return true;
        }
        return false;
    }

    public int getInvNumber() {
        return invNumber;
    }

    public void setData(){
        System.out.println("Enter an inventory number");
        this.invNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Enter a book name");
        this.name = sc.nextLine();
        System.out.println("Enter an author name");
        this.author = sc.nextLine();
        System.out.println("Enter a year of issue");
        this.yearOfIssue = Integer.parseInt(sc.nextLine());
        System.out.println("Enter a price");
        this.price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter a book description");
        this.bookDescription = sc.nextLine();;
        turnToString();

    }

    public void turnToString(){
        this.asString = String.valueOf(invNumber) + " | " + name + " | " + author + " | " + String.valueOf(yearOfIssue) +
                " | " + bookDescription + " | " + String.valueOf(status);

    }

    public String getAsString(){
        return asString;
    }

    Book(int invNumber, String name, String author, int yearOfIssue, double price, String bookDescription){
        this.status = StatusTypes.InStock;
        this.reader = null;
        this.name = name;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
        this.bookDescription = bookDescription;
        this.price = price;
        this.invNumber = invNumber;
        turnToString();
    }

}

