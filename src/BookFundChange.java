import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookFundChange {
    Date date;
    ArrayList<Book> bookList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    BookFundChange(){
        date = new Date();
    }

    public void addBook(){
        Book book = new Book();
        book.setData();
        BookCatalog.addBook(book);
        bookList.add(book);
        successMessage();
        addAnotherCopy();
    }

    public void addAnotherCopy(){
        while(true){
            System.out.println("Would you like to add another copy of this book?\n1 - yes\n2 - no");
            int answer = Integer.parseInt(sc.nextLine());
            if(answer == 2){
                break;
            }
            else{
                System.out.println("Enter an inventory number");
                int invNumber = Integer.parseInt(sc.nextLine());
                Book book = new Book(bookList.get(bookList.size()-1), invNumber);
                BookCatalog.addBook(book);
                successMessage();
            }
        }
    }

    public void deleteBook(){
        bookList = BookCatalog.bookSearch();
        System.out.println("Would you like to delete all found books?\n1 - all\n2 - one");
        int answer = Integer.parseInt(sc.nextLine());
        if (answer == 1){
            deleteAll();
        }
        else{
            deleteOne();
        }
    }

    public void deleteAll(){
        for(Book book : bookList){
            BookCatalog.deleteBook(book);
        }
        successMessage();
    }

    public void deleteOne(){
        Book book = BookCatalog.searchBookByInvNumber();
        BookCatalog.deleteBook(book);
        successMessage();
    }

    public void successMessage(){
        System.out.println("Book fund was changed successfully!");
    }
}
