import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Collection collection = new Collection();
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the book database!\n" +
                "Choose an option to proceed:\n" +
                "1 - print book list\n" +
                "2 - add new book\n" +
                //"2 - add multiple books to collection\n" +
                "3 - remove book\n" +
                "4 - sort books by year\n" +
                "5 - search books by author\n" +
                "6 - search books by number of pages\n" +
                "7 - print detailed book list\n" +
                "8 - read books from the file\n" +
                "9 - save books to the file \n" +
                "0 - exit the program");

        do {
            String answer = in.nextLine();
            switch (answer) {
                case "1" -> collection.printList();
                case "2" -> collection.add(new Book(inputBookName(), inputBookAuthor(), inputBookPages()));
                //case "2" -> inputItems();
                case "3" -> removeItems();
                case "4" -> sort();
                case "5" -> search(true);
                case "6" -> search(false);
                case "7" -> collection.printAll();
                case "8" -> collection.readFromFile();
                case "9" -> collection.saveToFile();
                case "0" -> {
                    return;
                }
            }
        } while (true);
    }
    public static void removeItems() {
        System.out.println("Input index to remove");
        collection.remove(Integer.parseInt(in.nextLine()));
    }
    public static void search(boolean name) {
        if (name)
            collection.search(inputBookAuthor());
        else
            collection.searchByNumPages(inputBookPages());
    }
    public static void sort() {
        collection.sort();
        System.out.println("Sorted by number of pages");
    }

    public static String inputBookName() {
        System.out.println("Input book name");
        return in.nextLine();
    }

    public static String inputBookAuthor() {
        System.out.println("Input author");
        return in.nextLine();
    }

    public static int inputBookPages() {
        System.out.println("Input number of pages");
        return Integer.parseInt(in.nextLine());
    }
}