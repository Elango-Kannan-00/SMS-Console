package dao;

import models.Student;
import db.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student s) throws Exception {

        String sql = "INSERT INTO students(name, age, email, gender, phone, year, status, department_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getPhone());
            ps.setInt(6, s.getYear());
            ps.setString(7, s.getStatus());

            if (s.getDepartmentId() != null) {
                ps.setInt(8, s.getDepartmentId());
            } else {
                ps.setNull(8, Types.INTEGER);
            }

            ps.executeUpdate();
        }
    }

    // GET STUDENT BY ID
    public Student getStudentById(int id) throws Exception {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractStudent(rs);
            }
        }
        return null;
    }

    // GET ALL STUDENTS
    public List<Student> getAllStudents() throws Exception {

        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnect.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(extractStudent(rs));
            }
        }
        return list;
    }

    // UPDATE STUDENT
    public void updateStudent(Student s) throws Exception {

        String sql = "UPDATE students SET name=?, age=?, email=?, gender=?, phone=?, year=?, status=?, department_id=? WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getGender());
            ps.setString(5, s.getPhone());
            ps.setInt(6, s.getYear());
            ps.setString(7, s.getStatus());

            if (s.getDepartmentId() != null) {
                ps.setInt(8, s.getDepartmentId());
            } else {
                ps.setNull(8, Types.INTEGER);
            }

            ps.setInt(9, s.getId());

            ps.executeUpdate();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) throws Exception {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // HELPER METHOD
    private Student extractStudent(ResultSet rs) throws Exception {

        Student s = new Student();

        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setAge(rs.getInt("age"));
        s.setEmail(rs.getString("email"));
        s.setGender(rs.getString("gender"));
        s.setPhone(rs.getString("phone"));
        s.setYear(rs.getInt("year"));
        s.setStatus(rs.getString("status"));

        int deptId = rs.getInt("department_id");
        if (rs.wasNull()) {
            s.setDepartmentId(null);
        } else {
            s.setDepartmentId(deptId);
        }

        return s;
    }
}