class Main{
    public static void main(String[] args) {
        LibraryItem item1 = new LibraryItem("Encyclopaedia Britannica", "RD6582", 3500, 250, true);
        LibraryItem item2 = new LibraryItem("Objects First with Java", "LM002411", 3989, 781, true);
        LibraryItem item3 = new LibraryItem("Data Structures and Algorithm", "CS00001", 5000, 50, false);

        Library library = new Library();
        library.storeItem(item1);
        library.storeItem(item2);
        library.storeItem(item3);


        // Test printAllItems
        library.printAllItems();

        // Test readItemData
        library.readItemData();
        library.printAllItems();
    }
}