public class Replacement extends WorkWithReader{
    private Book newBook;

    public void replaceBook(){
        book = BookCatalog.searchBookByInvNumber();
        reader = book.getReader();
        newBook = new Book();
        newBook.setData();
        BookCatalog.addBook(newBook);
        reader.returnedBook(book);
        BookCatalog.deleteBook(book);
        successMessage();
    }
}
