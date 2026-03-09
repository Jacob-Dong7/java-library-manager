package src;
import java.util.*;

public class Library {
    private ArrayList<Book> inventory;
    ArrayList<Book> userInventory;

    public Library() {
        inventory = new ArrayList<>();
        userInventory = new ArrayList<>();
    }

    public void populate() {
        add(new Book("1984", "George Orwell", 1949));
        add(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        add(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        add(new Book("Pride and Prejudice", "Jane Austen", 1813));
    }

    public void view(Scanner scnr) {
        int userInput;
        System.out.println("==================================================");
        for (int i = 0; i < inventory.size(); ++i) {
            System.out.print("[");
            System.out.print(i + 1); 
            System.out.println("] Name: " + inventory.get(i).getName() + " | Author: " + inventory.get(i).getAuthor() + " | Release Year: " + inventory.get(i).getYear() + " | Status: " + inventory.get(i).printStatus());
        }
        System.out.println("==================================================");
        userInput = scnr.nextInt() - 1;
        

        //validation
        if (validate(userInput, inventory) == false) return;

        System.out.println("user input" + userInput);
        inventory.get(userInput).borrowBook();
        System.out.println("user input" + userInput);
        userInventory.add(inventory.get(userInput));
        System.out.println("user input" + userInput);
        System.out.println("--------------------------------------------------");
        System.out.println(inventory.get(userInput).getName() + " added");
        System.out.println("--------------------------------------------------");

    }


    public void returnBook(Scanner scnr) {
        if (userInventory.size() <= 0) {
            System.out.println("--------------------------------------------------");
            System.out.println("No Books Found");
            System.out.println("--------------------------------------------------");
            return;
        }
        
        int userInput;
        System.out.println("==================================================");
        for (int i = 0; i < userInventory.size(); ++i) {
            System.out.print("[");
            System.out.print(i + 1); 
            System.out.println("] Name: " + userInventory.get(i).getName() + " | Author: " + userInventory.get(i).getAuthor() + " | Release Year: " + userInventory.get(i).getYear());            
        }
        System.out.println("==================================================");
        userInput = scnr.nextInt() - 1;
        if (validateUserIn(userInput, userInventory) == false) return;
        
        userInventory.get(userInput).returnBook();
        System.out.println("--------------------------------------------------");
        System.out.println(userInventory.get(userInput).getName() + " returned");
        System.out.println("--------------------------------------------------");
        userInventory.remove(userInput);
    }

    public void add(Book book) {
        inventory.add(book);
    }

    public Boolean validate(int userInput, ArrayList<Book> list) {
        if (userInput > list.size() - 1 || userInput < 0 || list.get(userInput).getStatus() == false) {
            System.out.println("--------------------------------------------------");
            System.out.println("Unavailable");
            System.out.println("--------------------------------------------------");
            return false;
        }   
        return true;
    }

    public Boolean validateUserIn(int userInput, ArrayList<Book> list) {
        if (userInput > list.size() - 1 || userInput < 0) {
            System.out.println("--------------------------------------------------");
            System.out.println("Unavailable");
            System.out.println("--------------------------------------------------");
            return false;
        }   
        return true;
    }    
}