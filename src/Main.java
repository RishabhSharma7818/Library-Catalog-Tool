public class Main {
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        while(true){ 
            System.out.println("==============Library Catalog Tool==============");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Show Available Books");
            System.out.println("5. Show Issued Books"); 
            System.out.println("6. Return Book");
            System.out.println("7. Show History");
            System.out.println("8. Exit");

            System.out.println("Please enter your choice : ");
            int choice = library.validIntInput();
            
            switch(choice){
                case 1 -> library.addBook();
                case 2 -> library.deleteBook();
                case 3 -> library.issueBook();
                case 4 -> library.showAvailableBooks();
                case 5 -> library.showIssuedBooks();
                case 6 -> library.returnBook();
                case 7 -> library.showHistory();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid Input!");
            }
        }
    }
}  