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

## Project Structure
The application follows a standard Spring Boot architecture:

src/main/java/com/rideconnect/rideconnect/ - Root package for all Java code

- **Models**: Entity classes that map to database tables
- **Repository**: JPA interfaces for database access
- **Service**: Business logic implementation 
- **Controller**: REST API endpoints


### Ride Endpoints
- **POST** `/api/v1/ride/RideRequest`: Request a ride.
  - Parameters: `ride_type` (1: Saver, 2: Standard, 3: Premium)
  - Body: Ride details (JSON)

- **GET** `/api/v1/ride/RideRequest`: Test ride request.

### Driver Offer Endpoints
- **GET** `/api/v1/driver_offer/get_all_offers`: Retrieve all driver offers.
- **PATCH** `/api/v1/driver_offer/accept_offer`: Accept a specific offer.
  - Parameters: `offer_id`, `driver_id`





