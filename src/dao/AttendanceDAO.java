package dao;

import models.Attendance;
import db.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    // MARK ATTENDANCE
    public void markAttendance(Attendance a) throws Exception {

        String sql = "INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, a.getStudentId());
            ps.setDate(2, a.getDate());
            ps.setString(3, a.getStatus());

            ps.executeUpdate();
        }
    }

    // GET ATTENDANCE BY STUDENT
    public List<Attendance> getAttendanceByStudent(int studentId) throws Exception {

        List<Attendance> list = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE student_id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractAttendance(rs));
            }
        }
        return list;
    }

    // COUNT PRESENT DAYS
    public int getPresentDays(int studentId) throws Exception {

        String sql = "SELECT COUNT(*) FROM attendance WHERE student_id=? AND status='Present'";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    // COUNT TOTAL DAYS
    public int getTotalDays(int studentId) throws Exception {

        String sql = "SELECT COUNT(*) FROM attendance WHERE student_id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    // HELPER METHOD
    private Attendance extractAttendance(ResultSet rs) throws Exception {

        Attendance a = new Attendance();

        a.setId(rs.getInt("id"));
        a.setStudentId(rs.getInt("student_id"));
        a.setDate(rs.getDate("date"));
        a.setStatus(rs.getString("status"));

        return a;
    }
}