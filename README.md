
# ReliaQuest Entry-Level Java Challenge

## Overview

This project implements a simple and practical REST API for managing employee data.  
The main goal was to expose employee information in a clean and usable way so that it can be consumed by external systems (like Employees-R-US webhooks).

The focus of this solution is on clarity, practicality, and clean design rather than overengineering.

---

## Tech Stack

- Java 17
- Spring Boot
- Gradle
- REST APIs

---

## API Endpoints

### 1. Get All Employees
GET /api/v1/employee

Returns a list of all employees.

---

### 2. Get Employee by UUID
GET /api/v1/employee/{uuid}

Returns a specific employee if found.  
If not found, returns a 404 error.

---

### 3. Create Employee
POST /api/v1/employee

Sample request body:

```json
{
  "firstName": "Ankit",
  "lastName": "Jadhav",
  "email": "ankit@example.com"
}
````

Returns the created employee with a generated UUID.

---

## Functionality

The API supports:

* Creating employees
* Fetching all employees
* Fetching employee by UUID
* Basic input validation
* Proper error responses
* API key-based security

---

## Service Layer

The application follows a service-based structure:

* **EmployeeService (interface)** → defines operations
* **EmployeeServiceImpl (implementation)** → contains business logic

This separation keeps the controller clean and allows easy future extension (for example, adding a database).

---

## Validation

Basic validation is implemented to ensure correct input:

* `firstName` must not be empty
* `email` must not be empty

Invalid requests return:

400 Bad Request

---

## Exception Handling

Errors are handled using a global exception handler (`@ControllerAdvice`).

Examples:

* Employee not found → 404 Not Found
* Invalid input → 400 Bad Request

This ensures consistent and meaningful error responses.

---

## Security

The API is secured using a simple API key.

Each request must include:

x-api-key: my-secret-key

If the key is missing or incorrect:

401 Unauthorized

This approach is lightweight and works well for webhook-based integrations.

---

## Efficiency & Design Choices

The solution focuses on simplicity and efficiency:

* Uses in-memory storage for fast access
* Avoids unnecessary database setup
* Keeps API responses lightweight
* Prioritizes readability and maintainability

---

## Architecture

The project follows a layered structure:

Controller → Service Interface → Service Implementation → Model

This helps in:

* Keeping code organized
* Improving readability
* Making future changes easier

---

## Data Storage

Employee data is stored in-memory using a list.

This was intentionally done as persistence was not required for this task.

In a real-world system, this can be replaced with:

* Database (MySQL / PostgreSQL)
* Repository layer (Spring Data JPA)

---

## How to Run

1. Navigate to the project folder:

cd api

2. Run the application:

gradle bootRun

3. Server starts at:

[http://localhost:8080](http://localhost:8080)

---

## How to Test

Use Postman or curl.

### Example Request

POST /api/v1/employee

Headers:

x-api-key: my-secret-key
Content-Type: application/json

---

## API Testing Screenshots

### Create Employee (POST)

<img width="1440" height="900" alt="Screenshot 2026-04-10 at 4 43 40 PM" src="https://github.com/user-attachments/assets/5c269d76-e25f-452c-8e8a-167323d0c2b2" />


### Get All Employees (GET)

<img width="1440" height="900" alt="Screenshot 2026-04-10 at 4 30 49 PM" src="https://github.com/user-attachments/assets/0cf35984-1bae-4364-894c-965f0b305e2f" />


### Get Employee by UUID

<img width="1440" height="900" alt="Screenshot 2026-04-10 at 5 25 37 PM" src="https://github.com/user-attachments/assets/31a8d404-2ad0-4b91-b48e-5cde811bfff3" />


### Unauthorized Request (No API Key)

<img width="1440" height="900" alt="Screenshot 2026-04-10 at 4 36 13 PM" src="https://github.com/user-attachments/assets/3ab3c3e0-b98b-46c9-9c69-d84cf4613be9" />


### Validation Error (Missing Field)

<img width="1440" height="900" alt="Screenshot 2026-04-10 at 4 31 44 PM" src="https://github.com/user-attachments/assets/01d05295-24b1-489a-9d80-1a4651dfa3bd" />


---

## Scalability (Future Improvements)

The current implementation is simple, but can be extended:

* Add database support
* Introduce caching (Redis)
* Use message queues (Kafka/RabbitMQ)
* Replace API key with JWT/OAuth2
* Deploy multiple instances behind a load balancer

The structure is designed so these can be added without major changes.

---

## Final Note

This implementation aligns closely with the problem statement and requirements provided for the assessment.

The solution exposes the required REST endpoints to retrieve and create employee data, ensuring that the existing system can be interfaced with an external platform as intended.

Key aspects addressed:

- All required endpoints (`getAllEmployees`, `getEmployeeByUuid`, `createEmployee`) are implemented
- The API is designed to be simple, usable, and easy to integrate with webhook-based systems
- In-memory storage is used as specified, avoiding unnecessary persistence complexity
- Basic validation and error handling are included to ensure robustness
- API key-based security is implemented to protect endpoints
- Clean architecture is followed to keep the code maintainable and extensible

Overall, the solution focuses on practicality and clarity while remaining aligned with the scope and expectations of the assignment.
