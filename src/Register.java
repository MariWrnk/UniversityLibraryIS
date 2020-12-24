import java.util.ArrayList;

public class Register {
    private static final ArrayList<WorkWithReader> handingOutsAndReturns = new ArrayList<>();
    private static final ArrayList<Replacement> replacements = new ArrayList<>();
    private static final ArrayList<Payment> payments = new ArrayList<>();
    private static final ArrayList<BookFundChange> bookFundChanges = new ArrayList<>();

    public static void registerNewWorkWithReader(WorkWithReader wwr){
        handingOutsAndReturns.add(wwr);
    }

    public static void registerNewReplacement(Replacement rpl){
        replacements.add(rpl);
    }

    public static void registerNewPayment(Payment pmt){
        payments.add(pmt);
    }

    public static void registerNewBookFundChange(BookFundChange bfc){
        bookFundChanges.add(bfc);
    }
}
