public class BookApp {
    public static void main(String[] args) {
        Book b1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        Book b2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", 12.99);

        System.out.println(b1);
        System.out.println(b2);
    }
}