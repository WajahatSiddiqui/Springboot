# Movies DB Application

connects to MySQL database using JPA to access movies table
Uses Hibernate ORM

MySQL commands to create movies table under spring_mysql_jpa_demo database
----------------------------------------------------------------------------
$ create database spring_mysql_jpa_demo database;
$ use spring_mysql_jpa_demo database;
$ create table movie (movie_id int primary key auto_increment, movie_name varchar(200), movie_year int);
$ insert into movie values (100, 'Sultan', 2016);
$ insert into movie values (101, 'Ek tha tiger', 2014);
$ insert into movie values (103, 'Bahubali', 2014);


The following endpoints are exposed:

GET         /movies                 get all movies
GET         /movies/{moviesId}      get movie with {movieId}
POST        /movies                 create a movie and add it to db
PUT         /movies                 Updates a given movie
DELETE      /movies/{moviesId}      Deletes movie with {movieId}