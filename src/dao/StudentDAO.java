package dao;
import db.DBConnect;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add Student
    public void addStudent(Student student) {
    String sql = "INSERT INTO students(name, age, email, course) VALUES (?, ?, ?, ?)";

    try (Connection conn = DBConnect.getConnection()) {

        if (conn == null) {
            System.out.println("Database connection failed!");
            return;
        }

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getEmail());
        ps.setString(4, student.getCourse());

        ps.executeUpdate();
        System.out.println("Student added successfully!");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // View All Students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnect.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("course")
                );
                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update Student
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name=?, age=?, email=?, course=? WHERE id=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getCourse());
            ps.setInt(5, student.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Student updated successfully!");
            else System.out.println("Student ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Student deleted successfully!");
            else System.out.println("Student ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}