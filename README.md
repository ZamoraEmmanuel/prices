# _Challenge_
## Prices Backend
_Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta_

## Features

- Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
- Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
 

## Tech

- JAVA 8
- Spring boot
- Mapstruct
- Lombok
- H2
- JPA
- Hibernate
- Maven


# REST API

A continuacion se describe la API REST

## Obtener la tarifa para un producto de una cadena en una fecha dada

### CURL Request

`curl -X GET http://localhost:8080/api/prices/1/35455/2020-06-14%2010:00:00`

### Response
```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "startDate": "2020-06-14T00:00:00Z",
    "endDate": "2020-12-31T23:59:59Z",
    "price": 35.5
}
```

### Request

`GET /api/prices/1/35455/2020-06-16 21:00:00`

### Response
```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 4,
    "startDate": "2020-06-15T16:00:00Z",
    "endDate": "2020-12-31T23:59:59Z",
    "price": 38.95
}
```

# Run tests
``` mvnw test ```
