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

## Ejecutar el proyecto (Docker recomendado)

Este proyecto está preparado para ejecutarse con Docker (app + PostgreSQL).

1. Requisitos:
   - Docker Desktop instalado y corriendo.

2. Construir y levantar contenedores:
   ```bash
   docker compose up --build
   ```

3. Abrir Swagger UI:
   - `http://localhost:8080/swagger-ui.html`

4. Cuando termines, detener contenedores:
   ```bash
   docker compose down
   ```

## Ejecución local (alternativa, sin Docker)

1. Requisitos:
   - PostgreSQL local funcionando.
   - Java 17 instalado.

2. Configurar variables de entorno:
   - `DB_URL` (default: `jdbc:postgresql://localhost:5432/bookingsystem`)
   - `DB_USER` (default: `postgres`)
   - `DB_PASSWORD` (default: `postgres`)

3. Levantar backend:
   ```bash
   ./mvnw spring-boot:run
   ```

## Tests

```bash
./mvnw test
```


