package dao;

import models.Marks;
import db.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarksDAO {

    // ADD MARKS
    public void addMarks(Marks m) throws Exception {

        String sql = "INSERT INTO marks(student_id, subject_id, exam_type, marks) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, m.getStudentId());
            ps.setInt(2, m.getSubjectId());
            ps.setString(3, m.getExamType());
            ps.setInt(4, m.getMarks());

            ps.executeUpdate();
        }
    }

    // GET MARKS BY STUDENT
    public List<Marks> getMarksByStudent(int studentId) throws Exception {

        List<Marks> list = new ArrayList<>();
        String sql = "SELECT * FROM marks WHERE student_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractMarks(rs));
            }
        }
        return list;
    }

    // GET MARKS BY STUDENT + SUBJECT
    public List<Marks> getMarksByStudentAndSubject(int studentId, int subjectId) throws Exception {

        List<Marks> list = new ArrayList<>();
        String sql = "SELECT * FROM marks WHERE student_id=? AND subject_id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, subjectId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractMarks(rs));
            }
        }
        return list;
    }

    // HELPER METHOD
    private Marks extractMarks(ResultSet rs) throws Exception {

        Marks m = new Marks();

        m.setId(rs.getInt("id"));
        m.setStudentId(rs.getInt("student_id"));
        m.setSubjectId(rs.getInt("subject_id"));
        m.setExamType(rs.getString("exam_type"));
        m.setMarks(rs.getInt("marks"));

        return m;
    }
}