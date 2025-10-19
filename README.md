# Order Management System

A comprehensive web-based Order Management System built with Spring MVC, Hibernate, and MySQL. This application provides
complete CRUD operations for managing products, customers, orders, and order details with a clean MVC architecture.

## Features

- **Product Management**: Add, view, update, and delete products
- **Customer Management**: Complete customer information management with validation
- **Order Processing**: Create and manage orders with multiple products
- **Order Details**: Track individual items within orders with quantity and subtotal
- **Spring Security**: Secure authentication and authorization
- **Responsive JSP Views**: User-friendly interface with JSTL tags

## Technologies Used

- **Java**: 21
- **Spring Framework**: 6.2.12
    - Spring MVC
    - Spring ORM
    - Spring Security 6.5.5
    - Spring Transaction Management
- **Hibernate ORM**: 5.6.15.Final
- **Database**: MySQL 8.0.30
- **Build Tool**: Maven 3.x
- **Server**: Tomcat/Jetty (embedded)
- **View Technology**: JSP/JSTL
- **Validation**: Bean Validation API 2.0.1 with Hibernate Validator 8.0.3
- **Logging**: SLF4J 2.0.17 with Log4j

## Project Structure

```
Order-Management-System/
├── src/main/java/com/hendi/oms/
│   ├── controller/          # MVC Controllers
│   │   ├── CustomerController.java
│   │   ├── OrdersController.java
│   │   ├── OrderDetailsController.java
│   │   └── ProductController.java
│   ├── model/              # Entity classes
│   │   ├── Customer.java
│   │   ├── Orders.java
│   │   ├── OrderDetails.java
│   │   └── Product.java
│   ├── dao/                # Data Access Layer
│   │   ├── CustomerDAO.java / CustomerDAOImpl.java
│   │   ├── OrdersDAO.java / OrdersDAOImpl.java
│   │   ├── OrderDetailsDAO.java / OrderDetailsDAOImpl.java
│   │   └── ProductDAO.java / ProductDAOImpl.java
│   ├── service/            # Business Logic Layer
│   │   ├── CustomerService.java / CustomerServiceImpl.java
│   │   ├── OrdersService.java / OrdersServiceImpl.java
│   │   ├── OrderDetailsService.java / OrderDetailsServiceImpl.java
│   │   └── ProductService.java / ProductServiceImpl.java
│   └── validator/          # Custom validators
│       ├── CustomerValidator.java
│       └── ProductValidator.java
├── src/main/webapp/
│   └── WEB-INF/
│       ├── views/          # JSP views
│       └── spring/         # Spring configuration files
└── src/main/resources/
    └── db_order.sql        # Database schema

## Database Setup

### 1. Create the Database

```bash
mysql -u root -p
```

### 2. Run the SQL Script

```bash
mysql -u root -p < src/main/resources/db_order.sql
```

Or manually execute the script in your MySQL client:

```sql
CREATE
DATABASE IF NOT EXISTS db_order;
USE
db_order;
-- Then run the schema from db_order.sql
```

### 3. Database Configuration

The database configuration is located in:
`src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml`

Default settings:

- **Database**: db_order
- **Host**: localhost:3306
- **Username**: root
- **Password**: root

Modify these settings according to your MySQL installation.

## Database Schema

The application uses the following tables:

- **product**: Stores product information (ID, name, description, unit price)
- **customer**: Stores customer details (ID, name, email, phone, address)
- **orders**: Stores order information (ID, customer ID, total amount)
- **orderDetails**: Stores individual order items (ID, order ID, product ID, quantity, subtotal)

## Installation and Running

### Prerequisites

- Java 21 or higher
- Maven 3.x
- MySQL 8.x
- Apache Tomcat 9.x or Jetty (optional)

### Build the Project

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package as WAR file
mvn package
```

### Running the Application

#### Option 1: Using Jetty Maven Plugin

```bash
mvn jetty:run
```

Then access the application at:

```
http://localhost:8080/OMS/
```

#### Option 2: Using Tomcat Maven Plugin

```bash
mvn tomcat7:run
```

Then access the application at:

```
http://localhost:8080/OMS/
```

#### Option 3: Deploy WAR to Application Server

1. Build the WAR file:
   ```bash
   mvn package
   ```

2. Deploy the generated `target/OMS.war` to your Tomcat server's `webapps` directory

3. Access the application at:
   ```
   http://localhost:8080/OMS/
   ```

## Application URLs

After starting the application:

- **Main Application**: http://localhost:8080/OMS/
- **Login Page**: http://localhost:8080/OMS/login
- **Customer Management**: http://localhost:8080/OMS/customer
- **Product Management**: http://localhost:8080/OMS/product
- **Orders Management**: http://localhost:8080/OMS/orders
- **Order Details**: http://localhost:8080/OMS/orderDetails

## Development

### Project Configuration Files

- `pom.xml`: Maven dependencies and build configuration
- `src/main/webapp/WEB-INF/web.xml`: Web application configuration
- `src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml`: Spring MVC configuration
- `src/main/webapp/WEB-INF/spring/appServlet/security-config.xml`: Spring Security configuration
- `src/main/webapp/WEB-INF/spring/root-context.xml`: Root application context

### Architecture

The application follows a layered architecture:

1. **Presentation Layer**: JSP views and Spring MVC controllers
2. **Business Logic Layer**: Service classes with transaction management
3. **Data Access Layer**: DAO classes using Hibernate
4. **Persistence Layer**: MySQL database

## Build Status

- **Compilation**: SUCCESS
- **Tests**: PASSED
- **Package**: SUCCESS
- **WAR File**: Generated at `target/OMS.war`

## Contributing

1. Fork the repository
2. Create your feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is open source and available for educational purposes.

## Author

Hendi Santika

## Version

1.0-SNAPSHOT
