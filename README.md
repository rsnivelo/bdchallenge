
# Challenge

Hi, I'm Santiago

Follow the instructions to run the project

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)
- [Docker](https://www.docker.com/products/docker-desktop/)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.appleindustries.challenge.AppleChallengeApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## API Endpoints

### GET
`Mirror, mirror on the screen` [/api/mirror/any phrase](localhost:8080/api/mirror/) reverse words of a sentence

### POST
`I'm feeling lucky`

[/api/customer](localhost:8080/api/customer/) creates a customer

**Request**

```
{
    "name": "Chris",
    "email": "chris@mail.com"
}
```
**Response**

```
{
    customer-uuid
}
```
[/api/order](localhost:8080/api/order) create an order, if another order is created within the same hour, it gives other packages for free.

**Request**

```
{
    "customerId": "f49b9487-a0fa-42f8-af9a-6906be9cec38",
    "packageId": "773139ce-9cd8-4efc-bc7e-94292a26c2f9"
}
```
**Response**

```
{
    "id": "9b8463ce-4af9-4f2c-8c11-21c010a4ca4c",
    "creationDate": "2023-09-02",
    "total": null,
    "orderDetailList": [
        {
            "id": "773139ce-9cd8-4efc-bc7e-94292a26c2f9",
            "photoPackage": null
        }
    ]
}
```

### GET
`Only two things in life are guaranteed...`

[/api/irs?date=2023-09-01](localhost:8080/api/irs?date=) returns the tax of a specific month (yyyy-MM-dd)

**Request**

```
localhost:8080/api/irs?date=2023-09-01

```
**Response**
tax generated
```
1.03
```

