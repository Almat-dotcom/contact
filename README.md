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


You need to create your own database in PgAdmin or any other database management tool, or use a local database.

Here is an example of how to configure your database in the application.properties file:

spring.datasource.url=jdbc:postgresql://localhost:5433/contact
spring.datasource.username=your_username
spring.datasource.password=your_password

After running the project, you can access the following links to check the API endpoints:

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
 
