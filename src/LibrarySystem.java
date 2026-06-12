import java.util.ArrayList;
import java.util.Scanner;

class LibrarySystem {
    private final ArrayList<String> history = new ArrayList<>();
    private final ArrayList<Book> books = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    // Method to validate Integer input
    public int validIntInput(){
        while(true){
            try{
                return Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Invalid Input! Please enter a number : ");
            }
        }
       
    }

    // Method to validate String input
    public String validStringInput(){
        while(true){
            String input = sc.nextLine().trim();
            if(!input.isEmpty()){
                return input;
            }
            System.out.println("Input cannot be empty. Try again : ");
        }
    }

    // Method to find book from books ArrayList
    public Book findBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                return book; 
            }
        }
        return null;
    }

    // Method to add book in books
    public void addBook(){
        int id;
        while(true){
            System.out.println("Please Enter Book ID : ");
            id = validIntInput();
            if(id <= 0){
                System.out.println("ID must be a positive number. Try again!");
                continue;
            }
            if(findBook(id)!=null){
                System.out.println("Book ID already exists!");
                continue;
            }
            break;
        }

        System.out.println("Please Enter Book Name : ");
        String title = validStringInput();

        System.out.println("Please Enter Author Name : ");
        String author = validStringInput();

        Book book = new Book(id, title, author);
        books.add(book);

        System.out.println("Book Added Successfully!");
        history.add("\""+ book.getTitle() + "\" was added to the library.");
    }

    // Method to delete a book from books
    public void deleteBook(){
        System.out.println("Please enter Book ID : ");
        int id = validIntInput();
        Book book = findBook(id);

        
        if(book==null){
            System.out.println("Book not found!");
            return;
        }
        if(book.isIssued()){
            System.out.println("Cannot delete an issued book!");
            return;
        }
        books.remove(book);
        System.out.println("Book Deleted Successfully!");
        history.add("\""+ book.getTitle() + "\"" + " was deleted from library.");
    }

    // Method to issue a book from books
    public void issueBook(){
        System.out.println("Please enter Book ID : ");
        int id = validIntInput();
        Book book = findBook(id);

        if(book==null){
            System.out.println("Book not found!");
            return;
        }

        if(book.isIssued()){
            System.out.println("Book is already issued!");
            return;
        }

        book.setIssued(true);
        System.out.println("Book Issued Successfully!");
        history.add("\""+ book.getTitle() + "\"" + " was issued from Available Books.");
    }

    // Method to display all available books
    public void showAvailableBooks(){
        if(books.isEmpty()){
            System.out.println("Books not found!");
        }else{
            boolean found = false;
            System.out.println("All Available Books : ");
            for(Book book : books){
                if(!book.isIssued()){
                    System.out.println(book);
                    found = true;
                }  
            }
            if(!found){
                System.out.println("No available books found!");
            }
        }
    }

    // Method to show issued books
    public void showIssuedBooks(){
        if(books.isEmpty()){
            System.out.println("Books not found!");
        }else{
            boolean found = false;
            System.out.println("All Issued Books : ");
            for(Book book : books){
                if(book.isIssued()){
                    System.out.println(book);
                    found = true;
                }  
            }
            if(!found){
                System.out.println("No issued books found!");
            }
        }
    }

    // Method to return a book in books
    public void returnBook(){
        System.out.println("Please enter Book ID to Return : ");
        int id = validIntInput();
        Book book = findBook(id);

        if(book == null){
            System.out.println("Book not found!");
            return;
        }

        if(!book.isIssued()){
            System.out.println("Book is already available!");
            return;
        }

        book.setIssued(false);
        System.out.println("Book Returned Successfully!");
        history.add("\"" + book.getTitle() + "\" was returned to the library.");
    }

    // Method to display history of system
    public void showHistory(){
        System.out.println("Library History : ");
        if(history.isEmpty()){
            System.out.println("No actions have been recorded yet.");
        }else{
            for(String record : history){
            System.out.println(record);
            }
        }
    }

}