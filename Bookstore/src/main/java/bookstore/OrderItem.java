package bookstore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ro.digitalnation.proiect.Book;

@Entity
public class OrderItem{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private Book book;
    private int quantity;
    private double totalPrice;
    
	public OrderItem(Long id, Book book, int quantity) {
		super();
		this.id = id;
		this.book = book;
		this.quantity = quantity;
		this.totalPrice = book.getPrice() * quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", book=" + book + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
    
    
}
