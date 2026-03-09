package src;

public class Book {
    private String name, author;
    private int yearOfProduction;
    private boolean status;

    public Book(String name, String author, int yearOfProduction) {
        this.name = name;
        this.author = author;
        this.yearOfProduction = yearOfProduction;
        this.status = true;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.yearOfProduction;
    }

    public String getAuthor() {
        return this.author;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public String printStatus() {
        if (this.status == false) {
            return "Unavailable";
        } else {
            return "Available";
        }
    }
    public void borrowBook() {
        this.status = false;
    }

    public void returnBook() {
        this.status = true;
    }
}
