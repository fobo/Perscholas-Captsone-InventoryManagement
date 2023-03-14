# Warehouse Management System
This is a simple Spring Boot application that manages warehouses, products, and users.

## Features
- User registration
- User login and security
- Admin pages
- Viewing, adding and updating information for warehouses, products, and users

## Technologies Used
- Spring Boot
- MySQL
- Spring Security
- Thymeleaf
- Spring Web
- Spring Data
- Spring Boot DevTools
- Spring Boot Actuator
- Lombok

## Usage
Users can either log in with an existing account of create a new one. By default, they will not have admin access.
The login page is pre-populated with the admin users credentials for ease of testing.
Users can navigate to either the warehouse or products menus at the top of the screen with the navigation bar.
Each option will allow a user to either view, update, delete, or create a new entry.
The admin account can also update all of the above as well as the user details of any other user listed in the database.

## Testing
Testing is done through JUnit which will check against what is inside the database. This checks the service, repo, and entity layers of the project.
They test Users, Companies, and Warehouses.

### Author
Kevin Diehr