import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadersList {
    private static final ArrayList<Reader> readers = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    private static Scanner filesc;

    static {
        try {
            filesc = new Scanner(new FileReader("./resources/readers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void fill(){
        while(filesc.hasNextLine()){
            Reader rdr = new Reader(filesc.nextLine(), Integer.parseInt(filesc.nextLine()), Integer.parseInt(filesc.nextLine()));
            readers.add(rdr);
        }
    }

    public static Reader searchReader(){
        while(true){
            System.out.println("Enter reader card ID");
            int readerCardID = Integer.parseInt(sc.nextLine());
            for(Reader rdr : readers){
                if(rdr.getReaderCardID() == readerCardID){
                    return rdr;
                }
            }
            System.out.println("Wrong Reader Card ID. Try again.");
        }
    }

    public static void newReader(){
        while(true){
            System.out.println("Enter reader's Student card / Employee's pass card ID");
            int documentID = Integer.parseInt(sc.nextLine());
            if(exists(documentID)){
                Reader rdr = new Reader(documentID);
                System.out.println("Enter new Reader Card ID");
                int newCardID = Integer.parseInt(sc.nextLine());
                rdr.setReaderCardID(newCardID);
                readers.add(rdr);
                successMessage();
                break;
            }else{
                wrongDocumentMessage();
                int answer = Integer.parseInt(sc.nextLine());
                if(answer == 2){
                    break;
                }
            }
        }

    }

    public static  boolean exists(int documentID){
        return true;
    }

    public static void wrongDocumentMessage(){
        System.out.println("Wrong document ID! Would you like to try again?\n1 - try again\n2 - finish");
    }

    public static void successMessage(){
        System.out.println("New reader was successfully added!");
    }

    public static void printAll(){
        for(Reader reader : readers){
            System.out.println(reader.getName() + "   " + reader.getReaderCardID());
        }
    }
}
