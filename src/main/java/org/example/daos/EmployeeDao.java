package org.example.daos;

import org.example.models.Department;
import org.example.models.Employee;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private Connection connection;

    public EmployeeDao(Connection connection) {
        this.connection = connection;
    }


    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("EmployeeID"));
                employee.setFirstName(resultSet.getString("FirstName"));
                employee.setLastName(resultSet.getString("LastName"));
                employee.setEmail(resultSet.getString("Email"));
                // Retrieve department information if applicable
                int departmentId = resultSet.getInt("DepartmentID");
                if (!resultSet.wasNull()) {
                    Department department = new DepartmentDao(this.connection).getDepartmentById(departmentId);
                    employee.setDepartment(department);
                }
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return employees;
    }


    public Employee getEmployeeById(int id) {
        String query = "SELECT * FROM Employees WHERE EmployeeID = ?";
        Employee employee = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee();
                    employee.setId(resultSet.getInt("EmployeeID"));
                    employee.setFirstName(resultSet.getString("FirstName"));
                    employee.setLastName(resultSet.getString("LastName"));
                    employee.setEmail(resultSet.getString("Email"));
                    // Retrieve department information if applicable
                    int departmentId = resultSet.getInt("DepartmentID");
                    if (!resultSet.wasNull()) {
                        Department department = new DepartmentDao(this.connection).getDepartmentById(departmentId);
                        employee.setDepartment(department);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return employee;
    }


    public void addEmployee(Employee employee) {
        String query = "INSERT INTO Employees (EmployeeID, FirstName, LastName, Email, DepartmentID) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getEmail());
            Department department = employee.getDepartment();
            if (department != null) {
                statement.setInt(5, department.getId());
            } else {
                statement.setNull(5, Types.INTEGER);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }


    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employees SET FirstName = ?, LastName = ?, Email = ?, DepartmentID = ? WHERE EmployeeID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            Department department = employee.getDepartment();
            if (department != null) {
                statement.setInt(4, department.getId());
            } else {
                statement.setNull(4, Types.INTEGER);
            }
            statement.setInt(5, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public void deleteEmployee(int id) {
        String query = "DELETE FROM Employees WHERE EmployeeID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}


