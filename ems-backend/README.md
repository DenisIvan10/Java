<h1>Description</h1>
<p>This is a Spring Boot application designed to manage employee data in an organization. It provides RESTful APIs for creating, reading, updating, and deleting employee records. The project is implemented using a layered architecture with a clear separation of concerns.</p>
<h1>Features</h1>
<h3>Add Employee</h3>
<ul>
  <li>Add a new employee to the database</li>
</ul>
<h3>Get Employee by ID</h3> 
<ul>
  <li>Retrieve employee details by their unique ID</li>
</ul>
<h3>Get All Employees</h3>
<ul>
  <li>Retrieve all employees from the database</li>
</ul>
<h3>Update Employee</h3>
<ul>
  <li>Update the details of an existing employee</li>
</ul>
<h3>Delete Employee</h3>
<ul>
  <li>Remove an employee from the database</li>
</ul>
<h3>Exception Handling</h3>
<ul>
  <li>Handles cases where an employee is not found</li>
</ul>
<h3>Controller</h3>
<ul>
  <li>Handles incoming HTTP requests and returns responses to the client</li>
</ul>
<h3>DTO</h3>
<ul>
  <li>It is used to transfer employee data between the client and server without exposing the entity directly</li>
</ul>
<h3>Entity</h3>
<ul>
  <li>Represents the employee data model and maps it to the database</li>
</ul>
<h3>Exception</h3>
<ul>
  <li>It is thrown when an employee with the specified ID is not found</li>
</ul>
<h3>Mapper</h3>
<ul>
  <li>Maps data between the Entity and DTO layers</li>
</ul>
<h3>Repository</h3>
<ul>
  <li>Interface for database operations using Spring Data JPA, providing CRUD operations on "Employee" entities</li>
</ul>
<h3>Service</h3>
<ul>
  <li>It defines methods for employee operations like creating, retrieving, updating, and deleting employees</li>
</ul>
<h3>Service Implementation</h3>
<ul>
  <li>It contains the business logic and interacts with the repository to perform database operations</li>
</ul>
