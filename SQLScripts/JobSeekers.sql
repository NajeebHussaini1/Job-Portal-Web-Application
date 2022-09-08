use jobseekers;

DROP TABLE IF EXISTS job_seeker;

CREATE TABLE `job_seeker` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `first_Name` VARCHAR(50) NOT NULL,
    `last_Name` VARCHAR(50) NOT NULL,
    `password` varchar(128) NOT NULL UNIQUE,
    `email` varchar(120) NOT NULL UNIQUE,
    `user_Name` VARCHAR(50) NOT NULL UNIQUE,
    `user_Id` varchar(50) NOT NULL UNIQUE,
    `gender` VARCHAR(10),
    `phone_Number` VARCHAR(12),
    `city` VARCHAR(50) NOT NULL,
    `province` VARCHAR(2) NOT NULL,
     PRIMARY KEY (`id`)
);

SELECT * FROM job_seeker;

/*
DUMMY DATA

REGISTER:

{
    "firstName" : "John",
    "lastName" : "Doe",
    "password" : "password123",
    "email" : "john@gmail.com",
    "userName" : "john123",
    "gender" : "male",
    "phoneNumber" : "444-888-9999",
    "city" : "Toronto",
    "province" : "ON"

}

LOGIN:

{
    "email" : "john@gmail.com",
    "password" : "password123"

}

*/