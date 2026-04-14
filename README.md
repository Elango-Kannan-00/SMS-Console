# Student Management System (Console, Java + JDBC)

A console-based Student Management System (SMS) built with Java, JDBC, and MySQL. The project follows a clean layered structure (models -> dao -> services -> Main) and demonstrates CRUD operations with a simple CLI.

# Features

- Manage students, departments, subjects, marks, and attendance
- Add records from the console menu
- View a student by ID
- Attendance percentage calculation
- JDBC-based persistence with a MySQL database
- Externalized database configuration in `src/db/db.properties`

# Tech Stack

- Java (JDK 8+)
- MySQL
- JDBC (MySQL Connector/J)

# Project Structure

```
SMS-Console/
|
|-- src/
|   |-- Main.java
|   |-- models/
|   |   |-- Student.java
|   |   |-- Department.java
|   |   |-- Subject.java
|   |   |-- Marks.java
|   |   |-- Attendance.java
|   |
|   |-- dao/
|   |   |-- StudentDAO.java
|   |   |-- DepartmentDAO.java
|   |   |-- SubjectDAO.java
|   |   |-- MarksDAO.java
|   |   |-- AttendanceDAO.java
|   |
|   |-- services/
|   |   |-- StudentService.java
|   |   |-- DepartmentService.java
|   |   |-- SubjectService.java
|   |   |-- MarksService.java
|   |   |-- AttendanceService.java
|   |
|   |-- db/
|   |   |-- DBConnect.java
|   |   |-- db.properties
|
|-- lib/
|-- bin/
```

# Database Setup

Create a database and tables that match the DAO layer.

```sql
CREATE DATABASE sms;
USE sms;

CREATE TABLE departments (
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE students (
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(100) NOT NULL,
    age            INT,
    email          VARCHAR(100),
    gender         VARCHAR(20),
    phone          VARCHAR(30),
    year           INT,
    status         VARCHAR(20) DEFAULT 'Active',
    department_id  INT,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE subjects (
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(100) NOT NULL,
    department_id  INT NOT NULL,
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

CREATE TABLE marks (
    id         INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    exam_type  VARCHAR(50),
    marks      INT,
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (subject_id) REFERENCES subjects(id)
);

CREATE TABLE attendance (
    id         INT PRIMARY KEY AUTO_INCREMENT,
    student_id INT NOT NULL,
    date       DATE,
    status     VARCHAR(20),
    FOREIGN KEY (student_id) REFERENCES students(id)
);
```

# Configuration

Edit `src/db/db.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/sms
db.user=your_mysql_username
db.password=your_mysql_password
```

# Build and Run

Place the MySQL Connector/J jar in `lib/` or use any path you prefer.

PowerShell:

```powershell
$env:MYSQL_JAR="lib\mysql-connector-j-8.4.0.jar"
javac -cp ".;$env:MYSQL_JAR" -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object FullName)
java -cp "bin;$env:MYSQL_JAR" Main
```

macOS/Linux:

```bash
MYSQL_JAR="lib/mysql-connector-j-8.4.0.jar"
javac -cp ".:$MYSQL_JAR" -d bin $(find src -name "*.java")
java -cp "bin:$MYSQL_JAR" Main
```

# Notes

- Run the app from the project root so `DBConnect.java` can read `src/db/db.properties`.
- Ensure the MySQL Connector/J jar is on the classpath.
- Keep real credentials out of version control.

# Sample Output

```
===== STUDENT MANAGEMENT SYSTEM =====
1. Add Student
2. View Student
3. Add Department
4. Add Subject
5. Add Marks
6. Mark Attendance
7. View Attendance %
8. Exit
Enter choice:
```