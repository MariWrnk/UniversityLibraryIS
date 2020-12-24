import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BookCatalog {
    private static final ArrayList<Book> bookList = new ArrayList<>();
    private static Scanner sc;

    static {
        try {
            sc = new Scanner(new FileReader("./resources/books.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final Scanner console = new Scanner(System.in);

    public static void fill(){
        while (sc.hasNextLine()){
            Book b = new Book(Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(),
                    Integer.parseInt(sc.nextLine()), Double.parseDouble(sc.nextLine()), sc.nextLine());
            bookList.add(b);
        }
    }

    public static ArrayList<Book> bookSearch(){
        ArrayList<Book> result = new ArrayList<>();
        while (true){
            System.out.println("Enter data for the book search");
            String data = console.nextLine();
            String[] words = data.split(" ");
            for(Book book : bookList){
                for(String word : words){
                    if(book.getAsString().toLowerCase().contains(word.toLowerCase())){
                        result.add(book);
                        break;
                    }
                }
            }
            if(result.size() != 0){
                for(Book book : result){
                    System.out.println(book.getAsString());
                }
                break;
            }else{
                System.out.println("No books were found. Try to search again.");
            }
        }
        return result;
    }

    public static Book searchBookByInvNumber(){
        while(true){
            System.out.println("Enter an inventory number for search");
            int invNumber = Integer.parseInt(console.nextLine());
            for(Book book : bookList){
                if(book.getInvNumber() == invNumber){
                    return book;
                }
            }
            System.out.println("Wrong inventory number. Try to search again.");
        }
    }

    public static void addBook(Book book){
        bookList.add(book);
    }

    public static void deleteBook(Book book){
        bookList.remove(book);
    }

    public static void printAll(){
        for(Book book : bookList){
            System.out.println(book.getAsString());
        }
    }

}
