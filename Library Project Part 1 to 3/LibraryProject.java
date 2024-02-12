import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.*;


class Main{
    public static void main(String[] args) {
    
        Library library = new Library();

        library.storeItem(new LibraryItem("The Soul of a New Machine:", "KM44", 6997, 120, true));
        library.storeItem(new LibraryItem("Structure and Interpretation of Computer Programs", "QWE31", 2100, 6977, false));

        //  printAllItems for Part 1 
        library.printAllItems();

        // Print and Test for Part 2 and 3
        library.readItemData();
        library.printAllItems();
    }

}

 class Library {

    private ArrayList<LibraryItem> itemList;
    

    // Constructor
    public Library() {
        itemList = new ArrayList<>();
    }

    // Method to add a library item
    public void storeItem(LibraryItem libraryItem) {
        itemList.add(libraryItem);
    }

     // Method to print details of all items
     public void printAllItems() {

        for (int i = 0; i < itemList.size(); i++) {
            LibraryItem libraryItem = itemList.get(i);
            libraryItem.printDetails();
            System.out.println("---------------------");
        }
        // for (LibraryItem item : itemList) {
        //     item.printDetails();
 
        // }
    }

    public void readItemData() {

        final Frame frame=null;
        final FileDialog fileDialog = new FileDialog(frame, "Please Choose Valid File");
        fileDialog.setMode(FileDialog.LOAD);
        fileDialog.setVisible(true);
         String fileTitle = fileDialog.getFile();
         System.out.println("File:"+fileTitle);
 
     
         if (fileTitle == null)
             return;
         try {
             File file = new File(fileDialog.getDirectory() + fileTitle);
             Scanner scanner1 = new Scanner(file);
             while (scanner1.hasNextLine()) {
                 String line = scanner1.nextLine().trim();
                 if (!line.startsWith("//") && !line.isEmpty()) {
                     System.out.println("Data Line:"+line);
                     Scanner scanner2 = new Scanner(line);
                     LibraryItem libraryItem= new LibraryItem();
                     LibraryItem newBook = libraryItem.readItemData(scanner2);
                     storeItem(newBook);
                     scanner2.close();
                 }
             }
             scanner1.close();
         } catch (FileNotFoundException e) {
             System.err.println("File not found try again: " + e.getMessage());
         }
     }
}


 class LibraryItem {
    private int cost;
    private boolean onLoan;
    private String title;
    private String itemCode;
    private int timesBorrowed;
    

// Default Constructor
public LibraryItem(){

}
    public LibraryItem(String name, String bookCode, int price, int NoOfTimestimesBorrowed, boolean onLoan) {
        this.title = name;
        this.itemCode = bookCode;
        this.cost = price;
        this.timesBorrowed = NoOfTimestimesBorrowed;
        this.onLoan = onLoan;
    }


    public LibraryItem readItemData(Scanner s){
        s.useDelimiter(",\\s*");
                     String name = s.next();
                     String code = s.next();
                     int price = s.nextInt();
                     int timesBorrowed = s.nextInt();
                     boolean onLoan = s.nextBoolean();
                     return new LibraryItem(name, code, price, timesBorrowed, onLoan);
                   
    }


    // getter methods or Accessors
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

    // Method for details
    // public void printDetails() {
    //     System.out.println(title + " with item code " + itemCode + " has been borrowed " +
    //             timesBorrowed + " times.");
    //     System.out.println("This item is " + (onLoan ? "currently on loan" : "not on loan") +
    //             " and when new costs " + cost + " pence.");
    // }

    public void printDetails() {
        System.out.printf("%s with item code %s has been borrowed %d times.%n",
                          title, itemCode, timesBorrowed);
        System.out.printf("This item is %s and when new costs %d pence.%n",
                          (onLoan ? "currently on loan" : "not on loan"), cost);
    }
}
