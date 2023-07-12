package org.example.daos;

import org.example.models.Department;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private Connection connection;

    public DepartmentDao(Connection connection) {
        this.connection = connection;
    }


    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM Departments";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("DepartmentID"));
                department.setName(resultSet.getString("DepartmentName"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return departments;
    }


    public Department getDepartmentById(int id) {
        String query = "SELECT * FROM Departments WHERE DepartmentID = ?";
        Department department = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    department = new Department();
                    department.setId(resultSet.getInt("DepartmentID"));
                    department.setName(resultSet.getString("DepartmentName"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return department;
    }


    public void addDepartment(Department department) {
        String query = "INSERT INTO Departments (DepartmentID, DepartmentName) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }


    public void updateDepartment(Department department) {
        String query = "UPDATE Departments SET DepartmentName = ? WHERE DepartmentID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, department.getName());
            statement.setInt(2, department.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }


    public void deleteDepartment(int id) {
        String query = "DELETE FROM Departments WHERE DepartmentID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}
