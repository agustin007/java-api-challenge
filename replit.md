# API de Productos - Spring Boot

## Overview
Esta es una API REST de Spring Boot que proporciona operaciones CRUD para productos. La aplicación incluye:
- Java 19 (GraalVM)
- Spring Boot 3.2.5
- H2 in-memory database
- Maven para gestión de dependencias
- Lógica de negocio con cálculo de descuentos

## Project Structure
- `src/main/java/com/hackerrank/sample/` - Código fuente principal
  - `controller/` - Endpoints REST API
  - `service/` - Capa de lógica de negocio
  - `repository/` - Capa de acceso a datos
  - `model/` - Entidades JPA
  - `exception/` - Excepciones personalizadas
- `src/main/resources/` - Archivos de configuración
- `src/test/` - Archivos de test

## Modelo de Datos: Product (Producto)

### Atributos
- `id` (Long) - Identificador único
- `title` (String) - Título del producto
- `description` (String) - Descripción del producto
- `price` (Double) - Precio original
- `category` (String) - Categoría (ej: "Electronics", "Furniture")
- `condition` (String) - Condición ("new" o "used")
- `thumbnailUrl` (String) - URL de la imagen miniatura
- `discountPrice` (Double) - Precio con descuento (calculado automáticamente)

### Lógica de Descuentos
El sistema calcula automáticamente el precio con descuento basándose en:
- **Productos usados:** 15% de descuento
- **Categoría Electronics:** 10% de descuento
- **Precio mayor a $100:** 5% de descuento
- Se aplica el descuento máximo cuando múltiples condiciones aplican

**Ejemplos:**
- Laptop usada, Electronics, $500 → discountPrice: $425 (15% descuento)
- Silla nueva, Furniture, $150 → discountPrice: $142.5 (5% descuento por precio >$100)
- Mouse nuevo, Electronics, $25 → discountPrice: $22.5 (10% descuento por categoría)

## API Endpoints

### Home
- `GET /` - Retorna mensaje de bienvenida

### Productos
- `POST /product` - Crear un producto nuevo (requiere JSON body)
- `GET /product` - Obtener todos los productos (incluye discountPrice calculado)
- `GET /product/{id}` - Obtener producto por ID (incluye discountPrice calculado)
- `DELETE /product/{id}` - Eliminar producto por ID
- `DELETE /erase` - Eliminar todos los productos

### Base de Datos
- `GET /h2-console` - Consola H2 (para debugging)

## Ejemplo de Uso

```bash
# Crear un producto
curl -X POST http://localhost:5000/product \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "title": "Laptop HP",
    "description": "Laptop usada en excelente estado",
    "price": 500.0,
    "category": "Electronics",
    "condition": "used",
    "thumbnailUrl": "https://example.com/laptop.jpg"
  }'

# Ver todos los productos
curl http://localhost:5000/product

# Ver un producto específico
curl http://localhost:5000/product/1
```

## Database
La aplicación usa una base de datos H2 en memoria configurada para:
- Ejecutarse al inicio y persistir durante el runtime
- Crear esquema automáticamente desde las entidades
- Accesible vía consola H2 en `/h2-console`

## Desarrollo
La aplicación corre en puerto 5000 y se vincula a 0.0.0.0 para compatibilidad con Replit.

## Build & Run
- Build: `mvn clean package`
- Run: `mvn spring-boot:run`
- Test: `mvn test`

## Recent Changes
- 2025-11-05: Refactorización a sistema de Productos
  - Renombrado Model a Product con nuevos atributos
  - Agregados atributos: title, description, price, category, condition, thumbnailUrl
  - Implementada lógica de descuentos automáticos en ProductService
  - Campo calculado discountPrice basado en reglas de negocio
  - Actualizados todos los controllers, services y repositories

- 2025-11-04: Setup inicial para entorno Replit
  - Configurado compatibilidad con Java 19 (downgrade desde Java 21)
  - Creado application.properties con configuración de servidor y BD
  - Implementados métodos de controller para llamar capa de servicio
  - Configurada BD H2 con settings de conexión apropiados
  - Configurado workflow para correr en puerto 5000
