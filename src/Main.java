import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        BookCatalog.fill();
        ReadersList.fill();
        run();

    }

    public static void run(){
        String options = "1 - new reader register\n2 - book handing out\n3 - book return" +
                "\n4 - add a book to the fund\n5 - delete a book from the fund\n" +
                "6 - print readers\n7 - print books\n0 - quit";
        while(true){
            System.out.println(options);
            int answer = Integer.parseInt(sc.nextLine());
            if(answer == 1){
                ReadersList.newReader();
                continue;
            }
            if(answer == 2){
                WorkWithReader wwr = new WorkWithReader();
                wwr.handOutBook();
                Register.registerNewWorkWithReader(wwr);
                continue;
            }
            if(answer == 3){
                System.out.println("1 - book is in good condition\n2 - book will be replaced\n3 - book will be paid");
                int a = Integer.parseInt(sc.nextLine());
                if(a == 1){
                    WorkWithReader wwr = new WorkWithReader();
                    wwr.returnBook();
                    Register.registerNewWorkWithReader(wwr);
                }else{
                    if(a == 2){
                        Replacement rpl = new Replacement();
                        rpl.replaceBook();
                    }else{
                        Payment pmt = new Payment();
                        pmt.payForBook();
                        Register.registerNewPayment(pmt);
                    }
                }
                continue;
            }
            if(answer == 4){
                BookFundChange bfc = new BookFundChange();
                bfc.addBook();
                Register.registerNewBookFundChange(bfc);
                continue;
            }
            if(answer == 5){
                BookFundChange bfc = new BookFundChange();
                bfc.deleteBook();
                continue;
            }
            if(answer == 6){
                ReadersList.printAll();
                continue;
            }
            if(answer == 7){
                BookCatalog.printAll();
                continue;
            }
            if(answer == 0){
                break;
            }
        }

    }
}
