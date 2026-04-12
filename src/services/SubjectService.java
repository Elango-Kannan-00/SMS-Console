package services;

import dao.SubjectDAO;
import models.Subject;

import java.util.List;

public class SubjectService {

    private SubjectDAO dao = new SubjectDAO();

    // ADD
    public void addSubject(Subject s) throws Exception {

        if (s.getName() == null || s.getName().trim().isEmpty()) {
            throw new Exception("Subject name cannot be empty");
        }

        if (s.getDepartmentId() <= 0) {
            throw new Exception("Invalid department ID");
        }

        dao.addSubject(s);
    }

    // GET BY ID
    public Subject getSubject(int id) throws Exception {
        return dao.getSubjectById(id);
    }

    // GET ALL
    public List<Subject> getAllSubjects() throws Exception {
        return dao.getAllSubjects();
    }

    // GET BY DEPARTMENT
    public List<Subject> getSubjectsByDepartment(int departmentId) throws Exception {
        return dao.getSubjectsByDepartment(departmentId);
    }

    // UPDATE
    public void updateSubject(Subject s) throws Exception {

        if (s.getId() <= 0) {
            throw new Exception("Invalid subject ID");
        }

        dao.updateSubject(s);
    }

    // DELETE
    public void deleteSubject(int id) throws Exception {
        dao.deleteSubject(id);
    }
}