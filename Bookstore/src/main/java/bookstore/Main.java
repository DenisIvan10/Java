package bookstore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import ro.digitalnation.proiect.Book;

public class Main {
	public static void main(String[] args) {
		Author author = new Author(1L, "J.K. Rowling");
        Category category = new Category(1L, "Fantasy");

        Book book1 = new Book(1L, "Harry Potter and the Philosopher's Stone", "978-0747532699", 29.99, 100, author, category);
        Book book2 = new Book(2L, "Harry Potter and the Chamber of Secrets", "978-0747538493", 35.99, 50, author, category);

        Customer customer = new Customer(1L, "John Doe", "john.doe@example.com");

        OrderItem item1 = new OrderItem(1L, book1, 2);
        OrderItem item2 = new OrderItem(2L, book2, 1);

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(item1);
        orderItems.add(item2);

        Order order = new Order(1L, LocalDateTime.now(), customer, orderItems);

        System.out.println(customer);
        System.out.println(order);
        for (OrderItem item : orderItems) {
            System.out.println(item);
        }
	}
}
