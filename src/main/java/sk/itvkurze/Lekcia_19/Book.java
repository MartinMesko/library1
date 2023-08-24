package sk.itvkurze.Lekcia_19;

public class Book {
    private String authorName;
    private String title;
    private int pageCount;
    private String isbn;
    private int availableCopies;



    public Book(String title, String authorName, String isbn,int pageCount, int availableCopies) {
        this.authorName = authorName;
        this.title = title;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.availableCopies = availableCopies;

    }


    public String getAuthorName() {
        return authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getIsbn() {
        return isbn;
    }


    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }


}
