# 💼 JobApp - Spring Boot Backend Project

JobApp is a backend application built with **Spring Boot** that manages job postings using basic **CRUD** operations. The application is connected to a **PostgreSQL** database and provides a RESTful API to interact with the data. It supports full job management: create, read, update, delete, and search functionalities.

---

## ✅ Features

- 🔁 CRUD Operations for job postings
- 🔍 Search jobs by keyword (in description or profile)
- 🧾 Load predefined jobs for testing
- 🌐 CORS enabled to support frontend development (e.g., React)
- 📦 Built with Spring Boot, JPA, and PostgreSQL
- 🧩 Modular and clean architecture using service and repository layers

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

---

## ⚙️ Setup Instructions (Run on Any Machine)

### 🔁 1. Clone the Repository


git clone https://github.com/Divyansh0319/Jobapp.git

cd Jobapp



Make sure PostgreSQL is installed on your system. Then:

Open pgAdmin or a terminal.

Run the following SQL:CREATE DATABASE springboottester;

Go to: src/main/resources/application.properties
# Application Name
spring.application.name=spring-boot-rest-1

# PostgreSQL Connection

spring.datasource.url=jdbc:postgresql://localhost:5432/springboottester

spring.datasource.username=postgres

spring.datasource.password=YOUR_DB_PASSWORD

spring.datasource.driver-class-name=org.postgresql.Driver


# JPA & Hibernate
spring.jpa.hibernate.ddl-auto=update

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format_sql=true

spring.jpa.properties.hibernate.highlight_sql=true

# SQL Initialization

spring.sql.init.mode=always

# Logging
logging.level.org.springframework.jdbc.core=DEBUG

logging.level.org.springframework.jdbc.datasource=DEBUG




⚠️ Change spring.datasource.username and spring.datasource.password as per your local PostgreSQL credentials

▶️ 4. Run the Application
You can run the project using any of these methods:

📦 Using Maven:
./mvnw spring-boot:run
🧠 Or from an IDE (like IntelliJ / Eclipse):
Open the project

Run the main class: SpringBootRest1Application.java

📡 5. Test the Endpoints
Sample Endpoints:
| HTTP Method | Endpoint                      | Description                   |
| ----------- | ----------------------------- | ----------------------------- |
| `GET`       | `/jobPosts`                   | Get all job posts             |
| `POST`      | `/jobPost`                    | Create a new job post         |
| `GET`       | `/jobPost/{id}`               | Get job post by ID            |
| `PUT`       | `/jobPost/{id}`               | Update job post               |
| `DELETE`    | `/jobPost/{id}`               | Delete job post by ID         |
| `GET`       | `/jobPosts/keyword/{keyword}` | Search job posts by keyword   |
| `GET`       | `/load`                       | Load default job post entries |


💡 How to Use
You can connect this backend to any frontend (like React). If your frontend runs on http://localhost:3000, the backend has CORS enabled for it.

Example frontend request using axios:

axios.get("http://localhost:8080/jobPosts").then(response => {
  console.log(response.data);
});


📌 Additional Notes
CORS is enabled in the controller using:
@CrossOrigin(origins = "http://localhost:3000")


## 🙌 Author

- **Divyansh Agrawal**
- [GitHub Profile] :  (https://github.com/Divyansh0319)







