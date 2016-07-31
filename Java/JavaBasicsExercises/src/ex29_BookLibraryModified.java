import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex29_BookLibraryModified {
    public static class Book {
        String name;
        String author;
        String publisher;
        LocalDate date;
        String isbn;
        Double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

    public static class Library {
        String name;
        List<Book> books;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        Library library = new Library();
        library.setName("Library");
        List<Book> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (int i = 0; i < num; i++) {
            String[] arr = sc.nextLine().split(" ");
            String name = arr[0];
            String author = arr[1];
            String publisher = arr[2];

            LocalDate date = LocalDate.parse(arr[3], formatter);
            String isbn = arr[4];
            double price = Double.parseDouble(arr[5]);

            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setDate(date);
            book.setIsbn(isbn);
            book.setPrice(price);

            list.add(book);
        }

        String targetDateString = sc.nextLine();
        LocalDate targetDate = LocalDate.parse(targetDateString, formatter);

        library.setBooks(list);

        library.getBooks().stream()
                .filter(date -> date.getDate().isAfter(targetDate))
                .sorted((b1, b2) -> b1.getName().compareTo(b2.getName()))
                .sorted((d1, d2) -> d1.getDate().compareTo(d2.getDate()))
                .forEach(book -> {
                    System.out.println(book.name + " -> " + formatter.format(book.date));
                });
        sc.close();
    }
}
