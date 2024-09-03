<h1>Description</h1>
<p>This repository contains a Shop Management System developed during my practice program at IBM Romania. The application is built using Java and Spring Boot and provides RESTful APIs to manage products and bills within a shop environment.</p>
<h1>Features</h1>
<h3>Add Product</h3>
<ul>
  <li>Allows the addition of new products to the shop's inventory</li>
</ul>
<h3>Get All Products</h3> 
<ul>
  <li>Retrieves a list of all products available in the shop</li>
</ul>
<h3>Edit Product</h3>
<ul>
  <li>Updates details of an existing product</li>
</ul>
<h3>Delete Product</h3>
<ul>
  <li>Removes a product from the inventory based on its ID</li>
</ul>
<h3>Add Bill</h3>
<ul>
  <li>Records a bill with its cost and description</li>
</ul>
<h3>Controller</h3>
<ul>
  <li>It handles HTTP requests related to products and bills</li>
  <li>It provides endpoints to interact with the services that manage the shop's operations</li>
</ul>
<h3>DTO</h3>
<ul>
  <li>The project uses DTOs to transfer data between the client and server</li>
</ul>
<h3>Entity</h3>
<ul>
  <li>Entities represent the data structure in the database</li>
  <li>It represents a bill or a product with its fields</li>
</ul>
<h3>Repository</h3>
<ul>
  <li>Repositories interface with the database using Spring Data JPA</li>
  <li>Provides CRUD operations for "Bill" and "Product" entities</li>
</ul>
<h3>Service</h3>
<ul>
  <li>Services contain the business logic of the application</li>
  <li>Handles operations related to bills, including adding new bills</li>
  <li>Manages product operations such as retrieval, addition, editing, and deletion</li>
</ul>
