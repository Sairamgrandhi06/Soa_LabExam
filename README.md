# Static Login API (Spring Boot)

A small Spring Boot REST API demonstrating a login endpoint with fixed demo credentials.

## Requirements
- Java 17 or later
- Maven 3.6+ (or use the Maven support in your IDE)

## Run the project
From the project root, run:

```bash
mvn spring-boot:run
```

The server starts at `http://localhost:8080`.

## Endpoint
`POST http://localhost:8080/api/auth/login-static`

### Successful request
Header: `Content-Type: application/json`

```json
{
  "username": "admin",
  "password": "password123"
}
```

Expected HTTP status: `200 OK`

```json
{
  "message": "Authentication Successful"
}
```

### Failed request

```json
{
  "username": "admin",
  "password": "wrong"
}
```

Expected HTTP status: `401 Unauthorized`

```json
{
  "message": "Authentication Failed"
}
```

## Test with curl

Valid credentials:

```bash
curl -i -X POST http://localhost:8080/api/auth/login-static ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"admin\",\"password\":\"password123\"}"
```

Invalid credentials:

```bash
curl -i -X POST http://localhost:8080/api/auth/login-static ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"admin\",\"password\":\"wrong\"}"
```

On Windows PowerShell, if the `curl` alias causes issues, use `curl.exe` instead.

## Run tests

```bash
mvn test
```

## Important security note
This is an educational demo only. The credentials are intentionally static to demonstrate HTTP responses. Do not use hardcoded passwords for a real application. Production authentication should use a secure user store, password hashing, HTTPS, rate limiting, and an established authentication framework.
