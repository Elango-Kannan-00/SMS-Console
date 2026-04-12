package dao;

import models.Department;
import db.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {

    // ADD DEPARTMENT
    public void addDepartment(Department d) throws Exception {

        String sql = "INSERT INTO departments(name) VALUES (?)";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.executeUpdate();
        }
    }

    // GET BY ID
    public Department getDepartmentById(int id) throws Exception {

        String sql = "SELECT * FROM departments WHERE id = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractDepartment(rs);
            }
        }
        return null;
    }

    // GET ALL
    public List<Department> getAllDepartments() throws Exception {

        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM departments";

        try (Connection con = DBConnect.getConnection();
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(extractDepartment(rs));
            }
        }
        return list;
    }

    // UPDATE
    public void updateDepartment(Department d) throws Exception {

        String sql = "UPDATE departments SET name=? WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getName());
            ps.setInt(2, d.getId());

            ps.executeUpdate();
        }
    }

    // DELETE
    public void deleteDepartment(int id) throws Exception {

        String sql = "DELETE FROM departments WHERE id=?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // HELPER METHOD
    private Department extractDepartment(ResultSet rs) throws Exception {

        Department d = new Department();

        d.setId(rs.getInt("id"));
        d.setName(rs.getString("name"));

        return d;
    }

    public Department getDepartmentByName(String name) throws Exception {

    String sql = "SELECT * FROM departments WHERE name = ?";

    try (Connection con = DBConnect.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return extractDepartment(rs);
        }
    }
    return null;
}

}