BookingSystem

Sistema de reservas de canchas.

## Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL

## Endpoints

- `POST /users`
- `POST /courts`
- `GET /courts`
- `POST /reservations`
- `GET /reservations`

## Manejo de errores

Las respuestas de error siguen este formato:

```json
{
  "code": "SOME_CODE",
  "message": "Human readable message",
  "status": 404,
  "path": "/endpoint"
}
```

## Swagger (documentación)

Abre:

- `http://localhost:8080/swagger-ui.html`

## Postman (colección de pruebas)

La colección está en:

- `postman/bookingsystem.postman_collection.json`

Notas importantes:
- La colección sigue el flujo recomendado:
  - `POST /users` (setea `userId`)
  - `POST /courts` (setea `courtId`)
  - `POST /reservations` (crea la reserva usando `userId` y `courtId`)

## Ejecutar el proyecto (paso a paso)

1. Requisitos:
   - Tener un PostgreSQL funcionando.
   - Java 17 instalado.

2. Configura conexión a PostgreSQL con variables de entorno (recomendado):
   - `DB_URL` (default: `jdbc:postgresql://localhost:5432/bookingsystem`)
   - `DB_USER` (default: `postgres`)
   - `DB_PASSWORD` (default: `postgres`)

3. Levanta el backend:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Swagger:
   - `http://localhost:8080/swagger-ui.html`

5. Tests:
   ```bash
   ./mvnw test
   ```

## Docker

1. Construir y levantar (incluye PostgreSQL):
   ```bash
   docker compose up --build
   ```
2. Abrir Swagger UI:
   - `http://localhost:8080/swagger-ui.html`


