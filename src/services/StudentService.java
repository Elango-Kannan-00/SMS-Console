package services;

import dao.StudentDAO;
import models.Student;

import java.util.List;

public class StudentService {

    private StudentDAO dao = new StudentDAO();

    // ADD STUDENT
    public void addStudent(Student s) throws Exception {

        if (s.getName() == null || s.getName().trim().isEmpty()) {
            throw new Exception("Name cannot be empty");
        }

        if (s.getAge() <= 0) {
            throw new Exception("Invalid age");
        }

        if (s.getEmail() == null || !s.getEmail().contains("@")) {
            throw new Exception("Invalid email");
        }

        dao.addStudent(s);
    }

    // GET STUDENT
    public Student getStudent(int id) throws Exception {
        return dao.getStudentById(id);
    }

    // GET ALL
    public List<Student> getAllStudents() throws Exception {
        return dao.getAllStudents();
    }

    // UPDATE
    public void updateStudent(Student s) throws Exception {
        if (s.getId() <= 0) {
            throw new Exception("Invalid student ID");
        }
        dao.updateStudent(s);
    }

    // DELETE
    public void deleteStudent(int id) throws Exception {
        dao.deleteStudent(id);
    }
}