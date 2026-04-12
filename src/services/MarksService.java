package services;

import dao.MarksDAO;
import models.Marks;

import java.util.List;

public class MarksService {

    private MarksDAO dao = new MarksDAO();

    // ADD MARKS
    public void addMarks(Marks m) throws Exception {

        if (m.getStudentId() <= 0 || m.getSubjectId() <= 0) {
            throw new Exception("Invalid student or subject ID");
        }

        if (m.getMarks() < 0 || m.getMarks() > 100) {
            throw new Exception("Marks must be between 0 and 100");
        }

        if (m.getExamType() == null || m.getExamType().isEmpty()) {
            throw new Exception("Exam type is required");
        }

        dao.addMarks(m);
    }

    // GET MARKS
    public List<Marks> getMarksByStudent(int studentId) throws Exception {
        return dao.getMarksByStudent(studentId);
    }

    // CALCULATE AVERAGE
    public double calculateAverage(int studentId) throws Exception {

        List<Marks> list = dao.getMarksByStudent(studentId);

        if (list.isEmpty()) return 0;

        int total = 0;

        for (Marks m : list) {
            total += m.getMarks();
        }

        return total * 1.0 / list.size();
    }

    // CALCULATE GRADE
    public String calculateGrade(int marks) {

        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 50) return "C";
        return "F";
    }
}