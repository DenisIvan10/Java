<h1>Description</h1>
<p>The Bookstore Application is a Java-based web application built using Spring Boot and Thymeleaf. It allows users to browse, add, and delete books from a bookstore inventory. The application also supports order management, including customer details and order tracking. This application was my final project for Generatia Tech Java course and based on it I got my certification. </p>
<h1>Features</h1>
<h3>Display Book List</h3>
<ul>
  <li>Shows all books available in the bookstore</li>
</ul>
<h3>Add Book</h3>
<ul>
  <li>Allows users to add new books to the bookstore inventory</li>
</ul>
<h3>Delete Book</h3>
<ul>
  <li>Removes a book from the inventory based on its title</li>
</ul>
<h3>Manage Orders</h3>
<ul>
  <li>Handles customer orders and order details</li>
</ul>
<h3>Controller</h3>
<ul>
  <li>Manages HTTP requests related to books and orders</li>
  <li>Provides endpoints for adding, retrieving, and deleting books</li>
</ul>
<h3>Repository</h3>
<ul>
  <li>Interfaces with the database using Spring Data JPA</li>
  <li>Provides CRUD operations for books and orders</li>
</ul>
<h3>Requests</h3>
<ul>
  <li>GET /books - No parameters required - Displays all the books in the bookstore that we add from the addBooks page. After adding, you can see the books in the table in the h2 database.</li>
  <li>GET and POST /addBooks - No parameters required - Add books to the bookstore. We fill out the form, and then we will be redirected to the /books page where you can see the added books. After adding, you can see the books in the table in the h2 database.</li>
  <li>GET and POST /deleteBooks - No parameters required - Delete an added book, which is present in the books page by name. We enter in the form the name of the book we want to delete, then we will be redirected to the /books page where we can observe the deletion of the book. After deletion, you can also see in the table in the h2 database how the respective book was deleted.</li>
  <li>GET /orders - No parameters required - It displays the commands hardcoded by me in the code, without being connected to a table in the database.</li>
</ul>
