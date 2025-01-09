import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

public class LibraryCatalog {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Library Catalog System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: addBook(scanner); break;
                case 2: searchBook(scanner);break;
                case 3: listBooks();break;
                case 4: System.out.println("Exiting... Thank you for using the Library Catalog System!");break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    private static void searchBook(Scanner scanner) {
        System.out.print("Enter title or author to search: ");
        String query = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the given title/author.");
        }
    }

    private static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the catalog.");
        } else {
            System.out.println("--- List of Books ---");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
