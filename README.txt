# 🧩 Java API Challenge – Products API

Este proyecto forma parte del desafío técnico de HackerRank.  
La arquitectura base ya estaba provista y seguía una estructura típica de Spring Boot con las capas **controller → service → repository → model**, que fue la correcta para este tipo de aplicación.  

Mi trabajo consistió en **completar las implementaciones faltantes**, **ajustar el modelo** para que represente un producto real y **agregar cierta lógica de negocio adicional** dentro del servicio.

---

## ⚙️ Stack utilizado
- **Java 17**  
- **Spring Boot 3**  
- **Maven**  
- **Spring Web**  
- **Spring Data JPA**  
- **H2 Database** (en memoria, para simplificar las pruebas)

---

## 🧱 Arquitectura
La API sigue un enfoque por capas:  

- **Controller** → expone los endpoints REST y maneja las peticiones HTTP.  
- **Service** → contiene la lógica de negocio (por ejemplo, el cálculo de `priceDiscount`).  
- **Repository** → se comunica con la base de datos mediante JPA.  
- **Model** → define la estructura de los objetos `Product`.  

---

## 🧠 Cambios realizados
- Se **modificó el modelo `Product`** agregando campos más realistas:  
  - `id`, `name`, `description`, `price`, `category`.  
- Se **implementaron los métodos** del `ProductController` que no estaban completos.  
- En el **servicio**, se agregó una lógica de ejemplo para aplicar un **descuento sobre el precio** (`priceDiscount`).  
- Se configuró **H2** como base de datos en memoria para simplificar las pruebas y evitar dependencias externas.  
- Además, se utilizó la plataforma **[Replit](https://replit.com)** para desarrollar y testear el proyecto de forma rápida, aprovechando la posibilidad de integrar herramientas asistidas y ejecutar el código en un entorno cloud antes de realizar el push final al repositorio de HackerRank.

---

## 🚀 Endpoints principales
| Método | Endpoint | Descripción |
|--------|-----------|-------------|
| **GET** | `/products` | Devuelve la lista de productos |
| **GET** | `/products/{id}` | Obtiene un producto por ID |
| **POST** | `/products` | Crea un nuevo producto |
| **PUT** | `/products/{id}` | Actualiza un producto existente |
| **DELETE** | `/products/{id}` | Elimina un producto por su ID |

---

## 🧩 Ejemplo rápido
```bash
# Crear un producto
curl -X POST -H "Content-Type: application/json"   -d '{"name": "Laptop", "description": "Gaming 16GB RAM", "price": 1200.5, "category": "Electronics"}'   http://localhost:8080/products
```

---

## ▶️ Cómo ejecutarlo
1. Cloná el repo:
   ```bash
   git clone <URL_DEL_REPO>
   cd java-api-challenge
   ```
2. Ejecutá:
   ```bash
   mvn spring-boot:run
   ```
3. La API estará disponible en  
   👉 `http://localhost:8080/products`
