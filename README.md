# REST API for Online Customer Service Support (Support Ninjas) .

<img
  align="right"
        width="20%"
        src="https://github.com/rishabh2298/vacuous-quartz-2667/blob/main/SupportNinjas.png"
        alt=""
      />
Online Customer Service is defined as any service that helps customers solve problems via the internet. This is done by customer support agents, whose primary goal is to assist customers. Such a service is usually connected to a business or brand which sells products and offers support.

This is a collaborative project, completed by a team of 2 backend developers.

## Tech Stack

- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger UI

## Modules
- Login Module
- Admin Module
- Operator Module
- Customer Module

# ER Diagram

<img src="https://user-images.githubusercontent.com/104244053/221412046-dcf761cd-e3cf-4ed8-a80e-946f31d54bb6.png" >

## Features
```
Admin Features:
- Register operator and department.
- Get List of all operators working.
- Remove operator and department.
```
```
Operator Fetures:
- LogIn/Logout with unique sessionId.
- Can add new Issue for customer.
- Send mail to customer.
- Check weather customer is under his/her service or not.
```
```
Customer Features:
- LogIn/Logout with unique sessionId.
- Get unique OTP to if forget password.
- Change password with unique OTP.
- View all issues and can reopen it.
```
## Swagger Home UI (Controllers & Schema)



## Installation & Run

- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=7070

    spring.datasource.url=jdbc:mysql://localhost:3306/support_ninjas
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint

```
https://localhost:7070/
```

```
http://localhost:7070/swagger-ui/index.html
```

## Collaborators

- [Roshni Gupta](https://github.com/guptaroshni)
- [Rishabh Mishra](https://github.com/rishabh2298)

  Thanks for visiting !
