package ro.digitalnation.proiect;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.Author;
import bookstore.Category;
import bookstore.Customer;
import bookstore.Order;
import bookstore.OrderItem;

@Controller
public class BookController {

    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();
    private static List<Category> categories = new ArrayList<>();
    
    private static Long bookCounter = 1L;
    private static Long authorCounter = 1L;
    private static Long categoryCounter = 1L;
    
    private static List<Order> orders = new ArrayList<>();

    private static Long orderCounter = 1L;
    private static Long customerCounter = 1L;
    private static Long orderItemCounter = 1l;
    
    @Autowired
    private BookRepository bookRepository;
    
    static {
    	Author author = new Author(authorCounter++, "J.K. Rowling");
        Category category = new Category(categoryCounter++, "Fantasy");

        Book book1 = new Book(bookCounter++, "Harry Potter and the Philosopher's Stone", "978-0747532699", 29.99, 100, author, category);
        Book book2 = new Book(bookCounter++, "Harry Potter and the Chamber of Secrets", "978-0747538493", 35.99, 50, author, category);
        
        books.add(book1);
        books.add(book2);
        
        authors.add(author);
        categories.add(category);
        
        
        Order order1 = new Order(orderCounter++, LocalDateTime.now(), new Customer(customerCounter++, "John Doe", "john.doe@example.com"), List.of(new OrderItem(orderItemCounter++, book1, 2)));
        Order order2 = new Order(orderCounter++, LocalDateTime.now(), new Customer(customerCounter++, "Jane Smith", "jane.smith@example.com"), List.of(new OrderItem(orderItemCounter++, book2, 1)));
        
        orders.add(order1);
        orders.add(order2);
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
    	model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @GetMapping("/addBooks")
    public String addBooks(Model model) {
        return "addBooks";
    }
    
    @PostMapping("/addBooks")
	public String adaugaCurs(@RequestParam String title, @RequestParam String isbn, @RequestParam double price, 
			@RequestParam String authorName, 
			@RequestParam String categoryName) {
    	
    	Author author = new Author(authorCounter++, authorName);
    	Category category = new Category(categoryCounter++, categoryName);
    	Book book = new Book(bookCounter++, title, isbn, price, 100, author, category);
    	authors.add(author);
        categories.add(category); 
    	books.add(book);
    	bookRepository.save(book);
    	return "redirect:/books";
	}
    
    @GetMapping("/deleteBooks")
    public String deleteBooks(Model model) {
        return "deleteBooks";
    }
    
    @PostMapping("/deleteBooks")
	public String adaugaCurs(@RequestParam String title) {
    	List<Book> books = (List<Book>) bookRepository.findAll();
    	
    	for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().equals(title)) {
            	bookRepository.delete(book);
                break;
            }
        }
    	
    	return "redirect:/books";
	}
    
    
    @GetMapping("/orders")
    public String listOrders(Model model) {
        model.addAttribute("orders", orders);
        return "orders";
    }
  
}
