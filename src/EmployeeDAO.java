import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(Employee employee) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO employees (name, age, department, salary) VALUES (?, ?, ?, ?)";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Employee added successfully!");
            }

        } catch (SQLException e) {
            System.out.println(" Error adding employee");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception e) {
            }
        }
    }

    public Employee getEmployee(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE id = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id); // Set the ID

            rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                employee = new Employee(id, name, age, department, salary);
            }

        } catch (SQLException e) {
            System.out.println(" Error retrieving employee with id: " + id);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
            }
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception e) {
            }
        }

        return employee;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM employees";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                Employee emp = new Employee(id, name, age, department, salary);
                employees.add(emp);
            }
        } catch (SQLException e) {
            System.out.println(" Error retrieving all employees.");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (Exception e) {
            }
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception e) {
            }
        }

        return employees;
    }

    public void updateEmployee(Employee employee) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE employees SET name = ?, age = ?, department = ?, salary = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, employee.getName());
            ps.setInt(2, employee.getAge());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getId());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" Employee updated successfully!");
            } else {
                System.out.println("⚠ No employee found with ID: " + employee.getId());
            }
        } catch (SQLException e) {
            System.out.println(" Error updating employee.");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteEmployee(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM employees WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Employee deleted successfully!");
            } else {
                System.out.println("⚠️ No employee found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error deleting employee.");
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) {
            }
            try {
                if (con != null) con.close();
            } catch (Exception e) {
            }
        }
    }


}

