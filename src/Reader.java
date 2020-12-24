import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private String name;
    private int readerCardID;
    int documentID;
    ArrayList<Book> hasBooks = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    Reader(int documentID){
        this.documentID = documentID;
        getPersonalInfo();
    }

    Reader(String name, int readerCardID, int documentID){
        this.name = name;
        this.readerCardID = readerCardID;
        this.documentID = documentID;
    }

    public void getPersonalInfo(){
        System.out.println("Enter reader's name");
        name = sc.nextLine();
    }

    public void setReaderCardID(int readerCardID){
        this.readerCardID = readerCardID;
    }

    public int getReaderCardID(){
        return readerCardID;
    }

    public String getName(){
        return name;
    }

    public void gotBook(Book book){
        hasBooks.add(book);
    }

    public void returnedBook(Book book){
        hasBooks.remove(book);
    }
}
