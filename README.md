# EcommerceApp

This project contains the backend of PerfilTic Dev Test

## Development server

Run `mvn clean install && java -jar target/ecommerce-0.0.1-SNAPSHOT.jar` for a dev environment. Navigate to `http://localhost:8080/`.

## Build

Run `mvn clean install` to build the project. 

## Run

Run `java -jar target/ecommerce-0.0.1-SNAPSHOT.jar` to run the project. 


## Stop

press `Ctrl + c` to stop the project. 

# Docker

## Build

Run `docker build -t perfiltic/ecommerce .`.

## Run

Run `docker run -p 8080:8080 -t perfiltic/ecommerce`.

## Consume API

# Endpoints

# Category
* GET  /api/category -> get all categories
* GET  /api/category/id -> get categories by id
* DELETE  /api/category/id -> delete categories by id
* POST /api/category -> create a category
* PUT /api/category -> update a category

# SubCategory
* GET  /api/SubCategory -> get all SubCategory
* GET  /api/SubCategory/id -> get SubCategory by id
* DELETE  /api/SubCategory/id -> delete SubCategory by id
* POST /api/SubCategory -> create a SubCategory
* PUT /api/SubCategory -> update a SubCategory

# Product
* GET  /api/Product -> get all Product
* GET  /api/Product/id -> get Product by id
* DELETE  /api/Product/id -> delete Product by id
* POST /api/Product -> create a Product
* PUT /api/Product -> update a Product


## POST /api/category

Body ```json
  {
    "name":"Tecnologia",
    "photo":"asdasd125-asdasd21-adas21"
  }
	 ```
   
   ## POST /api/SubCategory

Body ```json
  {
    "name":"PC Gamer",
    "category":{"id":2}
  }
	 ```
   
   ## POST /api/Product

Body ```json
  {
    "name":"christian",
    "description":"el mejor programador del mundo",
    "weight":20.5,
    "price":1500.00,
    "photo":"4as5d4a-as4d5ad-asd654",
    "subCategory": {"id" : 6}
  }
	 ```

