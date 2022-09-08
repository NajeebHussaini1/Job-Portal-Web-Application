use employers;

DROP TABLE IF EXISTS employer;

CREATE TABLE `employer` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `company_Name` varchar(50) NOT NULL,
    `password` varchar(128) NOT NULL UNIQUE,
    `email` varchar(120) NOT NULL UNIQUE,
    `employer_Id` varchar(50) NOT NULL UNIQUE,
    `category` varchar(50) NOT NULL,
    `about` varchar(250),
     PRIMARY KEY (`id`)
);

SELECT * FROM employer;

/*
DUMMY DATA

REGISTER:

{
    "companyName" : "CGI",
    "password" : "cgi123",
    "email" : "john@cgi.com",
    "category" : "Technology",
    "about" : "IT Consulting Services"

}

LOGIN:

{
    "email" : "john@cgi.com",
    "password" : "cgi123"

}

*/