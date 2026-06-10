import java.util.ArrayList;
import java.util.Scanner;

class LibrarySystem {
    private ArrayList<String> history = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Book> issueBooks = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

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

    public String validStringInput(){
        while(true){
            String input = sc.nextLine().trim();
            if(!input.isEmpty()){
                return input;
            }
            System.out.println("Input cannot be empty. Try again : ");
        }
    }

    public Book findBook(int id){
        for(Book book : books){
            if(book.getId() == id){
                return book; 
            }
        }
        return null;
    }

    public Book findBookInIssuedBook(int id){
        for(Book book : issueBooks){
            if(book.getId() == id){
                return book; 
            }
        }
        return null;
    }

    public void addBook(){
        System.out.println("Please Enter Book ID : ");
        int id = validIntInput();

        if(findBook(id)!=null){
            System.out.println("Account already exists!");
            return;
        }

        System.out.println("Please Enter Book Name : ");
        String title = validStringInput();

        System.out.println("Please Enter Author Name : ");
        String author = validStringInput();

        Book book = new Book(id, title, author);
        books.add(book);

        System.out.println("Book Added Successfully!");
        history.add("\""+ book.getTitle() + "\"" + " Added in Library!");
    }

    public void deleteBook(){
        System.out.println("Please enter Book ID : ");
        int id = validIntInput();
        Book book = findBook(id);

        if(book==null){
            System.out.println("Book not found!");
        }else{
            books.remove(book);
            System.out.println("Book Deleted Successfully!");
            history.add("\""+ book.getTitle() + "\"" + " Deleted from Library!");
        }
    }

    public void issueBook(){
        System.out.println("Please enter Book ID : ");
        int id = validIntInput();
        Book book = findBook(id);

        if(book==null){
            System.out.println("Book not found!");
        }else{
            books.remove(book);
            issueBooks.add(book);
            System.out.println("Book Issued Successfully!");
            history.add("\""+ book.getTitle() + "\"" + " Issued from Available Books!");
        }
    }

    public void showAvailableBooks(){
        if(books.isEmpty()){
            System.out.println("Books not found!");
        }else{
            System.out.println("All Available Books : ");
            for(Book book : books){
                System.out.println(book);
            }
        }
    }

    public void showIssuedBooks(){
        if(issueBooks.isEmpty()){
            System.out.println("Books not found!");
        }else{
            System.out.println("All Issued Books : ");
            for(Book book : issueBooks){
                System.out.println(book);
            }
        }
    }

    public void updateBook(){
        System.out.println("Please enter Book ID : ");
        int id = validIntInput();
        Book book = findBook(id);

        if(book == null){
            System.out.println("Book not found!");
        }else{
            System.out.println("Please enter new Title : ");
            String title = validStringInput();

            System.out.println("Please update Author Name : ");
            String author = validStringInput();

            String oldTitle = book.getTitle();
            book.setTitle(title);
            String oldAuthor = book.getAuthor();
            book.setAuthor(author);
            System.out.println("Book details Updated!");
            history.add("\""+ oldTitle + "&" + oldAuthor + "\" updated to \"" + title + "&" + author);
        }
    }

    public void returnBook(){
        System.out.println("Please enter Book ID to Return : ");
        int id = validIntInput();
        Book book = findBookInIssuedBook(id);

        if(book == null){
            System.out.println("Book not found!");
        }else{
            issueBooks.remove(book);
            books.add(book);
            System.out.println("Books Returned Successfully!");
            history.add("\"" + book.getTitle() + "\"" + " Returned to Library!");
        }
    }

    public void showHistory(){
        System.out.println("Library History : ");
        if(history.isEmpty()){
            System.out.println("No actions have been recorded yet.");
        }else{
            for(String history : history){
            System.out.println(history);
            }
        }
    }

}