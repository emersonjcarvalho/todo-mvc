
MYSQL/MADIADB COMMANDS -----------------------------------------------------

CREATE DATABASE todo_mvc CHARACTER SET utf8 COLLATE utf8_general_ci;

use todo_mvc;

CREATE TABLE todo_mvc.todo(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,    
    completed BIT,
    order_todo INTEGER,
	PRIMARY KEY (id)
);

-----------------------------------------------------


mvn clean

mvn install

java -jar target\todo-mvc-0.0.1-SNAPSHOT.jar

