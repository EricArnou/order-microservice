<h1>Order Microservice</h1>

# About

This project consists of creating an ordering microservice from a RabbitMq queue and returns information in a Rest API.
The information returned is: a list of orders from a specific customer, total order value and order quantity

## Table of Contents
    - Technologies
    - Usage
    - API EndPoint
    - Queue Template
    - License
## Technologies
    - Java 21
    - SpringBoot
    - Mongo
    - RabbitMQ
    - Docker
## Usage

Build RabbitMq and MongoDB containers with docker-compose.yml with:
```
docker compose up
```
If everything goes well, you can interact with RabbitMQ in the port 15672.
Use 'guest' for username and password.

For interact with the database you can use [MongoDB Compass](https://www.mongodb.com/try/download/compass)

## API EndPoint

```
/customers/{customerId}/orders
```

## Queue Template
```
{
    "codigoPedido": 1001,
    "codigoCliente":1,
    "itens": [
    {
        "produto": "lápis",
        "quantidade": 100,
        "preco": 1.10
    },
    {
        "produto": "caderno",
        "quantidade": 10,
        "preco": 1.00
    }
   ]
}
```
## License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/EricArnou/order-microservice/blob/main/LICENSE) file for details.


