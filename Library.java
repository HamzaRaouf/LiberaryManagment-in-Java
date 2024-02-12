import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;


public class Library {
    
    private ArrayList<LibraryItem> itemList;
    private Frame mainFrame;

    // Constructor
    public Library() {
        itemList = new ArrayList<>();
    }

    // Method to add a library item
    public void storeItem(LibraryItem item) {
        itemList.add(item);
    }

     // Method to print details of all items
     public void printAllItems() {
        for (LibraryItem item : itemList) {
            item.printDetails();

            System.out.println();// just for improving readability
        }
    }


    // Method to read item data from a file 2nd Step
    // public void readItemData() {

    //    final FileDialog fd = new FileDialog(mainFrame, "Select File to Open");
    //     fd.setMode(FileDialog.LOAD);
    //     fd.setVisible(true);
    //     String filename = fd.getFile();
    //     System.out.println("Uploaded File Name:"+filename);
    //     System.out.println();

    
    //     if (filename == null)
    //         return;
    //     try {
    //         File file = new File(fd.getDirectory() + filename);
    //         Scanner scanner = new Scanner(file);
    //         while (scanner.hasNextLine()) {
    //             String lineOfText = scanner.nextLine().trim();
    //             // System.out.println("Current Reading Line :"+lineOfText);
    //             if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
    //                 System.out.println("Real Data Line :"+lineOfText);
    //                 Scanner scanner2 = new Scanner(lineOfText);
    //                 // String[] data = lineOfText.split(",");
    //                 // String title = data[0].trim();
    //                 // String itemCode = data[1].trim();
    //                 // int cost = Integer.parseInt(data[2].trim());
    //                 // int timesBorrowed = Integer.parseInt(data[3].trim());
    //                 // boolean onLoan = Boolean.parseBoolean(data[4].trim());
    //                 // LibraryItem item = new LibraryItem(title, itemCode, cost, timesBorrowed, onLoan);
    //                 // storeItem(item);

    //                 scanner2.useDelimiter(",\\s*");
    //                 String title = scanner2.next();
    //                 String itemCode = scanner2.next();
    //                 int cost = scanner2.nextInt();
    //                 int timesBorrowed = scanner2.nextInt();
    //                 boolean onLoan = scanner2.nextBoolean();
    //                 // storeItem(item);
    //                 LibraryItem item = new LibraryItem(title, itemCode, cost, timesBorrowed, onLoan);
    //                 storeItem(item);
    //                 scanner2.close();
    //             }
    //         }
    //         scanner.close();
    //     } catch (FileNotFoundException e) {
    //         System.err.println("File not found: " + e.getMessage());
    //     }
    // }




    // Read Method 3rd Step
    public void readItemData() {

        final FileDialog fd = new FileDialog(mainFrame, "Select File to Open");
         fd.setMode(FileDialog.LOAD);
         fd.setVisible(true);
         String filename = fd.getFile();
         System.out.println("Uploaded File Name:"+filename);
         System.out.println();
 
     
         if (filename == null)
             return;
         try {
             File file = new File(fd.getDirectory() + filename);
             Scanner scanner = new Scanner(file);
             while (scanner.hasNextLine()) {
                 String lineOfText = scanner.nextLine().trim();
                 // System.out.println("Current Reading Line :"+lineOfText);
                 if (!lineOfText.startsWith("//") && !lineOfText.isEmpty()) {
                     System.out.println("Real Data Line :"+lineOfText);
                     Scanner scanner2 = new Scanner(lineOfText);

                     LibraryItem libraryItem= new LibraryItem();
                     storeItem(libraryItem.readItemData(scanner2));
                    
                    //  scanner2.useDelimiter(",\\s*");
                    //  String title = scanner2.next();
                    //  String itemCode = scanner2.next();
                    //  int cost = scanner2.nextInt();
                    //  int timesBorrowed = scanner2.nextInt();
                    //  boolean onLoan = scanner2.nextBoolean();
                    //  // storeItem(item);
                    //  LibraryItem item = new LibraryItem(title, itemCode, cost, timesBorrowed, onLoan);
                    //  storeItem(item);
                     scanner2.close();
                 }
             }
             scanner.close();
         } catch (FileNotFoundException e) {
             System.err.println("File not found: " + e.getMessage());
         }
     }
}
