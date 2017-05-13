# Reservation Service

A simple reservation service which stores reservation id and reservation name
in H2 database using JPA

This application uses RestRepository to allow Spring generate the hypermedia endpoints
HATEOAS (Hypermedia as the engine of application state
Every rest resource should have the information of the resource so that the client can easily access it

RestRepository provides the following functionality by default:

http://localhost:8080/reservations?page=0&size=2
http://localhost:8080/reservations/search/by-name?name=Raj

Demonstrates the following Spring Dependencies
    1) Web
    2) Actuator
    3) JPA
    4) H2
    5) Thymleaf
    7) Vaadin
    8) RestRepository
    9) HAL Browser

Exposes the following endpoints

Endpoint        Method  Description
---------       ------  ------------
/reservations   GET     get all reservation names


# Thymleaf
Creates MVC Controller and uses Thymleaf for rendering data in html

#Vaadin
its build on top of webtoolkit
