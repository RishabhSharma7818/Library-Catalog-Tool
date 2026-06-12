class Book{
    private final int id;
    private final String title;
    private final String author;
    private boolean issued;

    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    @Override
    public String toString(){
        return "ID : " + id +
            "\nTitle : " + title + 
            "\nAuthor : " + author +
            "\nStatus : " + (issued ? "Issued" : "Available"); 
    }

    public void setIssued(boolean issued){
        this.issued = issued;
    }

    public boolean isIssued(){
        return issued;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

}