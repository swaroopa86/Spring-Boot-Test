#Spring Boot sample

Build Restful CRUD API for a simple Telecom application using Spring Boot, Mysql, JPA.

Requirements
Java - 1.8.x

Maven - 3.x.x

Mysql - 5.x.x

Steps to Setup
1. Clone the application

git clone https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial.git
2. Create Mysql database

create database and_test
3. Create Tables Schemamysql> desc customer;
+-------+--------------+------+-----+---------+-------+
| Field | Type         | Null | Key | Default | Extra |
+-------+--------------+------+-----+---------+-------+
| id    | int(11)      | NO   | PRI | NULL    |       |
| name  | varchar(30)  | YES  |     | NULL    |       |
| email | varchar(100) | YES  |     | NULL    |       |
+-------+--------------+------+-----+---------+-------+
3 rows in set (0.03 sec)

mysql> desc phone_number;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| id       | int(11)     | NO   | PRI | NULL    |       |
| phoneno  | bigint(20)  | YES  |     | NULL    |       |
| activate | varchar(30) | YES  |     | NULL    |       |
| custId   | int(11)     | YES  | MUL | NULL    |       |
+----------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

4. Change mysql username and password as per your installation

open src/main/resources/application.properties

change spring.datasource.username and spring.datasource.password as per your mysql installation

5. Build and run the app using maven

mvn package
java -jar target/REST_API
Alternatively, you can run the app without packaging it using -

mvn spring-boot:run
The app will start running at http://localhost:8080.

You can test them using postman or any other rest client.
