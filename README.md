# Meals API Project

## Table of Contents

1. [Introduction](#introduction)  
2. [Project Structure](#project-structure)  
3. [Configuring MySQL Database](#configuring-mysql-database)  
4. [Setting Local Variables for Database Connection](#setting-local-variables-for-database-connection)  
5. [API Endpoints](#api-endpoints)  
6. [Example Use Cases](#example-use-cases)  
7. [Running the Project](#running-the-project)

---

## Introduction

The Meals API is a Java-based web application that provides a RESTful API for managing meals and restaurants. It uses Spring Boot as the application framework and MySQL as the database management system.

---

## Project Structure

```
meals-api/
├── src/
│   ├── main/java/       # Java source code
│   ├── main/resources/  # Configuration files (e.g., application.properties)
│   └── test/java/       # Test source code
├── pom.xml              # Maven build file
```

---

## Configuring MySQL Database

Use the SQL script below to create the necessary tables:

```sql
CREATE TABLE Restaurant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200),
    city VARCHAR(100),
    state VARCHAR(50),
    zipCode VARCHAR(20)
);

CREATE TABLE Meal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cost DECIMAL(10,2),
    ingredients TEXT,
    restaurant_id INT,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(id)
        ON DELETE SET NULL
);

CREATE TABLE RestaurantEvaluation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    evaluation INT CHECK (evaluation BETWEEN 0 AND 10),
    comment TEXT,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(id)
        ON DELETE CASCADE
);

CREATE TABLE MealEvaluation (
    id INT AUTO_INCREMENT PRIMARY KEY,
    meal_id INT,
    evaluation INT CHECK (evaluation BETWEEN 0 AND 10),
    comment TEXT,
    FOREIGN KEY (meal_id) REFERENCES Meal(id)
        ON DELETE CASCADE
);
```

---

## Setting Local Variables for Database Connection

Configure the following properties in your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mealsdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Explanation:

- `spring.datasource.url`: MySQL database URL  
- `spring.datasource.username`: your database username  
- `spring.datasource.password`: your database password  
- `spring.jpa.hibernate.ddl-auto`: Hibernate strategy (`update` keeps schema up-to-date)

🔐 Replace `your_username` and `your_password` with your actual MySQL credentials.



## API Endpoints

- `GET /restaurants` – List all restaurants  
- `GET /restaurants/{id}` – Get a specific restaurant  
- `POST /restaurants` – Create a new restaurant  
- `PUT /restaurants/{id}` – Update a restaurant  
- `DELETE /restaurants/{id}` – Delete a restaurant  

- `GET /meals` – List all meals  
- `GET /meals/{id}` – Get a specific meal  
- `POST /meals` – Create a new meal  
- `PUT /meals/{id}` – Update a meal  
- `DELETE /meals/{id}` – Delete a meal  

- `GET /evaluations` – List all evaluations  
- `GET /evaluations/{id}` – Get a specific evaluation  
- `POST /evaluations` – Create a new evaluation  
- `PUT /evaluations/{id}` – Update an evaluation  
- `DELETE /evaluations/{id}` – Delete an evaluation

---

## Example Use Cases

- **Create a restaurant:**  
  `POST /restaurants`  
  ```json
  {
    "name": "Toscana",
    "address": "Rua Exemplo, 123",
    "city": "Cidade Exemplo",
    "state": "Estado Exemplo",
    "zipCode": "12345-678"
}
  ```

- **List all meals:**  
  `GET /meals`

- **Create a meal:**  
  `POST /meals`  
  ```json
  {
    "name": "Sushi",
    "cost": 40.99,
    "ingredients": "Sushi Frito",
    "restaurantId": 1
}
  ```

- **Evaluate a meal:**  
  `POST /evaluations`  
  ```json
  {
    "evaluation": 5,
    "comment": "VERY GOOOOOOD"
  }
  ```

---

## Running the Project

Make sure MySQL is running and accessible with the credentials in your `application.properties`, then:

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at:  
`http://localhost:8080`
