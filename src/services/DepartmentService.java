package services;

import dao.DepartmentDAO;
import models.Department;

import java.util.List;

public class DepartmentService {

    private DepartmentDAO dao = new DepartmentDAO();

    // ADD
    public void addDepartment(Department d) throws Exception {

        if (d.getName() == null || d.getName().trim().isEmpty()) {
            throw new Exception("Department name cannot be empty");
        }

        dao.addDepartment(d);
    }

    // GET BY ID
    public Department getDepartment(int id) throws Exception {
        return dao.getDepartmentById(id);
    }

    // GET ALL
    public List<Department> getAllDepartments() throws Exception {
        return dao.getAllDepartments();
    }

    // UPDATE
    public void updateDepartment(Department d) throws Exception {

        if (d.getId() <= 0) {
            throw new Exception("Invalid department ID");
        }

        dao.updateDepartment(d);
    }

    // DELETE
    public void deleteDepartment(int id) throws Exception {
        dao.deleteDepartment(id);
    }

    public Department getDepartmentByName(String name) throws Exception {
        return dao.getDepartmentByName(name);
    }

}