package src;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    //Declaring items
    Scanner scnr = new Scanner(System.in);
    int userInput;
    

    //Initialize the library class
    Library library = new Library();
    library.populate();   
    
    //interface
    System.out.println("==================================================");
    System.out.println("Library Manager");
    System.out.println("==================================================");
    while (true) {
        System.out.println("--------------------------------------------------");
        System.out.println("[1] Borrow Books");
        System.out.println("[2] Return Books");
        System.out.println("--------------------------------------------------");
        userInput = scnr.nextInt();

        if (userInput == 1) {
            library.view(scnr);
        } else if (userInput == 2) {
            library.returnBook(scnr);
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Select From Available Options");
            System.out.println("--------------------------------------------------");
        }
    }
    }


}