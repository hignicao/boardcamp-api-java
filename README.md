# BoardCamp API

BoardCamp API is a RESTful web service for managing a board game rental system. It allows users to interact with the system to manage games, customers, and rentals.

## Endpoints

### Games

- **GET /games**: Retrieves a list of all games available for rental.
- **POST /games**: Adds a new game to the system.

### Customers

- **POST /customers**: Adds a new customer to the system.
- **GET /customers/{id}**: Retrieves information about a specific customer by their ID.

### Rentals

- **GET /rentals**: Retrieves a list of all rentals in the system.
- **POST /rentals**: Creates a new rental in the system.
- **PUT /rentals/{id}/return**: Marks a rental as returned.

## Data Models

### Game

- **id**: Unique identifier for the game.
- **name**: Name of the game.
- **image**: URL of the game's image.
- **stockTotal**: Total number of copies available for rental.
- **pricePerDay**: Price per day to rent the game.

### Customer

- **id**: Unique identifier for the customer.
- **name**: Name of the customer.
- **cpf**: Brazilian Individual Taxpayer Registry (CPF) of the customer.

### Rental

- **id**: Unique identifier for the rental.
- **customerId**: ID of the customer who rented the game.
- **gameId**: ID of the game that was rented.
- **rentDate**: Date when the rental was made.
- **daysRented**: Number of days the game was rented for.
- **returnDate**: Date when the game was returned.
- **originalPrice**: Total price of the rental.
- **delayFee**: Fee charged for late returns.

## Error Handling

The API provides error responses with appropriate HTTP status codes and messages for different scenarios, such as resource not found, conflicts, bad requests, and unprocessable entities.

## Dependencies

- Spring Boot
- Spring Data JPA
- Jakarta Persistence
- Lombok
- Validation
- Spring Boot DevTools

## Authors

- [Hugo Ignacio](https://github.com/hignicao)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
