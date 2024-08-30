## Features

- Add a new customer
- Add a new customer contact (phone or email)
- Retrieve a list of customers
- Retrieve detailed information about a specific customer by ID
- Retrieve a list of contacts for a specific customer
- Retrieve a list of contacts of a specific type for a specific customer

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- MapStruct
- Swagger (Springdoc OpenAPI)
- Lombok

## API

- Add a New Customer 
  POST /api/customers
  {
  "name": "This is Sparta"
  }

- Add a New Contact for a Customer
  POST /api/contacts
  {
  "customerId": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "contactType": "EMAIL",
  "value": "sparta@example.com"
  }

- Retrieve a List of All Customers
  GET /api/customers
  Pageable

- Retrieve Detailed Information About a Specific Customer by ID
  GET /api/customers/{customerId}

- Retrieve a List of Contacts for a Specific Customer
  GET /api/contacts/{customerId}

- Retrieve a List of Contacts of a Specific Type for a Specific Customer
  GET /api/contacts/{customerId}/type/{type}

You need to create your own database in PgAdmin or any other database management tool, or use a local database.

Here is an example of how to configure your database in the application.properties file:

spring.datasource.url=jdbc:postgresql://localhost:5433/contact
spring.datasource.username=your_username
spring.datasource.password=your_password

After running the project, you can access the following links to check the API endpoints:

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
 
