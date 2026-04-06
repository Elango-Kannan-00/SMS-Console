# Student Management System - Java Console App

A **Java console-based CRUD application** to manage student records using **JDBC + MySQL**. Built with a clean **3-layer architecture** (Model → DAO → Main), this project demonstrates core Java database connectivity without any web framework.


# About the Project

**SMS-Console** is a terminal-driven Student Management System that lets you perform all CRUD operations — Add, View, Update, and Delete — directly from the console. It uses **JDBC** to connect to a **MySQL** database, reads credentials from an external `db.properties` file to keep sensitive data out of code, and follows a clean package-based project structure.

This is a great beginner-to-intermediate Java project that shows how real-world applications separate concerns across layers.


# Features

- ✅ **Add Student** — Enter name, age, email, and course to register a student
- 📋 **View All Students** — List all student records from the database
- ✏️ **Update Student** — Modify a student's details using their ID
- 🗑️ **Delete Student** — Remove a student record by ID
- 🔐 **Externalized DB Config** — Credentials stored in `db.properties`, not hardcoded
- 🏗️ **DAO Pattern** — Clean separation between database logic and business logic
- 🔄 **Looping Menu** — Interactive CLI menu runs continuously until user exits


# Tech Stack

| Component     | Technology                        |
|---------------|-----------------------------------|
| Language      | Java (JDK 8+)                     |
| Database      | MySQL                             |
| DB Connector  | JDBC (MySQL Connector/J)          |
| Config        | `db.properties` (FileInputStream) |
| Architecture  | DAO + Model + Main (3-layer)      |
| Interface     | Console / Terminal (CLI)          |


# Project Structure

```
SMS-Console/
│
├── src/
│   ├── Main.java                  # Entry point — CLI menu loop
│   │
│   ├── model/
│   │   └── Student.java           # Student POJO (id, name, age, email, course)
│   │
│   ├── dao/
│   │   └── StudentDAO.java        # All CRUD operations via JDBC
│   │
│   ├── db/
│   │   └── DBConnect.java         # Reads db.properties and returns Connection
│   │
│   └── db.properties              # DB URL, username, password (not committed)
```


# Database Setup

### Step 1 — Create the database

```sql
CREATE DATABASE sms;
```

### Step 2 — Select the database

```sql
USE sms;
```

### Step 3 — Create the students table

```sql
CREATE TABLE students (
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100),
    age        INT,
    email      VARCHAR(100),
    course     VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status     VARCHAR(20) DEFAULT 'Active'
);
```


# Prerequisites

Make sure the following are set up on your machine:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- [MySQL Connector/J JAR](https://dev.mysql.com/downloads/connector/j/)
- Any IDE — IntelliJ IDEA, Eclipse, VS Code


# How to Set Up & Run

### 1. Clone the repository

```bash
git clone https://github.com/Elango-Kannan-00/SMS-Console.git
cd SMS-Console
```

### 2. Set up the database

Run the SQL commands from the [Database Setup](#️-database-setup) section in your MySQL Workbench or terminal.

### 3. Configure your DB credentials

Open `src/db.properties` and fill in your MySQL username and password:

```properties
db.url=jdbc:mysql://localhost:3306/sms
db.user=your_mysql_username
db.password=your_mysql_password
```

### 4. Add MySQL Connector/J to your project

- Download the [MySQL Connector/J JAR](https://dev.mysql.com/downloads/connector/j/)
- In **Eclipse**: Right-click project → `Build Path` → `Add External JARs` → select the JAR
- In **IntelliJ**: `File` → `Project Structure` → `Libraries` → `+` → select the JAR

### 5. Run the project

- Open `Main.java`
- Run it as a Java Application
- The console menu will appear:

```
=== Student Management System ===
1. Add Student
2. View All Students
3. Update Student
4. Delete Student
5. Exit
Choose an option:
```


# How It Works

```
User Input (Console)
        │
        ▼
    Main.java  ──── reads input via Scanner
        │
        ▼
  StudentDAO.java  ──── CRUD methods (add / getAll / update / delete)
        │
        ▼
  DBConnect.java  ──── loads db.properties → DriverManager.getConnection()
        │
        ▼
  MySQL Database (sms.students table)
        │
        ▼
  Result printed back to Console
```

### Layer Breakdown

| Layer          | File               | Responsibility                                                   |
|----------------|--------------------|------------------------------------------------------------------|
| **Model**      | `Student.java`     | POJO with fields, constructors, getters/setters, `toString()`   |
| **DAO**        | `StudentDAO.java`  | SQL queries using `PreparedStatement` & `ResultSet`             |
| **DB Utility** | `DBConnect.java`   | Reads `db.properties`, loads JDBC driver, returns `Connection`  |
| **Entry Point**| `Main.java`        | Scanner-based menu loop, ties all layers together                |


# Sample Console Output

```
=== Student Management System ===
1. Add Student
2. View All Students
3. Update Student
4. Delete Student
5. Exit
Choose an option: 1

Name: Elango Kannan
Age: 21
Email: elango@example.com
Course: B.E. Computer Science
Student added successfully!

Choose an option: 2
ID: 1 | Name: Elango Kannan | Age: 21 | Email: elango@example.com | Course: B.E. Computer Science
```


# Important Notes

- **Never commit** `db.properties` with real credentials. Add it to `.gitignore`:
  ```
  src/db.properties
  ```
- `DBConnect.java` uses `FileInputStream("src/db.properties")` — make sure you run the project **from the project root directory**, or update the path accordingly.
- MySQL Connector/J JAR must be in the classpath for the JDBC driver to load successfully.


# Contributing

Pull requests are welcome! For major changes, open an issue first to discuss what you'd like to change.


# Author

**Elango Kannan**  
B.E. Computer Science & Engineering  
[GitHub](https://github.com/Elango-Kannan-00)
