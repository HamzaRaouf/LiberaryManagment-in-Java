import java.util.Scanner;

public class LibraryItem {
    private String title;
    private String itemCode;
    private int cost;
    private int timesBorrowed;
    private boolean onLoan;

// Default Constructor
public LibraryItem(){

}
    // Parameterized Constructor
    public LibraryItem(String title, String itemCode, int cost, int timesBorrowed, boolean onLoan) {
        this.title = title;
        this.itemCode = itemCode;
        this.cost = cost;
        this.timesBorrowed = timesBorrowed;
        this.onLoan = onLoan;
    }


    public LibraryItem readItemData(Scanner scanner){
        scanner.useDelimiter(",\\s*");
                     String title = scanner.next();
                     String itemCode = scanner.next();
                     int cost = scanner.nextInt();
                     int timesBorrowed = scanner.nextInt();
                     boolean onLoan = scanner.nextBoolean();
                     LibraryItem item = new LibraryItem(title, itemCode, cost, timesBorrowed, onLoan);
                     return item;
                    //  storeItem(item);
                    //  scanner2.close();
    }


    // Accessor methods
    public String getTitle() {
        return title;
    }

    public String getItemCode() {
        return itemCode;
    }

    public int getCost() {
        return cost;
    }

    public int getTimesBorrowed() {
        return timesBorrowed;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    // Method to print details
    public void printDetails() {
        System.out.println(title + " with item code " + itemCode + " has been borrowed " +
                timesBorrowed + " times.");
        System.out.println("This item is " + (onLoan ? "currently on loan" : "not on loan") +
                " and when new costs " + cost + " pence.");
    }
}
