# Insurance-dbms

# Overview:
The Insurance Management System is a comprehensive web-based application designed to streamline the management of insurance-related tasks. It facilitates efficient handling of member information, policy details, claims processing, and the relationships between these entities. This system is particularly suited for insurance companies looking to digitalize their operations and improve overall efficiency.

# Features:
- Member Management: Create, view, update, and delete members' details.
- Policy Management: Manage different types of insurance policies, customize policy details, and manage premiums.
- Member Policies: Associate members with specific policies, manage policy status, and maintain active records.
- Claims Management: Process claims, from filing to resolution, and maintain a history of all claims associated with members and policies.

# Technologies Used:

- Backend*: Java with Spring Boot
- Frontend*: Thymeleaf for server-side rendering, integrated with Spring Boot
- Database*: MySQL
- Build Tool*: Maven
- Styling*: CSS

# Project Structure:

├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── insurance
│   │   │               ├── controller
│   │   │               ├── model
│   │   │               ├── repository
│   │   │               ├── service
│   │   │               └── InsuranceApplication.java
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   └── *.html
│   │   │   ├── static
│   │   │   │   └── css
│   │   │   │       └── style.css
│   │   │   └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── insurance
└── pom.xml

# Prerequisites:
- Java JDK 11 or newer
- Maven 3.6 or newer
- MySQL 8.0 or newer

# Setup Instructions

1. *Clone the Repository*
   bash
   git clone https://github.com/anuhyab05/insurance-management-system.git
   cd insurance-management-system
   

2. *Database Configuration*
   - Create a new MySQL database named insurance.
   - Import the schema.sql file to set up your database schema.

3. *Configure Application*
   - Open src/main/resources/application.properties.
   - Set your database username and password:
     properties
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     

4. *Build and Run the Application*
   bash
   mvn spring-boot:run
   

5. *Access the Application*
   - Open your web browser and go to http://localhost:8080 to start using the application.

# How to Use

Navigate through the application using the main menu on the homepage. Each section provides forms for entering and managing data, and tables for viewing the records.

- *Members*: Add new members and manage existing member records.
- *Policies*: Create and edit insurance policies.
- *Member Policies*: Link members to policies and manage these relationships.
- *Claims*: File new claims and update the status of existing claims.

# Contributions

Contributions are welcome! For major changes, please open an issue first to discuss what you would like to change. Ensure to update tests as appropriate.

# License

Distributed under the MIT License. See LICENSE for more information.
