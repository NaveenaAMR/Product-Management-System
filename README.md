# Product Management System – Spring Boot Backend

This project is a Product Management System built using Spring Boot.  
It provides REST APIs to manage products and handle user authentication in a secure manner.

The application allows users to **register and log in, and once authenticated, perform CRUD (Create, Read, Update, Delete) operations on products along with search functionality.  
Security is implemented using Spring Security and JWT (JSON Web Token) to ensure only authenticated users can access protected endpoints.



##  Features

###  Authentication & Security
- User registration
- User login
- JWT-based authentication
- Stateless session management
- Password encryption using BCrypt
- Spring Security integration

### Product Management
- Create new products
- View all products
- View product by ID
- Update product details
- Delete products
- Search products by keyword
- Product image handling

---

##  Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

## 🔄 Project Flow

### 1️⃣ User Registration
- User submits registration details
- Password is encrypted using BCrypt
- User data is stored securely in the database



### 2️⃣ User Login & Authentication
- User submits login credentials
- Spring Security authenticates the user
- JWT token is generated on successful login
- Token is returned to the client

---

### 3️⃣ Request Authorization
- Client includes JWT token in request headers
- JWT filter validates the token
- User details are loaded and authenticated for the request

---

### 4️⃣ Product Management Operations
- Authenticated users can perform CRUD operations on products
- Product data is handled using Spring Data JPA
- Changes are persisted in the database



### 5️⃣ Product Search
- Users can search products using keywords
- Matching products are retrieved from the database
- Results are returned to the client



