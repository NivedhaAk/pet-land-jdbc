# Pet Land - Java JDBC Application
Java 17 JDBC Application for managing pet owners and their pets.

## Overview
Pet Land is a simple Java JDBC console application that allows users to:
- Add new pet owners
- Fetch owner details
- Update pet details
- Delete owner records
- Search owners by email and pet's date of birth

## Technologies Used
- Java 17
- JDBC API
- MySQL Database
- MySQL Connector/J (Version 9.2.0)

## Database Setup
- Import the `database.sql` file provided in the project into your MySQL Workbench to create the owner table.
- Update the `database.properties` file with your local database URL, username, and password.

## How to Run
1. Clone the repository.
2. Configure your IDE (like IntelliJ IDEA or Eclipse).
3. Add MySQL Connector/J (9.2.0) to the project libraries.(configure build path and in libraries add in classpath)
4. Update database credentials inside `database.properties`.
5. Run the `Main.java` file.

## Author
Nivedha Sankaran
