import java.util.ArrayList;
import java.util.Date;

public class WorkWithReader {
    protected Reader reader = null;
    protected Date date;
    protected Book book;
    private OperationTypes operationType;

    WorkWithReader(){
        date = new Date();
    }

    public void returnBook(){
        operationType = OperationTypes.BookReturn;
        book = BookCatalog.searchBookByInvNumber();
        book.setInStock();
        reader = book.getReader();
        reader.returnedBook(book);
        book.deleteReader();
        successMessage();
    }

    public void handOutBook(){
        operationType = OperationTypes.HandingOutBooks;
        reader = ReadersList.searchReader();
        ArrayList<Book> found = BookCatalog.bookSearch();
        book = BookCatalog.searchBookByInvNumber();
        if(book.isAvailable()){
            book.setTaken();
            book.setReader(reader);
            reader.gotBook(book);
            successMessage();
        }
        else {
            notInStockMessage();
        }
    }

    public void successMessage(){
        System.out.println("Operation is completed successfully!");
    }

    public void notInStockMessage(){
        System.out.println("This book is not available at the moment!");
    }

}
