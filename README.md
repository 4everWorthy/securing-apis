
```markdown 
```

## Securing APIs with JWT Authentication and Authorization
```
## Project Overview

This Spring Boot application implements security measures to secure APIs using JWT (JSON Web Tokens). It supports authentication and role-based access control (RBAC) with `ADMIN` and `USER` roles. In-memory authentication is used for simplicity, and users can register, log in, and access secured API endpoints based on their assigned roles.
```
## Features
- JWT-based Authentication and Authorization
- Role-Based Access Control (RBAC) for `ADMIN` and `USER`
- API Endpoints secured with different roles
- In-memory user authentication (no database required)
- Postman testing for API endpoints

## Project Structure
```
## Setup and Run Instructions

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/securing-apis.git
   cd securing-apis
   ```

2. **Build the project** using Maven:
   ```bash
   mvn clean install
   ```

3. **Run the Spring Boot application**:
   ```bash
   mvn spring-boot:run
   ```

   The application will be running at `http://localhost:8080`.

## API Endpoints

### 1. **User Registration Endpoint**
- **URL**: `/api/register`
- **Method**: `POST`
- **Description**: Allows users to register with a username and password.
- **Request Body** (form-data or x-www-form-urlencoded):
    - `username`: Your desired username
    - `password`: Your desired password

### 2. **User Login Endpoint (JWT Token Generation)**
- **URL**: `/api/auth/login`
- **Method**: `POST`
- **Description**: Logs in a user and returns a JWT token.
- **Request Body** (form-data or x-www-form-urlencoded):
    - `username`: Registered username
    - `password`: Registered password

- **Response Example**:
   ```json
   Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY3MDg5NzUyNCwiaWF0IjoxNjcwODkzOTI0fQ.7vlhYbI_uePmC4u1V4tq6rCQIf5Ny6f1J9vEDOkhdQ
   ```

### 3. **Admin Protected Endpoint**
- **URL**: `/api/admin/test`
- **Method**: `GET`
- **Description**: Access restricted to users with `ADMIN` role.
- **Authorization**: Bearer Token (from login response)
- **Headers**:
    - `Authorization: Bearer <your-token-here>`

### 4. **User Protected Endpoint**
- **URL**: `/api/user/test`
- **Method**: `GET`
- **Description**: Access restricted to users with `USER` role.
- **Authorization**: Bearer Token (from login response)
- **Headers**:
    - `Authorization: Bearer <your-token-here>`

### 5. **Public Endpoint**
- **URL**: `/api/public/test`
- **Method**: `GET`
- **Description**: Publicly accessible, no authentication required.

## Testing the APIs Using Postman

1. **Register a new user**:
    - Method: `POST`
    - URL: `http://localhost:8080/api/register`
    - Body (form-data or x-www-form-urlencoded):
        - `username`: your_username
        - `password`: your_password

2. **Log in to get the JWT token**:
    - Method: `POST`
    - URL: `http://localhost:8080/api/auth/login`
    - Body (form-data or x-www-form-urlencoded):
        - `username`: your_username
        - `password`: your_password
    - Copy the **Bearer Token** from the response.

3. **Access Admin or User endpoints**:
    - Method: `GET`
    - URL (Admin): `http://localhost:8080/api/admin/test`
    - URL (User): `http://localhost:8080/api/user/test`
    - Headers:
        - `Authorization: Bearer <your-token-here>`

4. **Access Public endpoint**:
    - Method: `GET`
    - URL: `http://localhost:8080/api/public/test`
    - No authentication required.


