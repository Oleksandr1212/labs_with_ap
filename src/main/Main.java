package main;

import models.Book;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запитуємо кількість книг
        System.out.print("Enter number of books: ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine(); // для зчитування залишку нового рядка після nextInt()

        // Створюємо масив для зберігання об'єктів Book
        Book[] books = new Book[numberOfBooks];
        // Збираємо інформацію про кожну книгу від користувача
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // зчитуємо залишок нового рядка

            System.out.print("Title: ");
            String title = scanner.nextLine();

            System.out.print("Author: ");
            String author = scanner.nextLine();

            System.out.print("Publisher: ");
            String publisher = scanner.nextLine();

            System.out.print("Year of publication: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // зчитуємо залишок нового рядка

            System.out.print("Number of pages: ");
            int pages = scanner.nextInt();

            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // зчитуємо залишок нового рядка після ціни

            // Створюємо новий об'єкт Book та додаємо його до масиву
            books[i] = new Book(id, title, author, publisher, year, pages, price);
        }

        // Меню вибору дій
        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Search books by author");
            System.out.println("2 - Search books by publisher");
            System.out.println("3 - Search books published after a certain year");
            System.out.println("4 - Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // зчитуємо залишок нового рядка

            switch (choice) {
                case 1:
                    System.out.print("Enter author to search for: ");
                    String searchAuthor = scanner.nextLine();
                    System.out.println("Books by author " + searchAuthor + ":");
                    printBooksByAuthor(books, searchAuthor);
                    break;
                case 2:
                    System.out.print("Enter publisher to search for: ");
                    String searchPublisher = scanner.nextLine();
                    System.out.println("Books from publisher " + searchPublisher + ":");
                    printBooksByPublisher(books, searchPublisher);
                    break;
                case 3:
                    System.out.print("Enter year to search for books published after: ");
                    int searchYear = scanner.nextInt();
                    System.out.println("Books published after " + searchYear + ":");
                    printBooksAfterYear(books, searchYear);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // Метод для виведення списку книг заданого автора
    public static void printBooksByAuthor(Book[] books, String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by this author.");
        }
    }

    // Метод для виведення списку книг заданого видавництва
    public static void printBooksByPublisher(Book[] books, String publisher) {
        boolean found = false;
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                System.out.println(book.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found from this publisher.");
        }

    }

    // Метод для виведення списку книг, виданих після заданого року
    public static void printBooksAfterYear(Book[] books, int year) {
        boolean found = false;
        for (Book book : books) {
            if (book.getYear() > year) {
                System.out.println(book.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found published after this year.");
        }
    }
}
