package dao;

import models.Subject;
import db.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO {

    // ADD SUBJECT
    public void addSubject(Subject s) throws Exception {

        String sql = "INSERT INTO subjects(name, department_id) VALUES (?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getDepartmentId());

            ps.executeUpdate();
        }
    }

    // GET BY ID
    public Subject getSubjectById(int id) throws Exception {

        String sql = "SELECT * FROM subjects WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractSubject(rs);
            }
        }
        return null;
    }

    // GET ALL
    public List<Subject> getAllSubjects() throws Exception {

        List<Subject> list = new ArrayList<>();
        String sql = "SELECT * FROM subjects";

        try (Connection con = DBConnect.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(extractSubject(rs));
            }
        }
        return list;
    }

    // GET SUBJECTS BY DEPARTMENT
    public List<Subject> getSubjectsByDepartment(int departmentId) throws Exception {

        List<Subject> list = new ArrayList<>();
        String sql = "SELECT * FROM subjects WHERE department_id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractSubject(rs));
            }
        }
        return list;
    }

    // UPDATE
    public void updateSubject(Subject s) throws Exception {

        String sql = "UPDATE subjects SET name=?, department_id=? WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getDepartmentId());
            ps.setInt(3, s.getId());

            ps.executeUpdate();
        }
    }

    // DELETE
    public void deleteSubject(int id) throws Exception {

        String sql = "DELETE FROM subjects WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // HELPER METHOD
    private Subject extractSubject(ResultSet rs) throws Exception {

        Subject s = new Subject();

        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));
        s.setDepartmentId(rs.getInt("department_id"));

        return s;
    }
}