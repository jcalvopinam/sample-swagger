Spring-boot with Swagger Sample
---

This is a basic sample of Spring Boot with Swagger, the goal is to describe the structure of the application APIs using swaggers as well as documentation. For to do that I built an application with a RESTful services with the basic CRUD operations, the application is connected to H2 database. With the use of swagger now we can test the different CRUD operations from a friendly webpage.

I used the following technologies:
* Swagger 2.6.1
* Spring Boot 1.5.3.RELEASE
* Spring Data
* H2 Database

How to run?
---

1. Compile the project with the following command:

   ```mvn clean install```

2. The project is a Spring Boot Application, so you can run inside of your ide or from terminal with the following command:

   ```mvn spring-boot:run```

Swagger
---

* You can access from the following URL:

    [http://localhost:8080/contacts/swagger-ui.html][1]


H2 Database
---

* If you prefer you can use any database client, else, you can access from the following URL:

1. Go to: [http://localhost:8080/contacts/h2-console][2]
2. Setting the following parameters:
```
Driver class : org.h2.Driver
JDBC URL     : jdbc:h2:mem:test
User Name    : sa
Password     :
```
3. Click on `Test Connection` button, this should return `Test successful`
4. Click on `Connect` button.
5. Now you can see the `CONTACT` table.


[1]: http://localhost:8080/contacts/swagger-ui.html
[2]: http://localhost:8080/contacts/h2-console
