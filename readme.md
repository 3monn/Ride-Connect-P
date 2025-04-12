

## Features
- **Ride Request**: Riders can request rides with specific pickup and drop-off locations.
- **Driver Offers**: Drivers can accept ride offers
- **Dynamic Fare Calculation**: Fares are calculated based on distance, ride type.
- **Database Integration**: Uses PostgreSQL for data persistence.

## Technologies Used
- **Backend**: Spring Boot (Java)
- **Database**: PostgreSQL
- **ORM**: Hibernate (JPA)
- **REST API**: Spring Web
- **JSON Handling**: Jackson
- **Build Tool**: Maven

## Installation

### Prerequisites
- Java 23
- Maven
- PostgreSQL

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/rideconnect.git
   cd rideconnect
   ```

2. Configure the database:
   - Update `application.properties` with your PostgreSQL credentials:
     ```properties
     spring.datasource.url=your_datasource
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. Build the project:
   ```bash
   ./mvnw clean install
   ```

4. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

5. Access the API at:
   ```
   http://localhost:8080
   ```

## API Endpoints

### Ride Endpoints
- **POST** `/api/v1/ride/RideRequest`: Request a ride.
  - Parameters: `ride_type` (1: Saver, 2: Standard, 3: Premium)
  - Body: Ride details (JSON)

- **GET** `/api/v1/ride/RideRequest`: Test ride request.

### Driver Offer Endpoints
- **GET** `/api/v1/driver_offer/get_all_offers`: Retrieve all driver offers.
- **PATCH** `/api/v1/driver_offer/accept_offer`: Accept a specific offer.
  - Parameters: `offer_id`, `driver_id`





