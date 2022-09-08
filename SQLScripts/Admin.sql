use adminstration;

DROP TABLE IF EXISTS admins;

CREATE TABLE `admins` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `first_Name` VARCHAR(50) NOT NULL,
    `last_Name` VARCHAR(50) NOT NULL,
    `password` varchar(128) NOT NULL UNIQUE,
    `email` varchar(120) NOT NULL UNIQUE,
    `admin_Id` varchar(50) NOT NULL UNIQUE,
     PRIMARY KEY (`id`)

);

SELECT * FROM admins;

/*
DUMMY DATA

REGISTER:

{
    "firstName" : "John",
    "lastName" : "Doe",
    "password" : "password123",
    "email" : "john@gmail.com"
}

LOGIN:

{
    "email" : "john@gmail.com",
    "password" : "password123"

}

*/