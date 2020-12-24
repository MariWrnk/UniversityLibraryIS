public class Payment extends WorkWithReader{
    private double cost;

    public void payForBook(){
        book = BookCatalog.searchBookByInvNumber();
        reader = book.getReader();
        cost = book.getPrice();
        reader.returnedBook(book);
        BookCatalog.deleteBook(book);
        sendDataToFinSystem();
    }

    public static void sendDataToFinSystem(){
        // connection to the University financial system is suppose to be here
        System.out.println("Payment was arranged successfully!");
    }
}
