import java.io.*;
import java.util.Scanner;

public class Collection {
    private int count = 0;
    private Book[] books = null;
    public void add(Book newObj) {
        Book[] temp = new Book[count + 1];
        for (int i = 0; i < count; i++) {
            temp[i] = books[i];
        }
        books = temp;
        books[count] = newObj;
        count++;
    }

    public void remove(int i) {
        if (i >= count) {
            System.out.println("Such index does not exist");
            return;
        }
        Book[] temp = new Book[count - 1];
        for (int j = 0; j < i; j++) {
            temp[j] = books[j];
        }
        for (int j = i + 1; j < count; j++) {
            temp[j - 1] = books[j];
        }
        books = temp;
        count--;
    }

    public void clear() {
        books = null;
        count = 0;
    }

    public void printOne(int i) {
        System.out.println(books[i].getDescription());
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            printOne(i);
            System.out.println();
        }
    }

    public void printList() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + ". " + books[i].getTitle());
        }
    }

    public void search(String s) {
        for (int i = 0; i < count; i++) {
            if (s.equals(books[i].author)) {
                System.out.print(i + ". ");
                printOne(i);
            }
        }
    }

    public void sort() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j += 2) {
                if (j + 1 < count && books[j].getNumPages() > books[j + 1].getNumPages()) {
                    swap(books, j, j + 1);
                }
                else if (j - 1 > 0 && books[j].getNumPages() < books[j - 1].getNumPages()) {
                    swap(books, j, j - 1);
                }
            }
        }
    }

    private void swap(Book[] array, int i, int j) {
        Book temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void searchByNumPages(int numPages) {
        for (int i = 0; i < count; i++) {
            if (books[i].getNumPages() == numPages)
                printOne(i);
        }
    }

    public void saveToFile() throws IOException {
        if (books != null) {
            FileWriter writer = new FileWriter("SaveData.txt");
            for (Book book : books) {
                writer.write(book.name + "#" + book.author + "#" + book.getNumPages() + "\n");
            }
            writer.close();
        }
    }

    public void readFromFile() throws IOException {
        FileInputStream file = new FileInputStream("SaveData.txt");
        Scanner in = new Scanner(file);
        clear();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] strarr = line.split("#");
            add(new Book(strarr[0], strarr[1], Integer.parseInt(strarr[2])));
        }
        file.close();
    }
}