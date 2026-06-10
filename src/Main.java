import java.util.Scanner;
public class Main extends LibrarySystem{
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner sc = new Scanner(System.in);
        while(true){ 
            System.out.println("==============Library Catalog Tool==============");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Show Available Books");
            System.out.println("6. Show Issued Books");
            System.out.println("7. Return Book");
            System.out.println("8. Show History");
            System.out.println("9. Exit");

            System.out.println("Please enter your choice : ");
            int choice;
            try{
                choice = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input! Please enter numbers only : ");
                continue;
            }

            switch(choice){
                case 1 -> library.addBook();
                case 2 -> library.deleteBook();
                case 3 -> library.updateBook();
                case 4 -> library.issueBook();
                case 5 -> library.showAvailableBooks();
                case 6 -> library.showIssuedBooks();
                case 7 -> library.returnBook();
                case 8 -> library.showHistory();
                case 9 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid Input!");
            }
        }
    }
}