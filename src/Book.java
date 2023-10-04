public class Book {
    public String name;
    public String author;
    private int numPages;

    public Book(String name, String author, int numPages) {
        this.name = name;
        this.author = author;
        this.numPages = numPages;
    }

    public String getDescription() {
        return "Name: " + name + "\nAuthor: " + author + "\nPages: " + getNumPages();
    }

    public String getTitle() {
        return name + " author: " + author;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
}