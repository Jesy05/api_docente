# API Docente

API REST para gestionar docentes, hecha con Spring Boot, Spring Data JPA y PostgreSQL.

## Requisitos

- Java 21
- PostgreSQL con una base de datos llamada `db_docentes`

## Configuración

La contraseña de PostgreSQL no se sube al repositorio. Crea el archivo
`api-docente/src/main/resources/application-local.properties` con:

```properties
spring.datasource.password=TU_CONTRASEÑA
```

La tabla `docentes` se crea sola al arrancar la aplicación.

## Ejecutar

```bash
cd api-docente
./mvnw spring-boot:run
```

La API queda en `http://localhost:8080`.

## Endpoints

| Método | URL | Descripción |
|---|---|---|
| GET | `/api/docentes` | Lista todos los docentes |
| GET | `/api/docentes/{id}` | Obtiene un docente por id |
| POST | `/api/docentes` | Crea un docente |
| PUT | `/api/docentes/{id}` | Actualiza un docente |
| DELETE | `/api/docentes/{id}` | Elimina un docente |

Ejemplo de cuerpo para POST y PUT:

```json
{
  "nombres": "Ana",
  "apellidos": "López",
  "especialidad": "Matemática"
}
```
