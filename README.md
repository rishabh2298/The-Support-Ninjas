# # REST API for Online Customer Service Support (Support Ninjas) .

<img
  align="right"
        width="25%"
        src="https://github.com/rishabh2298/vacuous-quartz-2667/blob/main/Support%20Ninjas.png"
        alt=""
      />
Online Customer Service is defined as any service that helps customers solve problems via the internet. This is done by customer support agents, whose primary goal is to assist customers. Such a service is usually connected to a business or brand which sells products and offers support.

This is a collaborative project, completed by a team of 4 backend developers.

# Tech Stack

- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger UI

# Services

- Admin service
- Operator Service
- Customer Service

# Installation & Run

- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8088

    spring.datasource.url=jdbc:mysql://localhost:3306/supportninjas;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint

```
https://localhost:7272/
```

```
http://localhost:7272/swagger-ui/
```

# ER Diagram

<img src="https://user-images.githubusercontent.com/104244053/221412046-dcf761cd-e3cf-4ed8-a80e-946f31d54bb6.png" >

# Swagger Home UI (Controllers & Schema)



# Collaborators

- [Roshni Gupta](https://github.com/guptaroshni)
- [Rishabh Mishra](https://github.com/rishabh2298)

  Thanks for visiting !
