# EcommerceApp

This project contains the backend of PerfilTic Dev Test

## Development server

Run `./mvn clean install && java -jar target/ecommerce-0.0.1-SNAPSHOT.jar` for a dev environment. Navigate to `http://localhost:8080/`.

## Build

Run `./mvn clean install` to build the project. 

## Run

Run `java -jar target/ecommerce-0.0.1-SNAPSHOT.jar` to run the project. 

# Docker

## Build

Run `docker build -t perfiltic/ecommerce .`.

## Run

Run `docker run -p 8080:8080 -t perfiltic/ecommerce`.

## Consume API

Run `curl -H "Content-Type: application/json" -H "Authorization: Bearer {TOKEN}" -X METHOD -d {JSON BODY} http://localhost:8080/path/to/rest`.

## Example

Run `curl -H "Content-Type: application/json" -H "Authorization: Bearer eyJ..." -X POST -d {\"username\":\"admin\",\"password\":\"admin\",\"email\":\"admin@perfiltic.co\"} http://localhost:8080/api/user`.


# Endpoints

# Category
* POST /api/category -> create a category
* GET  /api/category -> get all categories

## POST /api/category

Body ```json
	  {
		"name":"Christian",
		"x": "admin"
	  }
	 ```
