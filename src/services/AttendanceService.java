package services;

import dao.AttendanceDAO;
import models.Attendance;

import java.util.List;

public class AttendanceService {

    private AttendanceDAO dao = new AttendanceDAO();

    // MARK ATTENDANCE
    public void markAttendance(Attendance a) throws Exception {

        if (a.getStudentId() <= 0) {
            throw new Exception("Invalid student ID");
        }

        if (a.getDate() == null) {
            throw new Exception("Date cannot be null");
        }

        if (a.getStatus() == null || a.getStatus().isEmpty()) {
            throw new Exception("Status is required");
        }

        dao.markAttendance(a);
    }

    // GET STUDENT ATTENDANCE
    public List<Attendance> getAttendance(int studentId) throws Exception {
        return dao.getAttendanceByStudent(studentId);
    }

    // CALCULATE ATTENDANCE %
    public double calculateAttendancePercentage(int studentId) throws Exception {

        int present = dao.getPresentDays(studentId);
        int total = dao.getTotalDays(studentId);

        if (total == 0) return 0;

        return (present * 100.0) / total;
    }
}